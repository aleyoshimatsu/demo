#FROM maven:3.8.6-amazoncorretto-17 AS build
FROM gradle:7.6.0-jdk17 AS build
RUN mkdir /src
COPY . /src
WORKDIR /src
#RUN mvn --settings /src/settings.xml clean install -DskipTests
RUN gradle clean build --no-daemon --info

FROM amazoncorretto:17.0.5
RUN mkdir /app
#COPY --from=build /src/target/*.jar /app/app.jar
COPY --from=build /src/build/libs/*.jar /app/app.jar

#Add open telemetry
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.3.1/opentelemetry-javaagent-all.jar /app/opentelemetry-javaagent.jar

WORKDIR /app
ENV APP_NAME demo
ENV SERVICE_NAMESPACE demo
ENV TZ="America/Fortaleza"

ENV JAVA_OPTS "$JAVA_OPTS \
    -XX:+UseParallelGC \
    -XX:ActiveProcessorCount=2 \
    -XX:MaxRAMPercentage=75 \
    --add-opens java.base/java.lang=ALL-UNNAMED \
    -Duser.timezone=America/Fortaleza"

EXPOSE 5000 9090

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar"]
