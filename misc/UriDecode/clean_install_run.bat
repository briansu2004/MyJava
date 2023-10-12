@cls

cd MyMavenProject

call mvn clean install

call mvn exec:java -Dexec.mainClass="com.example.App"

cd ..
