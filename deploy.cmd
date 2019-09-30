cd kangaroo-parent
call mvn clean deploy -P release -DskipTests
cd  ..
cd kangaroo-commonutils
call mvn clean deploy -P release -DskipTests
cd..
cd kangaroo-httputils
call mvn clean deploy -P release -DskipTests
cd ..
cd kangaroo-poi
call mvn clean deploy -P release -DskipTests
cd ..
cd kangaroo-basedao
call mvn clean deploy -P release -DskipTests
cd ..
cd kangaroo-biz-common
call mvn clean deploy -P release -DskipTests
cd ..
cd kangaroo-simple-web-framework
call mvn clean deploy -P release -DskipTests
cd ..
cd kangaroo-mq
call mvn clean deploy -P release -DskipTests
cd ..
cd redis-mq-spring-boot-starter
call mvn clean deploy -P release -DskipTests
cd ..
cd aliyun-oss-spring-boot-starter
call mvn clean deploy -P release -DskipTests
cd ..
cd aliyun-sms-spring-boot-starter
call mvn clean deploy -P release -DskipTests
cd ..
cd aliyun-sts-spring-boot-starter
call mvn clean deploy -P release -DskipTests
cd ..
cd cache-spring-boot-starter
call mvn clean deploy -P release -DskipTests
cd ..
cd chuanglan-sms-spring-boot-starter
call mvn clean deploy -P release -DskipTests
cd ..
cd jpush-spring-boot-starter
call mvn clean deploy -P release -DskipTests
cd ..
cd juhe-spring-boot-starter
call mvn clean deploy -P release -DskipTests
cd ..
cd pay-spring-boot-starter
call mvn clean deploy -P release -DskipTests
cd ..
cd kangaroo-weixin-toolkit
call mvn clean deploy -P release -DskipTests
cd ..
cd weixin-spring-boot-starter
call mvn clean deploy -P release -DskipTests
cd ..
cd kangaroo-service-dispatcher
call mvn clean deploy -P release -DskipTests
cd ..
cd kangaroo-mod-system
call mvn clean deploy -P release -DskipTests
cd ..
cd kangaroo-web-admin
call mvn clean deploy -P release -DskipTests
cd ..
cd kangaroo-dependencies
call mvn clean deploy -P release -DskipTests
cd ..