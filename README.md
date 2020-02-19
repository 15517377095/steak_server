该项目为 Steak 平台的后台项目

# 启动项目

## 导入数据库

导入根目录下的 `steak.sql`

## 更改数据库

打开 `src\main\resources` 下的 `application.yml` 

```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/steak?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B8

    username: # your username
    password: # your password

    # for Mysql5 com.mysql.jdbc.Driver
    # for Mysql6 com.mysql.cj.jdbc.Driver
    driver-class-name: # your dirverClassName
```

## 运行方式

运行 `src\main\java\com\steak` 下的 `SteakApplication.java` 主函数
