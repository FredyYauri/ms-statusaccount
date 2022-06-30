FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-statusaccount.jar
ENTRYPOINT ["java","-jar","/ms-statusaccount.jar"]