FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER Eduardo Wallace <edubossa@gmail.com>
VOLUME /tmp
RUN mkdir -p /opt/log
COPY target/sample-logstash-*.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]