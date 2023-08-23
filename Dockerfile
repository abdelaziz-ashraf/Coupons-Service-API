#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/couponapi-0.0.1-SNAPSHOT.jar couponapi.mf
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","couponapi.jar"]
