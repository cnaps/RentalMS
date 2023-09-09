# RentalMS
- 도메인 모델 클래스도  
  <img width="838" alt="image" src="https://github.com/cnaps/RentalMS/assets/15258916/ab18e473-3691-4624-8b27-b3fc8cc79569">

- RentalItem을 VO 로 선언했으나 rented등의 값이 변경됨으로 불변성을 잃음 , 엔티티로 다시 개념 정의 하던지? 아니면 overdueItem으로 분리할 필요성 있음.


- 전체 구현 아키텍처구성도
  ![image](https://github.com/cnaps/RentalMS/assets/15258916/46713f64-951f-45b6-a04c-9c6ffbeb3d6c)


- 도커 파일 생성
  - Dockerfile 생성
  ```
    FROM maven:3.8.4-openjdk-11-slim AS builder
    WORKDIR /app
    COPY . .
    RUN mvn clean package -DskipTests
    FROM openjdk:11-jre-slim
    WORKDIR /app
    COPY --from=builder /app/target/*.jar app.jar
    EXPOSE 8080
    CMD ["java", "-jar", "app.jar"]
     ```
- 빌드
  - 어플리케이션 빌드
  
    ```
    mvn clean package 
    ```
  - 실행
    ```
      ./mvnw spring-boot:run
    ```
- 컨테이너 생성
  - 도커 컨테이너 이미지 생성
  
    ```
     docker build -t rental-ms:0.0.1 . 
    ```

    ```
    docker image 
    ```

  - 도커 컨테이너 실행

    ``` 
    docker run --name rentalMS -p 8080:8080 rental-ms:0.0.1
    ```
  - 내장 네트워크 생성
    ```
    docker network create demonet
    ```

    ``` 
    docker run -d --name rentalMS --network kafka_demo_net -p 8080:8080 rental-ms:0.0.1
    ```
  