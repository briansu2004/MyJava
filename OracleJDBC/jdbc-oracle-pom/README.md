# JDBC Oracle with POM

## Maven create project

```
set PATH=%PATH%;C:\Apps\apache-maven-3.8.4\bin
```

```
mvn archetype:generate -DgroupId=com.sutek.jdbcoraclepom -DartifactId=demo -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

Catch - mind the proxies!

## Maven install ojdbc.jar

```
mvn install:install-file -Dfile=C:\Code\MyJava\OracleJDBC\ojdbc\ojdbc10.jar -DgroupId=com.oracle -DartifactId=ojdbc10 -Dversion=19.3 -Dpackaging=jar
```

## Maven build

```
mvn package
```

## Maven run

```
java -cp target/demo-1.0-SNAPSHOT.jar com.sutek.jdbcoraclepom.App
```

## All in one

```
set PATH=%PATH%;C:\Apps\apache-maven-3.8.4\bin

mvn archetype:generate -DgroupId=com.sutek.jdbcoraclepom -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

cd my-app
mvn package

java -cp target/demo-1.0-SNAPSHOT.jar com.sutek.jdbcoraclepom.App
```
