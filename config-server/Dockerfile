FROM java:8-jdk
MAINTAINER Team Black <teamblack@epages.com>

COPY . /src

WORKDIR /src

RUN ./gradlew clean bootRepackage

ENTRYPOINT ["java","-jar","/src/build/libs/app.jar"]
