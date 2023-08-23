#
# Build stage
#
FROM maven:3.8.3-openjdk-17-slim AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /target/couponAPI-0.0.1-SNAPSHOT.jar couponAPI.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "couponAPI.jar"]
