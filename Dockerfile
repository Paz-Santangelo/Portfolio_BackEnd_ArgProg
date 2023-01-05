FROM amazoncorretto:19
MAINTAINER emaaristimuno
COPY target/paz2-0.0.1-SNAPSHOT.jar paz2-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/paz2-0.0.1-SNAPSHOT.jar"]

