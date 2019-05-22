package io.github.pactstart.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.biz.common.utils.PageUtils;
import io.github.pactstart.commonutils.ValidUtils;
import io.github.pactstart.system.dao.SysVersionMapper;
import io.github.pactstart.system.dto.SysVersionDto;
import io.github.pactstart.system.dto.SysVersionQueryDto;
import io.github.pactstart.system.entity.SysVersion;
import io.github.pactstart.system.service.SysVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysVersionServiceImpl implements SysVersionService {

    @Autowired
    private SysVersionMapper sysVersionMapper;

    @Override
    public void add(SysVersionDto sysVersionDto) {
        SysVersion sysVersion = MapperUtils.map(sysVersionDto, SysVersion.class);
        sysVersion.setOperateTime(new Date());
        sysVersionMapper.insertSelective(sysVersion);
    }

    @Override
    public void update(SysVersionDto sysVersionDto) {
        SysVersion before = sysVersionMapper.selectByPrimaryKey(sysVersionDto.getId());
        if (before == null) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "您要修改的版本不存在");
        }
        SysVersion after = SysVersion.builder().id(before.getId()).status(sysVersionDto.getStatus())
                .versionName(sysVersionDto.getVersionName()).versionSeq(sysVersionDto.getVersionSeq())
                .gitTag(sysVersionDto.getGitTag()).compatible(sysVersionDto.getCompatible()).forceUpdate(sysVersionDto.getForceUpdate())
                .versionSummary(sysVersionDto.getVersionSummary()).versionDetail(sysVersionDto.getVersionDetail())
                .versionTime(sysVersionDto.getVersionTime()).downloadUrl(sysVersionDto.getDownloadUrl()).attachs(sysVersionDto.getAttachs())
                .operateTime(new Date()).operator(sysVersionDto.getOperator()).build();
        sysVersionMapper.updateByPrimaryKeySelective(after);
    }

    @Override
    public PageResultDto<SysVersionDto> query(SysVersionQueryDto sysVersionQueryDto) {
        Page<SysVersion> page = PageHelper.startPage(sysVersionQueryDto.getPageNum(), sysVersionQueryDto.getPageSize())
                .doSelectPage(() -> sysVersionMapper.query(sysVersionQueryDto));
        return PageUtils.convert(page, SysVersionDto.class);
    }

    @Override
    public SysVersionDto getNewestVersion(SysVersionQueryDto sysVersionQueryDto) {
        List<SysVersion> sysVersionList = sysVersionMapper.query(sysVersionQueryDto);
        if (ValidUtils.isValid(sysVersionList)) {
            return MapperUtils.map(sysVersionList.get(0), SysVersionDto.class);
        }
        return null;
    }
}
