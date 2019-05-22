package io.github.pactstart.system.service.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import io.github.pactstart.biz.common.utils.LevelUtil;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.system.dao.SysAclMapper;
import io.github.pactstart.system.dao.SysAclModuleMapper;
import io.github.pactstart.system.dao.SysDeptMapper;
import io.github.pactstart.system.dto.adapt.SysAclAdaptDto;
import io.github.pactstart.system.dto.adapt.SysAclModuleAdaptDto;
import io.github.pactstart.system.dto.adapt.SysDeptAdaptDto;
import io.github.pactstart.system.entity.SysAcl;
import io.github.pactstart.system.entity.SysAclModule;
import io.github.pactstart.system.entity.SysDept;
import io.github.pactstart.system.service.SysCoreService;
import io.github.pactstart.system.service.SysTreeService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SysTreeServiceImpl implements SysTreeService {

    @Autowired
    private SysCoreService sysCoreService;

    @Autowired
    private SysAclModuleMapper sysAclModuleMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private SysAclMapper sysAclMapper;

    private Comparator<SysDeptAdaptDto> deptSeqComparator = new Comparator<SysDeptAdaptDto>() {
        public int compare(SysDeptAdaptDto o1, SysDeptAdaptDto o2) {
            return o1.getSeq() - o2.getSeq();
        }
    };

    private Comparator<SysAclModuleAdaptDto> aclModuleSeqComparator = new Comparator<SysAclModuleAdaptDto>() {
        public int compare(SysAclModuleAdaptDto o1, SysAclModuleAdaptDto o2) {
            return o1.getSeq() - o2.getSeq();
        }
    };

    private Comparator<SysAclAdaptDto> aclSeqComparator = new Comparator<SysAclAdaptDto>() {
        public int compare(SysAclAdaptDto o1, SysAclAdaptDto o2) {
            return o1.getSeq() - o2.getSeq();
        }
    };

    @Override
    public List<SysAclModuleAdaptDto> roleTree(Integer roleId, Integer userId) {
        // 1、当前用户已分配的权限点
        List<SysAcl> userAclList = sysCoreService.getUserAclList(userId);
        // 2、当前角色分配的权限点
        List<SysAcl> roleAclList = sysCoreService.getRoleAclList(roleId);
        // 3、当前系统所有权限点
        List<SysAcl> allAclList = sysAclMapper.selectAll();
        List<SysAclAdaptDto> aclAdaptDtoList = MapperUtils.mapList(allAclList, SysAclAdaptDto.class);

        Set<Integer> userAclIdSet = userAclList.stream().map(sysAcl -> sysAcl.getId()).collect(Collectors.toSet());
        Set<Integer> roleAclIdSet = roleAclList.stream().map(sysAcl -> sysAcl.getId()).collect(Collectors.toSet());

        for (SysAclAdaptDto acl : aclAdaptDtoList) {
            if (userAclIdSet.contains(acl.getId())) {
                acl.setHasAcl(true);
            }
            if (roleAclIdSet.contains(acl.getId())) {
                acl.setChecked(true);
            }
        }
        return aclListToTree(aclAdaptDtoList);
    }

    @Override
    public List<SysAclModuleAdaptDto> userAclTree(int userId) {
        List<SysAcl> userAclList = sysCoreService.getUserAclList(userId);
        List<SysAclAdaptDto> aclAdaptDtoList = MapperUtils.mapList(userAclList, SysAclAdaptDto.class);
        for (SysAclAdaptDto acl : aclAdaptDtoList) {
            acl.setHasAcl(true);
            acl.setChecked(true);
        }
        return aclListToTree(aclAdaptDtoList);
    }

    @Override
    public List<SysAclModuleAdaptDto> roleAclTree(Integer roleId) {
        // 1、当前角色分配的权限点
        List<SysAcl> roleAclList = sysCoreService.getRoleAclList(roleId);
        Set<Integer> roleAclIdSet = roleAclList.stream().map(sysAcl -> sysAcl.getId()).collect(Collectors.toSet());
        // 2、当前系统所有权限点
        List<SysAcl> allAclList = sysAclMapper.selectAll();
        List<SysAclAdaptDto> aclAdaptDtoList = MapperUtils.mapList(allAclList, SysAclAdaptDto.class);
        //3、设置选中
        for (SysAclAdaptDto acl : aclAdaptDtoList) {
            if (roleAclIdSet.contains(acl.getId())) {
                acl.setChecked(true);
            }
        }
        //4、转换为树
        return aclListToTree(aclAdaptDtoList);
    }

    @Override
    public List<SysAclModuleAdaptDto> aclModuleTree() {
        List<SysAclModule> aclModuleList = sysAclModuleMapper.getAllAclModule();
        List<SysAclModuleAdaptDto> dtoList = MapperUtils.mapList(aclModuleList, SysAclModuleAdaptDto.class);
        return aclModuleListToTree(dtoList);
    }

    @Override
    public List<SysDeptAdaptDto> deptTree() {
        List<SysDept> deptList = sysDeptMapper.selectAll();
        List<SysDeptAdaptDto> deptAdaptDtoList = MapperUtils.mapList(deptList, SysDeptAdaptDto.class);
        return deptListToTree(deptAdaptDtoList);
    }

    private List<SysAclModuleAdaptDto> aclListToTree(List<SysAclAdaptDto> aclAdaptDtoList) {
        if (CollectionUtils.isEmpty(aclAdaptDtoList)) {
            return Lists.newArrayList();
        }
        //获取权限模块树
        List<SysAclModuleAdaptDto> aclModuleLevelList = aclModuleTree();
        //建立权限模块和权限点的映射关系
        Multimap<Integer, SysAclAdaptDto> moduleIdAclMap = ArrayListMultimap.create();
        for (SysAclAdaptDto acl : aclAdaptDtoList) {
            if (acl.getStatus() == 1) {
                moduleIdAclMap.put(acl.getAclModuleId(), acl);
            }
        }
        bindAclsWithOrder(aclModuleLevelList, moduleIdAclMap);
        return aclModuleLevelList;
    }

    private void bindAclsWithOrder(List<SysAclModuleAdaptDto> aclModuleLevelList, Multimap<Integer, SysAclAdaptDto> moduleIdAclMap) {
        if (CollectionUtils.isEmpty(aclModuleLevelList)) {
            return;
        }
        //递归遍历所有权限模块，获取Map中获取当前权限模块的所有权限点并排序，排序后添加进权限模块中
        for (SysAclModuleAdaptDto moduleAdaptDto : aclModuleLevelList) {
            List<SysAclAdaptDto> aclAdaptDtoList = (List<SysAclAdaptDto>) moduleIdAclMap.get(moduleAdaptDto.getId());
            if (CollectionUtils.isNotEmpty(aclAdaptDtoList)) {
                Collections.sort(aclAdaptDtoList, aclSeqComparator);
                moduleAdaptDto.setAclList(aclAdaptDtoList);
            }
            bindAclsWithOrder(moduleAdaptDto.getAclModuleList(), moduleIdAclMap);
        }
    }

    private List<SysAclModuleAdaptDto> aclModuleListToTree(List<SysAclModuleAdaptDto> aclModuleAdaptDtoList) {
        if (CollectionUtils.isEmpty(aclModuleAdaptDtoList)) {
            return Lists.newArrayList();
        }
        // 按模块层级建立映射关系
        // level -> [aclmodule1, aclmodule2, ...] Map<String, List<Object>>
        Multimap<String, SysAclModuleAdaptDto> levelAclModuleMap = ArrayListMultimap.create();
        //模块层级树的根节点
        List<SysAclModuleAdaptDto> rootList = Lists.newArrayList();
        //获取所有根节点
        for (SysAclModuleAdaptDto dto : aclModuleAdaptDtoList) {
            levelAclModuleMap.put(dto.getLevel(), dto);
            if (LevelUtil.ROOT.equals(dto.getLevel())) {
                rootList.add(dto);
            }
        }
        // 权限模块排序
        Collections.sort(rootList, aclModuleSeqComparator);
        transformAclModuleTree(rootList, LevelUtil.ROOT, levelAclModuleMap);
        return rootList;
    }

    private void transformAclModuleTree(List<SysAclModuleAdaptDto> moduleAdaptDtoList, String level, Multimap<String, SysAclModuleAdaptDto> levelAclModuleMap) {
        //遍历根节点
        for (SysAclModuleAdaptDto moduleAdaptDto : moduleAdaptDtoList) {
            //计算下一层级
            String nextLevel = LevelUtil.calculateLevel(level, moduleAdaptDto.getId());
            //获取下一层级的所有节点
            List<SysAclModuleAdaptDto> tempList = (List<SysAclModuleAdaptDto>) levelAclModuleMap.get(nextLevel);
            //排序并递归
            if (CollectionUtils.isNotEmpty(tempList)) {
                Collections.sort(tempList, aclModuleSeqComparator);
                moduleAdaptDto.setAclModuleList(tempList);
                transformAclModuleTree(tempList, nextLevel, levelAclModuleMap);
            }
        }
    }

    private List<SysDeptAdaptDto> deptListToTree(List<SysDeptAdaptDto> deptLevelList) {
        SysDeptAdaptDto defaultDept = SysDeptAdaptDto.newDefault();
        if (CollectionUtils.isEmpty(deptLevelList)) {
            return Lists.newArrayList(defaultDept);
        }
        //建立层级与部门的映射关系
        // level -> [dept1, dept2, ...] Map<String, List<Object>>
        Multimap<String, SysDeptAdaptDto> levelDeptMap = ArrayListMultimap.create();
        List<SysDeptAdaptDto> rootList = Lists.newArrayList();
        rootList.add(defaultDept);
        //获取所有部门根节点
        for (SysDeptAdaptDto dto : deptLevelList) {
            levelDeptMap.put(dto.getLevel(), dto);
            if (LevelUtil.ROOT.equals(dto.getLevel())) {
                rootList.add(dto);
            }
        }
        // 按照seq从小到大排序
        Collections.sort(rootList, deptSeqComparator);
        // 递归生成树
        transformDeptTree(rootList, LevelUtil.ROOT, levelDeptMap);
        return rootList;
    }

    private void transformDeptTree(List<SysDeptAdaptDto> deptAdaptDtoList, String level, Multimap<String, SysDeptAdaptDto> levelDeptMap) {
        // 遍历该层的每个元素
        for (SysDeptAdaptDto deptAdaptDto : deptAdaptDtoList) {
            // 处理当前层级的数据
            String nextLevel = LevelUtil.calculateLevel(level, deptAdaptDto.getId());
            // 处理下一层
            List<SysDeptAdaptDto> tempDeptList = (List<SysDeptAdaptDto>) levelDeptMap.get(nextLevel);
            if (CollectionUtils.isNotEmpty(tempDeptList)) {
                // 排序
                Collections.sort(tempDeptList, deptSeqComparator);
                // 设置下一层部门
                deptAdaptDto.setDeptList(tempDeptList);
                // 进入到下一层处理
                transformDeptTree(tempDeptList, nextLevel, levelDeptMap);
            }
        }
    }
}
