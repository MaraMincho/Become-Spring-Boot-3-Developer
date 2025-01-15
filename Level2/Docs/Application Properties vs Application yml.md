
# 개요
Spring Boot 프로젝트에서는 일반적으로 프로젝트의 각종 설정을 application.properties 또는 application.yml 파일을 통해 하게된다. 기본적으로 Spring Initializr를 통해 Spring Boot 프로젝트를 생성하면 application.properties가 생성되지만, Spring Boot 설정을 위해 구글링을 하다 보면 application.yml에 대한 내용이 상당히 많이 나온다. 따라서, application.properties와 application.yml의 차이를 정리하려고 한다.


# properties와 yml의 차이점

roperties와 yml의 대표적인 차이는 내부 구조가 있다. properties의 경우엔 각 줄마다 key=value의 형태로 이루어져 있지만, yml의 경우엔 들여쓰기로 구분되는 계층 구조 및 key: value의 형태로 이루어져 있다. 다음은 두 파일의 대략적인 예시이다.

```java
# properties
spring.datasource.driver-class-name=oracle.jdbc.driver.oracleDriver
spring.datasource.url=jdbc:oracle:thi:@localhost:1521:orc1
//...
```

```yml
#yml

spring:
    datasource:
        driver-class-name: oracle.jdbc.driver.OracleDriver
    #...
```

# 두 코드의 비슷한 점

```java
//DB Setting of properties
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
spring.datasource.username=username
spring.datasource.password=password
```

```yml
# DB Setting of yml
spring:
  datasource:
    driver-class-name: oracle.jdbc.driver.OracleDriver
    url: jdbc:oracle:thin:@localhost:1521:orcl
    username: username
    password: password
```


```java
// properties
application.servers[0].ip=127.0.0.1
application.servers[0].path=/path1
application.servers[1].ip=127.0.0.2
application.servers[1].path=/path2
```

``` yml
# yml
application:
  servers:
    - ip: '127.0.0.1'
      path: '/path1'
    - ip: '127.0.0.2'
      path: '/path2'

```
