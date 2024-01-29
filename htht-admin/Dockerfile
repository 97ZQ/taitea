FROM openjdk:11

MAINTAINER Lion Li

RUN mkdir -p /project/logs \
    --mount=type=bind,source=/learn/java/mount-tai-tea,target=/project \
    /project/temp \

WORKDIR /project

ENV SERVER_PORT=10000

EXPOSE ${SERVER_PORT}

CMD ["java", \
            "-jar", "app.jar"]
