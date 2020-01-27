FROM openjdk:8-alpine

# Installing curl just to check the connectivity with outside world. 
RUN apk --no-cache add curl

COPY target/sample-docker-app-0.0.1-SNAPSHOT.jar /home/ubuntu/sample-docker-app-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/home/ubuntu/sample-docker-app-0.0.1-SNAPSHOT.jar"]