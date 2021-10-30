# My Skills Inventory

## Info

In business disruption, a skills inventory can help align company goals with employee performance.

### What is a Skills Inventory?

A skills inventory is the collection of skills, education, and experiences of employees. Skills inventories capture the professional expertise, attributes, and abilities of your workforce. A centralized skills inventory provides a point-in-time view of the skills (and skills gaps) of a workforce. But the inventory should be a dynamic system, regularly updated to reflect changes in team members, skills, and professional credentials.

## Swagger

```
?
```

### Prefix

/api/v1/skill-inventory/

### Operations

#### GET /skills

Get all skills

i.e.
GET http://localhost:8080/api/v1/skill-inventory/skills

#### GET /skill/{id}

Get one skill by Id

i.e.
GET http://localhost:8080/api/v1/skill-inventory/skills/1

#### GET /skill?keyword=$keyword

Find one or more skills by keyword

i.e.
GET http://localhost:8080/api/v1/skill-inventory/skills?keyword=cloud

#### POST

Add a new skill

i.e.
POST http://localhost:8080/api/v1/skill-inventory/skills

```json
{
  "skillName": "AWS",
  "skillNameLong": "Amazon Web Services",
  "skillDescription": "AWS Cloud",
  "skillStatus": 1,
  "skillPriority": 1
}
```

```json
{
  "skillName": "GCP",
  "skillNameLong": "Google Cloud Platform",
  "skillDescription": "Google Cloud",
  "skillStatus": 1,
  "skillPriority": 1
}
```

```json
{
  "skillName": "Java",
  "skillNameLong": "Java Programming Language",
  "skillDescription": "Java",
  "skillStatus": 1,
  "skillPriority": 1
}
```

```json
{
  "skillName": "Angular",
  "skillNameLong": "Angular",
  "skillDescription": "Full Stack; Javascript",
  "skillStatus": 1,
  "skillPriority": 1
}
```

```json
{
  "skillName": "Oracle",
  "skillNameLong": "Oracle",
  "skillDescription": "Oracle RDBMS",
  "skillStatus": 1,
  "skillPriority": 1
}
```

#### PUT /skill/{id}

Update one skill by Id (completely)

i.e.
PUT http://localhost:8080/api/v1/skill-inventory/skills/2

```json
{
  "skillId": 2,
  "skillName": "GCP",
  "skillNameLong": "Google Cloud Platform",
  "skillDescription": "Google Cloud",
  "skillStatus": 1,
  "skillPriority": 1
}
```

->

```
{
    "skillName": "Kafka",
    "skillNameLong": "Kafka",
    "skillDescription": "Kafka messaging",
    "skillStatus": 1,
    "skillPriority": 1
}
```

#### PATCH /skill/{id}

Partially update one skill by Id

i.e.
PATCH http://localhost:8080/api/v1/skill-inventory/skills/3

```
{
    "skillName": "Kafka",
    "skillNameLong": "Kafka",
    "skillDescription": "Kafka messaging",
    "skillStatus": 1,
    "skillPriority": 1
}
```

->

```
{
    "skillName": "Redis",
    "skillPriority": "2"
}
```

->

```
{
    "skillName": "Redis",
    "skillNameLong": "Redis",
    "skillDescription": "Redis DB",
    "skillStatus": 1,
    "skillPriority": 2
}
```

#### DELETE /skill/{id}

Delete a skill

i.e.
DELETE http://localhost:8080/api/v1/skill-inventory/skills/4

```
{
    "skillName": "Angular",
    "skillNameLong": "Angular",
    "skillDescription": "Full Stack; Javascript",
    "skillStatus": 1,
    "skillPriority": 1
}
```

## Tech stacks

### Back end

```
Java
    JDK 17
    Spring Boot
    JPA
    Lombok
    json-patch
    ObjectMapper
MySQL

```

```
<dependency>
    <groupId>com.github.java-json-tools</groupId>
    <artifactId>json-patch</artifactId>
    <version>1.13</version>
</dependency>
```

```
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.12.5</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-annotations</artifactId>
    <version>2.12.5</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.12.5</version>
</dependency>
```

### Front end

```
?
```

## Troubleshooting

### consumes = "application/json-patch+json"

It is needed in the controller classes.

### Dependencies

jackson-core and jackson-annotations are needed for jackson-databind.

## Misc

### Changing Spring Boot banners

```
Use "Spring Boot banner Generator" to create a file named banner.txt in the src/main/resources

```

```
spring.banner.location=classpath:/path/to/banner/sutek_banner.txt
```

```
spring.banner.image.location=classpath:sutek_banner.gif
spring.banner.image.width=  //TODO
spring.banner.image.height= //TODO
spring.banner.image.margin= //TODO
spring.banner.image.invert= //TODO
```

```
 ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄       ▄▄▄▄▄▄▄▄▄▄▄  ▄         ▄
▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌     ▐░░░░░░░░░░░▌▐░▌       ▐░▌
▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌     ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀ ▐░▌       ▐░▌
▐░▌       ▐░▌▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌▐░▌    ▐░▌     ▐░▌          ▐░▌       ▐░▌
▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░▌ ▐░▌   ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌       ▐░▌
▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌     ▐░▌     ▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌     ▐░░░░░░░░░░░▌▐░▌       ▐░▌
▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░█▀▀▀▀▀▀▀█░▌▐░▌   ▐░▌ ▐░▌      ▀▀▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌
▐░▌       ▐░▌▐░▌     ▐░▌       ▐░▌     ▐░▌       ▐░▌▐░▌    ▐░▌▐░▌               ▐░▌▐░▌       ▐░▌
▐░█▄▄▄▄▄▄▄█░▌▐░▌      ▐░▌  ▄▄▄▄█░█▄▄▄▄ ▐░▌       ▐░▌▐░▌     ▐░▐░▌      ▄▄▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌
▐░░░░░░░░░░▌ ▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌      ▐░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
 ▀▀▀▀▀▀▀▀▀▀   ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀        ▀▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀

```

## Screenshot

![001.png](doc/images/001.png)
![002.png](doc/images/002.png)
![003.png](doc/images/003.png)
![004.png](doc/images/004.png)
![005.png](doc/images/005.png)
![006.png](doc/images/006.png)
![007.png](doc/images/007.png)
![008.png](doc/images/008.png)
![009.png](doc/images/009.png)
![010.png](doc/images/010.png)
![011.png](doc/images/011.png)
![012.png](doc/images/012.png)
![013.png](doc/images/013.png)
![014.png](doc/images/014.png)
![015.png](doc/images/015.png)
![016.png](doc/images/016.png)
![017.png](doc/images/017.png)
![018.png](doc/images/018.png)
![019.png](doc/images/019.png)
![020.png](doc/images/020.png)
![021.png](doc/images/021.png)
![022.png](doc/images/022.png)
![023.png](doc/images/023.png)
![024.png](doc/images/024.png)
![025.png](doc/images/025.png)
![026.png](doc/images/026.png)
![027.png](doc/images/027.png)
![028.png](doc/images/028.png)
![029.png](doc/images/029.png)
![030.png](doc/images/030.png)
![031.png](doc/images/031.png)
