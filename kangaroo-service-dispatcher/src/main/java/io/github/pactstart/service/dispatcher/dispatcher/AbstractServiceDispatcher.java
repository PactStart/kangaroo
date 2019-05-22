package io.github.pactstart.service.dispatcher.dispatcher;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.github.pactstart.commonutils.ValidUtils;
import io.github.pactstart.service.dispatcher.annotation.ServiceApi;
import io.github.pactstart.service.dispatcher.api.ApiInterface;
import io.github.pactstart.service.dispatcher.api.ApiModule;
import io.github.pactstart.service.dispatcher.executor.MethodParamParser;
import io.github.pactstart.service.dispatcher.executor.ServiceApiExecutor;
import io.github.pactstart.service.dispatcher.executor.ServiceApiExecutorHolder;
import io.github.pactstart.service.dispatcher.request.ServiceApiRequest;
import io.github.pactstart.service.dispatcher.response.ServiceApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractServiceDispatcher implements ServiceDispatcher, ApplicationContextAware, InitializingBean {

    private static final String[] WEB_ENVIRONMENT_CLASSES = {"javax.servlet.Servlet",
            "org.springframework.web.context.ConfigurableWebApplicationContext"};
    protected ApplicationContext applicationContext;
    protected MethodParamParser paramParser;
    protected boolean webEnvironment;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    private Map<String, ApiModule> moduleApisMap = Maps.newConcurrentMap();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        this.paramParser = initMethodParamParser();
        initServerApiExecutorHolder();
        this.webEnvironment = deduceWebEnvironment();
        initProxyService();
    }

    private void initServerApiExecutorHolder() {
        Map<String, Object> clientApiMap = this.applicationContext.getBeansWithAnnotation(ServiceApi.class);
        if (!CollectionUtils.isEmpty(clientApiMap)) {
            Iterator<Map.Entry<String, Object>> iterator = clientApiMap.entrySet().iterator();
            String group = getGroup();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();

                Object bean = entry.getValue();
                Class clazz = bean.getClass();
                ServiceApi serviceApi = (ServiceApi) clazz.getAnnotation(ServiceApi.class);

                if (group.equals(serviceApi.group())) {
                    String prefixCmd = serviceApi.group().concat("/").concat(serviceApi.value()).replaceAll("/{2}+", "/");
                    List<ApiInterface> apiInterfaceList = ServiceApiExecutorHolder.addServiceBean(bean, clazz, serviceApi, prefixCmd, paramParser);

                    String module = ValidUtils.isValid(serviceApi.notes()) ? serviceApi.notes() : bean.getClass().getSimpleName();
                    apiInterfaceList.forEach(apiInterface -> {
                        apiInterface.setGroup(group);
                        apiInterface.setModule(module);

                    });

                    ApiModule apiModule = new ApiModule();
                    apiModule.setModule(module);
                    apiModule.setInterfaceList(apiInterfaceList);
                    moduleApisMap.put(module, apiModule);
                }
            }
        }
    }

    @Override
    public ServiceApiResponse dispatch(ServiceApiRequest request) throws Exception {
        ServiceApiExecutor executor = ServiceApiExecutorHolder.getClientApiExecutor(request.getCmd());
        ServiceApiResponse response = new ServiceApiResponse();

        Exception tx = null;
        Object result = null;
        try {
            boolean allow = preHandle(request, response, executor);
            if (allow) {
                result = executor.invoke(request);
                response.setResult(result);
            }
        } catch (Exception ex) {
            tx = ex;
        } finally {
            postHandle(request, response, executor, result);
            afterCompletion(request, response, executor, tx);
        }
        return response;
    }

    private boolean deduceWebEnvironment() {
        for (String className : WEB_ENVIRONMENT_CLASSES) {
            if (!ClassUtils.isPresent(className, null)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Map<String, ApiModule> getApiModuleMap() {
        return moduleApisMap;
    }

    @Override
    public List<ApiInterface> getApis() {
        List<ApiInterface> allApis = Lists.newArrayList();
        moduleApisMap.forEach((k, v) -> {
            allApis.addAll(v.getInterfaceList());
        });
        return allApis;
    }

    /**
     * 供子类覆盖实现
     */
    protected void initProxyService() {
        ServiceDispatcherHolder.addProxy(getGroup(), this);
    }

    protected abstract String getGroup();

    protected abstract MethodParamParser initMethodParamParser();

    protected abstract boolean preHandle(ServiceApiRequest request, ServiceApiResponse response, ServiceApiExecutor executor) throws Exception;

    protected abstract void postHandle(ServiceApiRequest request, ServiceApiResponse response, ServiceApiExecutor executor, Object result) throws Exception;

    protected abstract void afterCompletion(ServiceApiRequest request, ServiceApiResponse response, ServiceApiExecutor executor, Exception ex) throws Exception;

    public boolean isWebEnvironment() {
        return webEnvironment;
    }
}
