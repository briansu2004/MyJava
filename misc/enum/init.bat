@cls

@REM don't use enum as the package name

mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:generate -DarchetypeArtifactId="maven-archetype-quickstart" -DarchetypeGroupId="org.apache.maven.archetypes" -DarchetypeVersion="1.4" -DgroupId="com.sutek.enumexample.province" -DartifactId="enumProvince" -DinteractiveMode=false
