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

Get all skills.

i.e.
GET http://localhost:8080/api/v1/skill-inventory/skills

#### GET /skills/{id}

Get one skill by Id.

i.e.
GET http://localhost:8080/api/v1/skill-inventory/skills/1

#### GET /skillsSearch?keyword=$keyword

Searching/Filtering skills by keyword.

i.e.
GET http://localhost:8080/api/v1/skill-inventory/skillsSearch?keyword=cloud

#### Get all skills with sorting

Get all skills with sorting.

i.e.
GET http://localhost:8080/api/v1/skill-inventory/skillsSorting?sort=skillName
GET http://localhost:8080/api/v1/skill-inventory/skillsSorting?sort=skillName&order=desc

#### Get all skills with pagination and offset

Get all skills with pagination and offset.

The default values are limit=20 and offset=0.

i.e.
GET http://localhost:8080/api/v1/skill-inventory/skillsPaging
GET http://localhost:8080/api/v1/skill-inventory/skillsPaging?offset=20
GET http://localhost:8080/api/v1/skill-inventory/skillsPaging?limit=3
GET http://localhost:8080/api/v1/skill-inventory/skillsPaging?offset=10&limit=5

#### GET /skillsFields?fields=[field1,field2,...]

Get all skills with field selection.

i.e.
GET http://localhost:8080/api/v1/skill-inventory/skillsFields?fieldList=skillName,skillPriority
GET http://localhost:8080/api/v1/skill-inventory/skillsFields?fieldList=skillId,skillNameLong,skillStatus

Use : or . for sub-object fields.

i.e.
GET http://localhost:8080/api/v1/skill-inventory/skillsFields?fields=name,priority,project.client,project.info

Note:
GraphQL does better job on this.

#### POST

Add a new skill.

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

#### PUT /skills/{id}

Update one skill by Id (completely).

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

```json
{
  "skillName": "Kafka",
  "skillNameLong": "Kafka",
  "skillDescription": "Kafka messaging",
  "skillStatus": 1,
  "skillPriority": 1
}
```

#### PATCH /skills/{id}

Update one skill by Id (partially).

i.e.
PATCH http://localhost:8080/api/v1/skill-inventory/skills/3

```json
{
  "skillName": "Kafka",
  "skillNameLong": "Kafka",
  "skillDescription": "Kafka messaging",
  "skillStatus": 1,
  "skillPriority": 1
}
```

->

```json
{
  "skillName": "Redis",
  "skillPriority": "2"
}
```

->

```json
{
  "skillName": "Redis",
  "skillNameLong": "Redis",
  "skillDescription": "Redis DB",
  "skillStatus": 1,
  "skillPriority": 2
}
```

#### DELETE /skills/{id}

Delete a skill by Id.

i.e.
DELETE http://localhost:8080/api/v1/skill-inventory/skills/4

```json
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
REST
MySQL
```

```xml
<dependency>
    <groupId>com.github.java-json-tools</groupId>
    <artifactId>json-patch</artifactId>
    <version>1.13</version>
</dependency>
```

```xml
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

```xml
<dependency>
    <groupId>com.github.bohnman</groupId>
    <artifactId>squiggly-filter-jackson</artifactId>
    <version>1.3.18</version>
</dependency>
```

### Front end

```
?
```

## Design

### Data Modeling

Category
Keyword
Years
Relationship
Projects

### Dependencies

### API Naming Conventions

REST Resource Naming Guide

### CRUD

### value vs path

Value is an alias to Path.

### PUT vs PATCH

#### How to implement PATCH

Using JsonPatch or not?

Too much boilerplate and troubles if using JsonPatch.

### Searching / Filtering

GET /skillsSearch?keyword=data

#### How to implement searching / filteringn?

Two ways -

##### Using Java 8 Steam API (Recommended)

Stream.filter()

##### Using @Query

Containing
findByFirstnameContaining
… where x.firstname like ?1 (parameter bound wrapped in %)

### Sorting

GET /skillsSorting?sort=skillName&order=desc

GET /skillsSorting?sort=skillPriority&order=desc

GET /skillsSorting?sort=skillNameLong

The default should be sort=None and order=asc.

Another design approach is:

GET /skillsSorting?sort=+priority,-status

#### How to implement sorting?

Two ways -

##### Using Java 8 Steam API (Recommended)

Comparator.comparing(...)

##### Using @Query

...

### Pagination and offset

GET /skillsPaging
GET /skillsPaging?offset=10
GET /skillsPaging?limit=5
GET /skillsPaging?offset=10&limit=5

The default values are limit=20 and offset=0.

#### How to implement Pagination and offset?

Two ways -

##### Using Java 8 Steam API (Recommended)

skip + limit

##### Using @Query

...

### Field selection

GET /skillsFields?fields=name,priority

#### How to implement field selection?

Too much work!

(1) Model

```java
@JsonFilter("fieldFilter")
```

(2) Controller

```java
SimpleFilterProvider filterProvider = new SimpleFilterProvider().addFilter("fieldFilter",
  SimpleBeanPropertyFilter.filterOutAllExcept(fieldList.split(",")));
ObjectMapper mapper = new ObjectMapper().setFilterProvider(filterProvider);
```

(3) Filter!

Unhappy workaround:

- Create a "duplicated" model class (@Data @Entity)
- Add the filter (@JsonFilter)
- Create a "duplicated" JpaRepository for the "new" model (@Repository)
- Use the filter in the Controller

The original model doesn't use the filter.

#### Solution

Replace with GraphQL.

### Validation

### Error handling (ControllerAdvice)

### Duplicates / Overwitten

### Abbreviation and Variation

### Security

### oAuth, JWT

### Use sub-resources for relations

### HATEOAS ?

Hypermedia as the Engine of Application State is a principle that hypertext links should be used to create a better navigation through the API.

```json
{
  "id": 888,
  "manufacturer": "bmw",
  "model": "X3",
  "seats": 5,
  "drivers": [
    {
      "id": "48",
      "name": "Brian Su",
      "links": [
        {
          "rel": "self",
          "href": "/api/v1/drivers/48"
        }
      ]
    }
  ]
}
```

### Performance / Caching

Retrieve all skills from DB and cache them.

Any POST/PUT/PATCH/DELETE will invert the cache.

### Version

### Unit Testing

### Angular app UI

### React app UI

### Upgrade to GraphQL

### Neo4j

## Troubleshooting

### Dependencies

jackson-core and jackson-annotations are needed for jackson-databind.

### StringUtils.isEmpty() -> ObjectUtils.isEmpty()

StringUtils.isEmpty() has been deprecated and should be replaced by ObjectUtils.isEmpty().

### @EnableJpaRepositories(repositoryBaseClass = ExtendedRepositoryImpl.class)

### Lombok and JPA???

Entity looks better!
But it doesn't work well :-(
Using @Data for JPA entities is not recommended. It can cause severe performance and memory consumption issues.

## Misc

### consumes = "application/json-patch+json"

It is needed in the controller classes.

### @JsonCreator @JsonProperty

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

### HTTP status codes

```
200 – OK – Eyerything is working
201 – OK – New resource has been created
204 – OK – The resource was successfully deleted
304 – Not Modified – The client can use cached data
400 – Bad Request – The request was invalid or cannot be served. The exact error should be explained in the error payload. E.g. "The JSON is not valid"
401 – Unauthorized – The request requires an user authentication
403 – Forbidden – The server understood the request, but is refusing it or the access is not allowed.
404 – Not found – There is no resource behind the URI.
422 – Unprocessable Entity – Should be used if the server cannot process the enitity, e.g. if an image cannot be formatted or mandatory fields are missing in the payload.
500 – Internal Server Error – API developers should avoid this error. If an error occurs in the global catch blog, the stracktrace should be logged and not returned as response.
```

## Skills

```
Full Stack
DevOps
Data
Cloud
Mobile

API
UI
Microservice

Pattern
Design Pattern
Twelve-Factor
Twelve-Factor App
Twelve-Factor methodology
Twelve-Factor App methodology
12 Factor
12 Factor app
Cloud Native

Java
Python
Go
Golang
Kotlin
Javascript
Node.js
C#
Shell Script
TypeScript
Scala
Ruby
Erlang
Object-C
Swift
PHP

Angular
React
VUE
Material
Material UI
Bootstrap
jQuery

Agile
Scrum
SDLC
ITSM
ITIL

Government
Banking
Financial Services
Insurance
Energy
Telecom
Telecommunications
Healthcare
Pharmaceutical
Postal Service
Consulting
IT
Software
Oil & Gas
Petroleum
Retail

Google
Amazon
Microsoft
Salesforce
Oracle
IBM
RedHat
SAP
VMWare
HP
Accenture
Capgemini
Express Scripts
RBC
BMO
NBC
Manulife
Sunlife
CMHC
Canada Post
Hydro One
Husky Energy
Rogers
Telus
Loblaws

OPS
Ontario Public Service
Government of Canada
Federal Government
Ontario Ministry of Children, Community and Social Services
Ontario Ministry of Health and Long-Term Care
Ontario Ministry of Education

CI/CD
pipeline

HTML
HTML 5
CSS
CSS 3
CSS media

Docker
Kubernetes
Container
Containerization orchestration

Terraform
Jenkins
Ansible

AWS
Amazon Web Service
GCP
Google Cloud
Google Cloud Platform
Azure
Snowflake
Heroku
Salesforce Cloud
Pivotal Cloud Foundry
PCF
Tanzu
IBM Cloud
SAP Cloud
SAP Cloud Platform

Cloud Computing
Cloud Storage
Serverless Computing

Amazon API Gateway
Amazon RDS
Amazon Aurora
Amazon Lambda
Amazon EC2
Amazon VPC
Amazon Route 53
Amazon S3
Amazon CloudFront
Amazon IAM
Amazon Cognito
Amazon SNS
Amazon SQS
Amazon Redshift
Amazon Kinesis
Amazon Elastic Search

Google Cloud App Engine
gcloud CLI
Google Cloud SDK
GKE
Google Kubernetes Engine
Cloud Pub/Sub
Stackdriver
Cloud Run
Anthos
Bigtable
Firestore
Memorystore
Spanner
Cloud Dataflow
Cloud Dataproc
Cloud Dataprep
Cloud Datalab
Cloud Source Repositories
Cloud Scheduler
Container Registry
Apache Beam
Istio

Azure Cognitive Services
Azure Compute
Azure Functions
Azure Blob storage
Azure cFile storage
Azure Active Directory
Azure Key Vault
Azure Analytics
Azure AI
Azure Kubernetes Service
Azure Container Registry
Azure DevOps
Azure Pipelines
Azure Repos
Azure Test Plans

Public Cloud
Private Cloud
Hybrid Cloud

AI
Machine Learning
TensorFlow

IoT
Internet of things

Jupyter Notebook

SQL
PLSQL
TSQL

NoSQL
DynamoDB
Big Query
Cosmos DB
MongoDB
RDBMS
MySQL
PostgreSQL
Oracle
MS SQL Server
DB2

OpenShift
Cloud Foundry

PaaS
IaaS
SaaS

REST
GraphQL
gRPC
SOAP
SOA
Web Services

Spring Boot
Spring
DI
Dependency Injection
IoC
Inversion of Control
AOP
Autowired
Spring MVC
Spring Data

Django
Django REST

Kafka
RabbitMQ
Redis
JMS

Git
GitHub
GitLab

YAML
JSON
XML

Shopify

SPA

Expo
Apple
Andriod

IBM InfoSphere
IBM WebSphere
IBM DataStage and QualityStage
IBM Cognos
Informatica PowerCenter
Informatica Developer

Big Data
ETL
Data Integration
Data Quality
Data Warehouse
Data Analytics
Data Ingestion
Data Governance
Data Migration
Data Visualization
MDM
Master Data Management
Data Lake

SSIS
SSAS

oAuth
OIDC
OpenID Connect
JWT
JSON Web Token
SAML
OAS
Swagger

TDD
BDD
Mock
WireMock
SOLID

TLS
SSL

TCP/IP
HTTP

Unix
Linux
Windows

Bourne shell (sh)
Korn shell (ksh)
Bourne Again shell (bash)
POSIX shell (sh)

C Shell (csh)
TENEX/TOPS C shell (tcsh)

Ubuntu
Debian
Centos

AODA
WCAG
Screen reader
HiSoftware Compliance Sheriff
WAVE toolbar
Colour Contrast Check

JIRA
Confluence

WebLogic
Oracle WebLogic
RedHat WildFly
RedHat JBoss
Tomcat

QC
HP QC
Quality Center
ALM
HP ALM
Application Lifecycle Management

JDBC
ODBC

PowerShell
DOS

C
C++
Visual Basic .Net

EJB
JSP
Servlet
Struts
Apache Struts 2
Hibernate
JUnit

SVN
ASP
CGI

Perl
Basic
Fortran
Pascal
Delphi
COBOL
J#
F#
DHTML
Borland C++
ActionScript

DBA
System Admin
Unix Admin

AIX
Solaris
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
