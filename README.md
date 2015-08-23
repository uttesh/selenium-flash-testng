selenium-flash-testng-template
=======================

basic selenium SIKULI  template with ant/maven for flash website automation.

Prerequisites
==============

1. JDK 1.6 or higher


Maven Users
===========

 All sikuli jars are available on maven repository except "sikuli-script.jar" file, we have to custom install that jar to maven by using following.
 
 sikuli-script.jar is available inside ext-lib folder in the sample.
 
 ```
 mvn install:install-file -Dfile= path to sikuli-script.jar -DgroupId=org.sikuli.script -DartifactId=sikuli-script -Dversion=1.0 -Dpackaging=jar
 ```
 
 Ant/Eclipse Users
===========
 
  all required jars are available under "ext-lib" folder. no need to do any changes.
  

RUN following on parent directory
=================================

MAVEN :  `mvn clean install`

ANT : `ant`


  
  
  
