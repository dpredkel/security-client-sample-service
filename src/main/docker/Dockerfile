FROM fabric8/java-jboss-openjdk8-jdk

ENV JAVA_APP_JAR security-client-sample-service-latest.jar
ENV JAVA_OPTIONS -Dspring.profiles.active=dev
ENV AB_OFF true

ADD $JAVA_APP_JAR /deployments/
