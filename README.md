技术选型： 

•	核心框架：Spring Boot 1.5
•	安全框架：Apache Shiro 1.3
•	视图框架：Spring MVC 4.3
•	持久层框架：MyBatis 3.3
•	定时器：Quartz 2.3
•	数据库连接池：Druid 1.0
•	页面交互：Vue2.x
•	在线文档：Swagger2 2.7.0
•	日志管理：Logback 
•	安全框架：Apache Shiro 1.4.0 
•	服务端验证：validation-api 1.1.0.Final 
•	任务调度：elastic-job  2.1.3
•	持久层框架：mybatis-spring-boot-starter 1.3.0 
•	分页插件：pagehelper 5.0.3


依赖关系及说明：
nosql-plus-biz:业务类方法具体实现，依赖wtoip-mall-dao
nosql-plus-facade:暴露的rpc接口
nosql-plus-service:facade模块中rpc接口的实现，依赖facade
nosql-plus-job:独立定时任务模块，需要使用具体业务时应用响应的模块
nosql-plus-common:通用模块
nosql-plus-dao:数据操作模块
nosql-plus-web:启动模块，依赖service
