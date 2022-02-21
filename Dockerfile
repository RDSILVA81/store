FROM openjdk:19-slim
MAINTAINER rdsilva
COPY target/store-0.0.1.jar store-0.0.1.jar
ENTRYPOINT ["java","-jar","/store-0.0.1.jar"]