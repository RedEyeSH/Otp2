FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY target/Otp2-1.0-SNAPSHOT.jar app.jar

ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

CMD ["java", "-Dfile.encoding=UTF-8", "-jar", "app.jar"]
