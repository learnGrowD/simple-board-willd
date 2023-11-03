  FROM openjdk:11 AS builder

  COPY . .

  RUN ./gradlew clean build

  FROM openjdk:11-jre AS run

  EXPOSE 8080

  RUN adduser --system --group app-user

  USER app-user

  COPY --from=builder --chown=app-user:app-user /api/build/libs/api-*.jar app.jar

  CMD ["java", "-jar", "app.jar"]