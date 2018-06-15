FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/burger-server-0.0.1-SNAPSHOT.jar burger-server.jar
ENV JAVA_OPTS=""
<<<<<<< HEAD
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /snackbar-server.jar" ]


=======
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /burger-server.jar" ]
>>>>>>> parent of 3ffe409... nginx
