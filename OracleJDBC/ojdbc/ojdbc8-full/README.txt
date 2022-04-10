======================================================
Oracle Free Use Terms and Conditions (FUTC) License 
======================================================
https://www.oracle.com/downloads/licenses/oracle-free-license.html
===================================================================

ojdbc8-full.tar.gz - JDBC Thin Driver and Companion JARS
========================================================
This TAR archive (ojdbc8-full.tar.gz) contains the 19.8 release of the Oracle JDBC Thin driver(ojdbc8.jar), the Universal Connection Pool (ucp.jar) and other companion JARs grouped by category. 

(1) ojdbc8.jar (4,398,623 bytes) - 
(SHA1 Checksum: df9cff9b91c47d06b9a0482d566ee2d83a03e586)
Oracle JDBC Driver compatible with JDK8, JDK9, and JDK11; 
(2) ucp.jar (1,684,258 bytes) - (SHA1 Checksum: f3ffaed1b8aa011e6a136af1c5ad2ce7be439cd3)
Universal Connection Pool classes for use with JDK8, JDK9, and JDK11 -- for performance, scalability, high availability, sharded and multitenant databases.
(3) ojdbc.policy (11,515 bytes) - Sample security policy file for Oracle Database JDBC drivers

======================
Security Related JARs
======================
Java applications require some additional jars to use Oracle Wallets. 
You need to use all the three jars while using Oracle Wallets. 

(4) oraclepki.jar (311,000 bytes) - (SHA1 Checksum: 078a5918f653efe20b800530f85f5c2a6f7a199a)
Additional jar required to access Oracle Wallets from Java
(5) osdt_cert.jar (210,337 bytes) - (SHA1 Checksum: 5fa177c389d80e6815abc60086f5b9d93b489dc6)
Additional jar required to access Oracle Wallets from Java
(6) osdt_core.jar (312,200 bytes) - (SHA1 Checksum: 9fabf9bfc46a1100daf4272beb676f8dab375a28)
Additional jar required to access Oracle Wallets from Java

=============================
JARs for NLS and XDK support 
=============================
(7) orai18n.jar (1,663,954 bytes) - (SHA1 Checksum: 2a8804f4e13b5e0528e750d964a5744eceeb49f9) 
Classes for NLS support
(8) xdb.jar (265,130 bytes) - (SHA1 Checksum: 15a294f90cc9604c91f46319287c200c81614e30)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 
(9) xmlparserv2.jar (1,933,747 bytes) - (SHA1 Checksum: babfefd035ffea28cd947481d843b2f9a31603ba)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 
====================================================
JARs for Real Application Clusters(RAC), ADG, or DG 
====================================================
(10) ons.jar (156,242 bytes) - (SHA1 Checksum: fe91e4a6e0fe481aba81730a5a2d497a02d54566)
for use by the pure Java client-side Oracle Notification Services (ONS) daemon
(11) simplefan.jar (32,168 bytes) - (SHA1 Checksum: 3cf48b723b2504863bd8898d74782af4635257ba)
Java APIs for subscribing to RAC events via ONS; simplefan policy and javadoc

=================
USAGE GUIDELINES
=================
Refer to the JDBC Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/19/jjdbc/index.html) and Universal Connection Pool Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/19/jjucp/index.html)for more details. 
