FROM openjdk:17
ADD target/diplom_cloud_storage-0.0.1-SNAPSHOT.jar diplom_cloud_storage.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/diplom_cloud_storage.jar"]