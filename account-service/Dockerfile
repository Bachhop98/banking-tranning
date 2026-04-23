FROM maven:3.8.5-openjdk-17-slim as build
WORKDIR /app

COPY ./ ./account-service

WORKDIR /app/account-service
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/account-service/target/*.jar account-service.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","account-service.jar"]