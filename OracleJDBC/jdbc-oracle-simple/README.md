# Mind the ojdbc version of Oracle Drivers

```
C:\Code\MyJava\OracleJDBC\jdbc-oracle-simple> cmd /C "C:\Apps\Java\jdk-17\bin\java.exe --enable-preview -XX:+ShowCodeDetailsInExceptionMessages -cp C:\Users\.\AppData\Roaming\Code\User\workspaceStorage\e5d90add0af33ae1439e4f5d3fb20128\redhat.java\jdt_ws\jdbc-oracle-simple_a3b9ec8e\bin JdbcOracleDriverSimple "
java.lang.ClassNotFoundException: oracle.jdbc.driver.OracleDriver

C:\Code\MyJava\OracleJDBC\jdbc-oracle-simple> cmd /C "C:\Apps\Java\jdk-17\bin\java.exe --enable-preview -XX:+ShowCodeDetailsInExceptionMessages -cp C:\Users\.\AppData\Roaming\Code\User\workspaceStorage\e5d90add0af33ae1439e4f5d3fb20128\redhat.java\jdt_ws\jdbc-oracle-simple_a3b9ec8e\bin;C:\Code\MyJava\OracleJDBC\ojdbc\ojdbc10.jar JdbcOracleDriverSimple "
java.sql.SQLRecoverableException: IO Error: The Network Adapter could not establish the connection
```
