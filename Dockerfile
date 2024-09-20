FROM eclipse-temurin:21-jdk
LABEL authors="raphael.costa"

VOLUME /tmp
EXPOSE 8085

ADD Q02/target/Q02-0.0.1-SNAPSHOT.jar Questao02.jar
ENTRYPOINT ["java","-jar","/Questao02.jar"]