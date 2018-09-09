FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  target/search.jar search.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/user.jar"]