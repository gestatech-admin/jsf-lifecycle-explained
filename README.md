jsf-lifecycle-explained
=======================

A very simple JSF project that shows the which lifecycle event and component system event listener gets triggered when.

A context.xml is added to the META-INF directory so it is deployable on Tomcat.
Also, for glassfish, the JSF implementation may not be packaged in the WAR. For Gradle there are a file  for Tomcat as well as for Glassfish



Building with Gradle
--------------------

Issue the command 'gradle war'
The war can be found at /build/libs

Building with Maven
-------------------

Issue the command 'mvn package'
The war can be found at /target

Generating eclipse project
--------------------------

With Gradle: 'gradle eclipse'
With Maven: 'mvn eclipse:eclipse'
