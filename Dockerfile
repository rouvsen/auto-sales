FROM alpine:3.18.3
RUN apk add --no-cache openjdk17
RUN apk add --no-cache tzdata
COPY build/libs/auto-sales-1.0.97900eb.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "/app/auto-sales-1.0.97900eb.jar"]
