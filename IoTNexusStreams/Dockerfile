FROM openjdk:22-jdk
WORKDIR /app
RUN microdnf install findutils
COPY cfg/application.properties /usr/app/application.properties

COPY gradlew .
COPY gradle gradle
COPY . .

RUN ./gradlew build --no-daemon -x test

ENTRYPOINT ["java", "-jar", "build/libs/OpenJIoTStreams-0.0.1-SNAPSHOT.jar", "--spring.config.additional-location=/usr/app/application.properties"]