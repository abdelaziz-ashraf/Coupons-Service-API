#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/couponapi-0.0.1-SNAPSHOT.jar couponapi.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","couponapi.jar"]
