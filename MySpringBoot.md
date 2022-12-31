# My Spring Boot

## How to configure  Sping Boot app for multiple environments

Use Spring Boot profiles!

`-Dspring.profiles.active=dev` ...

e.g.

- local
- dev
- qat
- uat
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
