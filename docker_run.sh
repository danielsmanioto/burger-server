mvn clean install 
docker build -t burger-server .
docker run -p 80:8080 -t burger-server
