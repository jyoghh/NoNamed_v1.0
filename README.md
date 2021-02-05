# Vulnerability_Management
Test project for vulnerability management tool.
취약점 통합관리 툴!

### Development Environment
       __J A V A__
 - Spring boot + Gradle + JPA
 - MySQL + Hibernate
 - Thymeleaf + bootstrap
 - Docker based!!!

### Usage
 - Provides a high efficiency within vulnerability management
 - Perform static analysis of known vulnerabilities, trojans, viruses, malware & other malicious threats scanned by following various scanners : Web,application, server, network devices, system, source code.
 - 각종 스캐너 연동을 통하여 취약점 관리 업무를 보다 효율적으로 핸들링 할 수 있도록!


##### Dockerfile for Docker-compose
```
FROM openjdk:14-jdk
COPY ./test.jar test.jar
ENTRYPOINT ["java","-jar","test.jar"]
CMD ["./gradlew", "bootRun"]
```
docker-compose 사용을 위해 도커파일을 생성하여 사용한다.
