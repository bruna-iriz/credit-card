FROM openjdk:11
WORKDIR /app
VOLUME /tmp

COPY ./target/credit-card*.jar credit-card.jar
EXPOSE 8080
EXPOSE 5005
EXPOSE 3306
ENTRYPOINT ["java", "-jar", "credit-card.jar"]
CMD ["java", "-jar", "credit-card.jar"]
