FROM alpine:3.11.2
RUN apk add --no-cache openjdk8
COPY build/libs/ibrahim-1.0.8661896.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "/app/ibrahim-1.0.8661896.jar"]
