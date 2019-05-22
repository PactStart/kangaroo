package io.github.pactstart.service.dispatcher.dispatcher;

import com.google.common.collect.Lists;
import io.github.pactstart.service.dispatcher.api.ApiTree;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceDispatcherHolder {

    private static final Map<String, ServiceDispatcher> GROUP_DISPATCHER_MAP = new ConcurrentHashMap();

    public static void addProxy(String group, ServiceDispatcher dispatcher) {
        GROUP_DISPATCHER_MAP.put(group, dispatcher);
    }

    public static ServiceDispatcher getDispatcher(String group) {
        return GROUP_DISPATCHER_MAP.get(group);
    }

    public static List<ApiTree> getApiTree() {
        List<ApiTree> apiTreeList = Lists.newArrayList();
        GROUP_DISPATCHER_MAP.forEach((k, v) -> {
            ApiTree apiTree = new ApiTree();
            apiTree.setGroup(k);
            apiTree.setModuleList(Lists.newArrayList(getDispatcher(k).getApiModuleMap().values()));
            apiTreeList.add(apiTree);
        });
        return apiTreeList;
    }

    public static Set<String> getAllGroups() {
        return GROUP_DISPATCHER_MAP.keySet();
    }
}
