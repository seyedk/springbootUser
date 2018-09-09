

FROM java:8
ADD target/user.jar app.jar
ADD target/classes/application.properties application.properties
RUN bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.config.location=application.propertilles","-jar","/app.jar"]