package io.github.pactstart.simple.web.framework.dozer;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfiguration {

    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {
    /*List<String> mappingFiles = Arrays.asList(
      "dozer-global-configuration.xml", 
      "dozer-bean-mappings.xml",
      "more-dozer-bean-mappings.xml"
    );*/

        DozerBeanMapper dozerBean = new DozerBeanMapper();
//    dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }
}