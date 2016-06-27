 **在Spring Boot 里可以快速的使用shiro。** 
@EnableWebShiro 开启shiro

properties配置
```
spring.shiro.loginUrl=/login
spring.shiro.successUrl=/index
spring.shiro.unauthorizedUrl=/unauthorized
spring.shiro.realm=demoRealm
spring.shiro.chain.anon=/styles/**,/unauthorized,/login*
spring.shiro.chain.logout=/logout
spring.shiro.chain.definitions=/index=perms[admin:manage],/**=authc
spring.shiro.dataBase.enable=false
```

注：

1. realm 为Spring环境里bean的名称
2. dataBase.enable 开启数据库资源获取，需要实现接口SecuritySourceService