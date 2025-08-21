# Etapa 1: Build con Gradle
FROM gradle:8.5-jdk17-alpine AS builder
WORKDIR /app
COPY . .
RUN gradle clean build -x test --no-daemon

# Etapa 2: Imagen ligera
FROM amazoncorretto:17-alpine
WORKDIR /app

# Solo el JAR "fat", no el plain
COPY --from=builder /app/build/libs/users-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
