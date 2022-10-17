FROM gradle:7.5.1

COPY build.gradle.kts .
COPY gradle.properties .
COPY src ./src

RUN gradle installDist

FROM openjdk:17-jdk

# For `xargs is not available`: https://github.com/gradle/gradle/issues/19682#issuecomment-1053929719
RUN microdnf install findutils

EXPOSE 8080:8080
RUN mkdir /app
COPY --from=0 /home/gradle/build/install/gradle /app

WORKDIR /app/bin
CMD ["./gradle"]
