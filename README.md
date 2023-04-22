# My Java

My Java

## My Java Projects

### Project 24

Built a new API web application and deployed to Azure Cloud for RBC

- Programmed REST APIs with Java, Spring Boot, Hibernate, Azure SQL, GitHub, Gradle, Redis, Docker, JSON, Postman and sidecar.
- Performed unit tests with Mockito test framework.
- Used pytest test framework to build the integration tests.
- Deployed to Azure with Kyvos Kubernetes and Jenkins pipelines.
- Onboard the endpoints to the Apigee API gateway.
- Monitored with Splunk and Dynatrace.
- Managed the code repositories and reviewed code with GitHub.

### Project 23

Worked on an open-to-public online web application for Ontario Ministry of Children, Community and Social Services

- Analyzed the old IBM Curam application, designed the new application with Angular, Material, JavaScript, TypeScript, HTML 5, CSS 3 on the front end, IBM WebSphere Application Server Liberty as the web application server, Java Spring Boot REST APIs on the backend, Oracle 19 as the database, and planned the lift and shift.
- Developed backend REST API services with Java, J2EE, Spring Boot, Lombok, JPA repository, Maven and Oracle etc. Ran test suites with Junit and Postman.
- Used JSON Web Token JWT to implement token authorization (access token for client credential flow and refresh token with auth code flow).
- Program Angular components, services, interceptions, pipes, translations, forms, data tables, animations and ad-hoc UI/UX pages with RxJS, Material, i18n etc.
- Migrated the IBM Curam Social Program Management data model to a new Oracle DB instance. Built the batch jobs for an initial load and some regular delta loads.
- Managed code repository, pull requests, merges and pipelines with GitLab.

### Project 22

Created a Spring Boot RESTful application for a large telecommunication client

- Initialized the Spring Boot project with Gradle and Tomcat dependencies.
- Built a Dockerfile to run microservices in the Docker container.
- Created another Dockerfile for WireMock and used it mock the external dependencies for the Service Virtualization pattern.
- Added JUnit and Mockito unit tests to verify the correctness of service execution.
- Consumed with downstream vendor APIs and performed the integration tests.
- Increased the application performance by utilizing Java 8 features like Lambda expressions and Stream API for Bulk data operations on collections.
- Prepared multiple Spring Boot profiles for different settings.
- Used docker-compose to define and run multiple service containers together.
- Deployed to OpenShift with Jenkins pipelines.
- Managed the code repositories and reviewed code with GitHub.

### Project 21

Implemented an end-to-end Customer 360 project for client Manulife

- Built and deployed a Java application on WebSphere Application Server with Spring Data JPA to analyze the MDM log files and present the match and merge reports to the data stewards to review the data conflicts and manually merge them.
- Integrated data from 8 legacy applications with Informatica PowerCenter ETL.
- Improved data quality with IBM DataStage and QualityStage.
- Created golden data and managed reference data with IBM InfoSphere MDM.
- Led the change requests with detailed runbook.
- Managed the code repositories and reviewed code with Subversion.

...

## My Spring Boot

### Reactive Spring Boot problems

Reactive Spring Boot supposed to be better than non-Reactive Spring Boot!

However, it has a few big issues as of today - Apr 2023!

- Composite Keys is not supported

- Needs Redis for adding cache

## Lint

### VSCode formatter

<https://raw.githubusercontent.com/google/styleguide/gh-pages/eclipse-java-google-style.xml>

Set the following property in settings.json:

`"java.format.settings.url": "https://raw.githubusercontent.com/google/styleguide/gh-pages/eclipse-java-google-style.xml",`

The property can be set to a URL or a local file path. If the formatter XML file contains more than one profile, you can specify the profile name:

`"java.format.settings.profile": "GoogleStyle",`
