FROM openjdk:17-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} flight-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/flight-0.0.1-SNAPSHOT.jar"]

# docker build -t flight-17-dev .
# docker run -p 8080:8080 flight-17-dev