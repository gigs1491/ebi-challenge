FROM openjdk:11

COPY target/ebi-crud-manager-service-0.0.1-SNAPSHOT.jar ebi-crud-manager-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/ebi-crud-manager-service-0.0.1-SNAPSHOT.jar"]