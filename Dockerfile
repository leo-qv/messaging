FROM openjdk:11-jre
WORKDIR /app/
CMD ["java", "-version"]

EXPOSE 8081

COPY ./pom.xml ./
CMD ["mvn", "install"]
COPY . .
ENTRYPOINT ["java","-jar","/app/chat-0.0.1-SNAPSHOT.jar"]