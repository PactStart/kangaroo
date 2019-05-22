## User Guide
If you want need web functionality, follow below steps:

1. add a maven dependency in your pom.xml
```xml
<dependency>
    <groupId>io.github.pactstart</groupId>
    <artifactId>kangaroo-simple-web-framework</artifactId>
    <version>x.x.x</version>
</dependency>
```
2. config component scann base packages (important)
```java
@SpringBootApplication
@ComponentScan(basePackages = {"io.github.pactstart"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```
3. supported config in application.properties:
```properteis
application.web.framework.servlet-request-wrapper-enabled=true
application.web.framework.enable-ajax=false
application.web.framework.anon-urls=/sys/user/login.json
application.web.framework.auth-url=http://localhost:8081
application.web.framework.enable-acl=false
application.web.framework.acl-exclusion-urls=/**
application.web.framework.cors-enabled=true
application.web.framework.cors.allow-origins=http://localhost:8081
application.web.framework.cors.allow-credentials=true
application.web.framework.cors.allow-methods=OPTIONS,POST,GET,PUT,DELETE
application.web.framework.cors.max-age=86400
application.web.framework.api-info.version=1.0
application.web.framework.api-info.title=kangaroo
application.web.framework.api-info.description=kangaroo
application.web.framework.api-info.termsOfServiceUrl=https://github.com/PactStart/kangaroo
application.web.framework.api-info.contact.name=rex.lei
application.web.framework.api-info.contact.url=weixin:pactrex
application.web.framework.api-info.contact.email=1203208955@qq.com
application.web.framework.redis.serializeType=fastjson
```
---
If you want integrate a manage backend quickly , follow below steps:

1. add this dependency in you pom.xml
```xml
<dependency>
    <groupId>io.github.pactstart</groupId>
    <artifactId>kangaroo-web-admin</artifactId>
    <version>x.x.x</version>
</dependency>
```
2. config scann base packages (important)
```java
//@EnableJPush
@SpringBootApplication
@ComponentScan(basePackages = {"io.github.pactstart","your.other.scann.packages"})
@MapperScan(basePackages = {"io.github.pactstart.system.dao","your.other.mapper.locations"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```
3. execute init.sql

4. config swagger api doc
```java
@Configuration
@EnableConfigurationProperties(SwaggerDocConfig.class)
@EnableSwagger2
public class Swagger2Config {

    @Autowired
    private SwaggerDocConfig swaggerDocConfig;

    @Bean
    public Docket systemApiDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("系统API接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.github.pactstart.admin.system.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    
    @Bean
    public Docket systemApiDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("your business")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("your.business.controller.path"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerDocConfig.getTitle())
                .description(swaggerDocConfig.getDescription())
                .termsOfServiceUrl(swaggerDocConfig.getTermsOfServiceUrl())
                .license(swaggerDocConfig.getLicense())
                .licenseUrl(swaggerDocConfig.getLicenseUrl())
                .contact(new Contact(swaggerDocConfig.getName(), swaggerDocConfig.getUrl(), swaggerDocConfig.getEmail()))
                .version(swaggerDocConfig.getVersion())
                .build();
    }

}
```
---
a completed application.properties example:
```properties
server.port=8080
banner.charset=UTF-8
server.tomcat.uri-encoding=UTF-8
spring.http.encoding.charset=UTF-8
spring.http.encoding.enabled=true
spring.http.encoding.force=true
spring.messages.encoding=UTF-8
server.session.timeout=86400
#Druid : https://github.com/alibaba/druid
#JDBC 配置
spring.datasource.druid.url=jdbc:mysql://localhost:3306/kangaroo?useUnicode=true&characterEncoding=utf8&useSSL=false
spring.datasource.druid.username=test
#密码加密 https://github.com/alibaba/druid/wiki/%E4%BD%BF%E7%94%A8ConfigFilter
spring.datasource.druid.password=BcWHgbYt003SP1YRk+FLLqDvBcg9i/sthTmfIxawQjGf4gMaPRIY92ci1w8OBO5dT06NS1hBSMW+vRSkLFJjfQ==
public-key=MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALtV4Plk1gMPPMhdw+6jscRP2EBHyrZ/ayI46ArKpMPWuwmUtIs5b+bm50ObHrYAJSsjIsFkw4b1eq5a5gV3aIMCAwEAAQ==
spring.datasource.druid.connection-properties=config.decrypt=true;config.decrypt.key=${public-key}
spring.datasource.druid.driver-class-name=com.mysql.jdbc.Driver
#连接池配置
spring.datasource.druid.initial-size=5
spring.datasource.druid.max-active=100
spring.datasource.druid.min-idle=5
spring.datasource.druid.max-wait=6000
spring.datasource.druid.pool-prepared-statements=true
spring.datasource.druid.max-pool-prepared-statement-per-connection-size=20
spring.datasource.druid.max-open-prepared-statements=20
spring.datasource.druid.validation-query=SELECT 'X'
spring.datasource.druid.validation-query-timeout=60000
spring.datasource.druid.test-on-borrow=true
spring.datasource.druid.test-on-return=false
spring.datasource.druid.test-while-idle=false
spring.datasource.druid.time-between-eviction-runs-millis=60000
#spring.datasource.druid.min-evictable-idle-time-millis=60000
#spring.datasource.druid.max-evictable-idle-time-millis=60000
spring.datasource.druid.filters=stat,wall,slf4j,config
#spring.datasource.druid.stat-logger=!<com.pactrex.general.config.druid.MyStatLogger> {}
#慢SQL记录,超过1s
spring.datasource.druid.filter.stat.enabled=true
spring.datasource.druid.filter.stat.log-slow-sql=true
spring.datasource.druid.filter.stat.merge-sql=true
spring.datasource.druid.filter.stat.slow-sql-millis=1000
# WebStatFilter配置，说明请参考Druid Wiki，配置WebStatFilter
spring.datasource.druid.web-stat-filter.enabled=true
spring.datasource.druid.web-stat-filter.url-pattern=/*
spring.datasource.druid.web-stat-filter.exclusions=
spring.datasource.druid.web-stat-filter.session-stat-enable=true
spring.datasource.druid.web-stat-filter.session-stat-max-count=1000
spring.datasource.druid.web-stat-filter.principal-session-name=sys_user
spring.datasource.druid.web-stat-filter.principal-cookie-name=JSESSION_ID
spring.datasource.druid.web-stat-filter.profile-enable=true
# StatViewServlet配置，说明请参考Druid Wiki，配置_StatViewServlet
spring.datasource.druid.stat-view-servlet.enabled=true
spring.datasource.druid.stat-view-servlet.url-pattern=/druid/*
spring.datasource.druid.stat-view-servlet.reset-enable=true
spring.datasource.druid.stat-view-servlet.login-username=druid
spring.datasource.druid.stat-view-servlet.login-password=druid
spring.datasource.druid.stat-view-servlet.allow=192.168.2.1/24
spring.datasource.druid.stat-view-servlet.deny=
mybatis.type-aliases-package=io.github.pactstart.*.entity
mybatis.mapper-locations=classpath*:/io/github/pactstart/*/mapper/*.xml
mybatis.executor-type=simple
mybatis.configuration.map-underscore-to-camel-case=true
mapper.mappers=io.github.pactstart.basedao.MyMapper
mapper.not-empty=false
mapper.identity=MYSQL
pagehelper.helperDialect=mysql
pagehelper.reasonable=true
pagehelper.supportMethodsArguments=true
pagehelper.params=count\=countSql
# redis
spring.session.store-type=redis
spring.redis.database=5
spring.redis.host=localhost
spring.redis.port=6379
spring.redis.password=
spring.redis.pool.max-active=8
spring.redis.pool.max-wait=-1
spring.redis.pool.max-idle=8
spring.redis.pool.min-idle=0
spring.redis.timeout=0
#系统配置
application.web.framework.servlet-request-wrapper-enabled=true
application.web.framework.enable-ajax=false
application.web.framework.anon-urls=/sys/user/login.json
application.web.framework.auth-url=http://localhost:8080
application.web.framework.enable-acl=false
application.web.framework.acl-exclusion-urls=/**
application.web.framework.cors-enabled=true
application.web.framework.cors.allow-origins=http://localhost:8080
application.web.framework.cors.allow-credentials=true
application.web.framework.cors.allow-methods=OPTIONS,POST,GET,PUT,DELETE
application.web.framework.cors.max-age=86400
application.web.framework.api-info.version=1.0
application.web.framework.api-info.title=kangaroo
application.web.framework.api-info.description=kangaroo
application.web.framework.api-info.termsOfServiceUrl=https://github.com/PactStart/kangaroo
application.web.framework.api-info.contact.name=rex.lei
application.web.framework.api-info.contact.url=weixin:pactrex
application.web.framework.api-info.contact.email=1203208955@qq.com
application.web.framework.redis.serializeType=fastjson
application.cache.cache-type=spring-data-redis
#logging
application.logging.level=INFO
application.logging.path=logs
#jpush配置
jpush.appKey: xx
jpush.masterSecret: xx
jpush.apns: true
jpush.production: false
jpush.name: ufang
#sts
aliyun.sts.oss.accessKeyId:xx
aliyun.sts.oss.accessKeySecret:xx
aliyun.sts.oss.roleArn:acs:ram::1606580315923724:role/aliyunosstokengeneratorrole
aliyun.sts.oss.roleSessionName:external-username
aliyun.sts.oss.tokenExpireTime:3600
aliyun.sts.oss.policyFile:classpath:osspolicy/bucket_only_put_policy_for_dev.txt
#oss
aliyun.oss.accessKeyId:xx
aliyun.oss.accessKeySecret:xx
aliyun.oss.bucket:xx
aliyun.oss.endPoint:oss-cn-shenzhen.aliyuncs.com
aliyun.oss.expireTime:1800
```
logback-spring.xml example:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration scan="true">
    <!--<configuration debug="true" scan="true" scanPeriod="30 seconds">-->
    <springProperty scope="context" name="logLevel" source="application.logging.level"/>
    <springProperty scope="context" name="logPath" source="application.logging.path"/>

    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <!--<pattern>%d{yyyy-MM-dd HH:mm:ss} [%level] [%class:%line] - %m %n</pattern>-->
            <pattern>%d{yyyy-MM-dd HH:mm:ss} | %highlight(%-5level) | %yellow(%thread) | %black([%class:%line]) - %m %n
            </pattern>
        </encoder>
    </appender>

    <appender name="FILE-OUT" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${logPath}/kangaroo-admin.log</file>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%level] [%class:%line] - %m %n</pattern>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>${logPath}/kangaroo-admin.%d{yyyy-MM-dd}-%i.log.zip</fileNamePattern>
            <maxHistory>7</maxHistory>
            <maxFileSize>100MB</maxFileSize>
        </rollingPolicy>
    </appender>

    <springProfile name="dev">
        <root level="${logLevel}">
            <appender-ref ref="STDOUT"/>
        </root>
        <logger name="org.mybatis" level="trace"/>
        <logger name="io.github.pactstart" level="trace"/>
    </springProfile>

    <springProfile name="test">
        <root level="${logLevel}">
            <appender-ref ref="STDOUT"/>
        </root>
        <logger name="org.mybatis" level="trace"/>
        <logger name="io.github.pactstart" level="trace"/>
    </springProfile>

    <springProfile name="prod">
        <root level="${logLevel}">
            <appender-ref ref="FILE-OUT"/>
        </root>
        <logger name="org.mybatis" level="trace"/>
        <logger name="io.github.pactstart" level="trace"/>
    </springProfile>
</configuration>
```
