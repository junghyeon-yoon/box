# Spring Data Mongo Auditing

Simple example of Mongo auditing with Spring Boot. To enable it, you should add `@EnableMongoAuditing` annotation. 
Also, the implementation of `AuditorAware<T>` will be worked with `@CreatedBy` and `@LastModifiedBy` annotations on your data model. 