# Maven Kickstart

## Step #1 - create pom.xml

Quickstart with small issues

```dos
mvn archetype:generate -DgroupId=com.example -DartifactId=MyMavenProject -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Step #2 - update pom.xml

e.g.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.example</groupId>
  <artifactId>MyMavenProject</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>MyMavenProject</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>5.3.10</version>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.0</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>
```

## Step #3 - mvn clean install

```dos
mvn clean install
```

## Step #4 - test run

```dos
mvn exec:java -Dexec.mainClass="com.example.App"
```

## Step #5 - code changes

...

## Step #6 - clean, install and run

```dos
mvn clean install exec:java -Dexec.mainClass="com.example.App"
```

## Step #7 - smoke test

```dos
mvn test
```

## Step # - add test cases

```dos
mvn test
```

## Step #9 - clean, install, test and run

```dos
mvn clean install test exec:java -Dexec.mainClass="com.example.App"
```
