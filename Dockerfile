FROM openjdk:8
MAINTAINER Radiant Digital
ADD target/*.jar /msa-balance-service.jar
RUN bash -c 'touch /msa-balance-service.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-balance-service.jar"]
EXPOSE 9086