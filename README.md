# Spring Boot Tempo loki Demo
- --
## 简介
通过tempo + loki 实现spring boot项目的全链路跟踪
## 注意
- log4j2
```xml
<Property name="LOG_PATTERN">%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level - trace_id:[%X{trace_id}] span_id:[%X{span_id}] trace_flags:[%X{trace_flags}] %c{36} -- %m%n</Property>
<Property name="LOG_PATTERN_ERROR">%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level - trace_id:[%X{trace_id}] span_id:[%X{span_id}] %c{36} %l %M -- %m%n</Property>
```
- 启动命令
```shell
java -javaagent:/data/server/boot_pro/opentelemetry-javaagent-1.27.0.jar \
   -Dotel.logs.exporter=otlp \
   -Dotel.semconv-stability.opt-in=http \
   -Dotel.instrumentation.micrometer.base-time-unit=s \
   -Dotel.instrumentation.log4j-appender.experimental-log-attributes=true \
   -Dotel.instrumentation.logback-appender.experimental-log-attributes=true \
   -Dotel.exporter.otlp.protocol=grpc \
   -Dotel.metrics.exporter=otlp \
   -Dotel.javaagent.debug=true \
   -Dotel.exporter.otlp.endpoint=http://192.168.163.172:4317 \
   -Dotel.service.name=opentelemetry-java \
   -Dotel.resource.attributes=deployment.environment=dev,service.namespace=test,service.version=1.1 \
   -jar opentelemetry-java-1.0-SNAPSHOT.jar
```