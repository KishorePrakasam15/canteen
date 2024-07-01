FROM openjdk:11
EXPOSE 8081
ADD target/Loginpage.war demo-docker-app
ENTRYPOINT ["java","-jar","/demo-docker-app"]