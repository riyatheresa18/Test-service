FROM openjdk:8
COPY ./src/main/java/com.example.testservice/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","testservice"]