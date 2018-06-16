FROM nginx
COPY static-html-directory /usr/share/nginx/html
VOLUME /tmp
ADD target/burger-server-0.0.1-SNAPSHOT.jar burger-server.jar
ENV JAVA_OPTS=""

