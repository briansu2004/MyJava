# My Spring Boot

## How to configure  Sping Boot app for multiple environments

Use Spring Boot profiles!

`-Dspring.profiles.active=dev` ...

![1672455201007](image/MySpringBoot/1672455201007.png)

VM options

![1672455689277](image/MySpringBoot/1672455689277.png)

e.g.

- local
- dev
- qat
- uatE
- preprod
- prod

<==>

- application.properties  (containing common properties)
- application-local.properties
- application-dev.properties
- application-qat.properties
- application-uat.properties
- application-preprod.properties
- application-prod.properties

### How to set the default profile

```yml
spring:
  profiles:
    active: local
```

## Misc

### Customizing Database Schema Creation

By default, Spring Boot automatically creates the schema of an embedded DataSource.

If we need to control or customize this behavior, we can use the property spring.sql.init.mode. This property takes one of three values:

```dos
always – always initialize the database
embedded – always initialize if an embedded database is in use. This is the default if the property value is not specified.
never – never initialize the database
```
