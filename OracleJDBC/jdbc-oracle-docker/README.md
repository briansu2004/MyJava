# JDK ojdbc Oracle Docker

## Maven

```
mvn archetype:generate -DgroupId=com.sutek.jdbcoraclepomdocker -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

cd my-app

mvn install:install-file -Dfile=C:\Code\MyJava\OracleJDBC\ojdbc\ojdbc11.jar -DgroupId=com.oracle -DartifactId=ojdbc11 -Dversion=19.3 -Dpackaging=jar

mvn install:install-file -Dfile=C:\Code\MyJava\OracleJDBC\ojdbc\ojdbc8.jar -DgroupId=com.oracle.jdbc -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar

```

pom.xml

```
<dependency>
        <groupId>com.oracle</groupId>
        <artifactId>ojdbc11</artifactId>
        <version>19.3</version>
</dependency>
```

Update project

```
mvn package

@rem java -cp target\my-app-1.0-SNAPSHOT.jar;C:\Code\MyJava\OracleJDBC\ojdbc\ojdbc11.jar com.sutek.jdbcoraclepomdopcker.App


java -jar target/my-app-1.0-SNAPSHOT.jar

java -jar target/my-app-1.0-SNAPSHOT.jar -cp C:\Code\MyJava\OracleJDBC\ojdbc\ojdbc11.jar

java -jar target/my-app-1.0-SNAPSHOT.jar -cp C:\Code\MyJava\OracleJDBC\ojdbc\ojdbc8.jar

```

## Docker
