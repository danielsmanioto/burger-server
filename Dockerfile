FROM java:8-jdk-alpine

COPY ./target/burger-server-0.0.1-SNAPSHOT.jar /usr/app/burger-server.jar

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","/usr/app/burger-server.jar"]  

