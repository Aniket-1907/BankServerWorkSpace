FROM openjdk:17-alpine
WORKDIR /bankapp
COPY ./target/BankApp-Eurekaserver.jar /bankapp/BankApp-Eurekaserver.jar
EXPOSE 3333
ENTRYPOINT ["java","-jar","/bankapp/BankApp-Eurekaserver.jar"]