
# Simple Spring Boot Deployment with AWS Elastic Beanstalk


## Spring Boot Initializr

```
- Project: Maven Project
- Language: Java
- Group: com.example
- Artifact: hello
- Dependencies: Spring Web, Thymeleaf
```


## Add Spring Security

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```


## Run

```
mvnw spring-boot:run
```


## Access

```
http://localhost:8080/
http://localhost:8080/?name=Emily
http://localhost:8080/protected
```


## Export to a JAR file

```
mvnw package -DskipTests
```


## Deploy to AWS Elastic Beanstalk

```
Corretto 11 running on 64bit Amazon Linux 2
Corretto 8 running on 64bit Amazon Linux 2
Java 8 running on 64bit Amazon Linux
Java 7 running on 64bit Amazon Linux
```

```
Application name:  hello
Platform: Java
Application code: Upload Your code (hello-0.0.1-SNAPSHOT.jar)
```

```
This will take a few minutes. ...
12:03am
Created load balancer named:
arn:aws:elasticloadbalancing:us-east-2:042323082175:loadbalancer/app/awseb-AWSEB-2N2QA50VSWR3/c05f56d4229af344
12:03am
Created CloudWatch alarm named:
awseb-e-ugh6r8csvp-stack-AWSEBCloudwatchAlarmHigh-1VV4PS61623B4
12:03am
Created CloudWatch alarm named:
awseb-e-ugh6r8csvp-stack-AWSEBCloudwatchAlarmLow-1KNI4DKQCRVKU
12:03am
Created Auto Scaling group policy named:
arn:aws:autoscaling:us-east-2:042323082175:scalingPolicy:6e859304-f970-494f-abfe-598532015e3a:autoScalingGroupName/awseb-e-ugh6r8csvp-stack-AWSEBAutoScalingGroup-9EU6C0Z29J12:policyName/awseb-e-ugh6r8csvp-stack-AWSEBAutoScalingScaleUpPolicy-1UVXFU4EEGHLA
12:03am
Created Auto Scaling group policy named:
arn:aws:autoscaling:us-east-2:042323082175:scalingPolicy:fac6ad3e-ae3b-4be8-a5e6-269b92239db5:autoScalingGroupName/awseb-e-ugh6r8csvp-stack-AWSEBAutoScalingGroup-9EU6C0Z29J12:policyName/awseb-e-ugh6r8csvp-stack-AWSEBAutoScalingScaleDownPolicy-1WM6AHCO93KKE
12:03am
Waiting for EC2 instances to launch. This may take a few minutes.
12:03am
Created Auto Scaling group named:
awseb-e-ugh6r8csvp-stack-AWSEBAutoScalingGroup-9EU6C0Z29J12
12:02am
Created Auto Scaling launch configuration named:
awseb-e-ugh6r8csvp-stack-AWSEBAutoScalingLaunchConfiguration-1KXMTK79OQT8U
12:02am
Created security group named:
awseb-e-ugh6r8csvp-stack-AWSEBSecurityGroup-12HPSX05J9R7N
12:01am
Created security group named:
sg-004abd4cf7ab04c2d
12:01am
Created target group named:
arn:aws:elasticloadbalancing:us-east-2:042323082175:targetgroup/awseb-AWSEB-1O62C8J6AIKBO/6ba753db709d4f1e
12:01am
Using elasticbeanstalk-us-east-2-042323082175 as Amazon S3 storage bucket for environment data.
12:01am
createEnvironment is starting.
```




## Visual Studio Code is another Java Spring Boot IDE :-)

