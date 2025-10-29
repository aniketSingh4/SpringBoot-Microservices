Purpose: This project demonstrates a microservices architecture built using Spring Boot, Eureka Service Registry, and OpenFeign for inter-service communication.
It follows a multi-module Maven structure, making each microservice independently deployable while maintaining a modular, maintainable architecture.

Architecture Components:

1. Service Registry (Eureka Server): Acts as a central registry where all microservices register themselves and discover other services dynamically.
2. Customer Service: Handles all operations related to customer data such as creation, retrieval, update, and deletion. Registers itself with the Eureka Server.
3. Product Service: Manages product-related data and communicates with the Customer Service via OpenFeign to fetch or update customer information.


Tech Stack: 
Java 17 or higher, Spring Boot 3+, Spring Cloud Netflix Eureka, Spring Cloud OpenFeign, Maven (Multi-Module Structure), Lombok, Spring Web.

How It Works:

Start Eureka Server:
Run the service-registry module. It starts on port 8761 and provides a dashboard at http://localhost:8761

Start Microservices:
Run both customer-service and product-service. Each service registers itself with the Eureka Server automatically.

Inter-Service Communication:
The Product Service uses OpenFeign to call APIs from the Customer Service by its Eureka-registered name (CUSTOMERSERVICE).


Service URLs
1. Eureka Server: http://localhost:8761
2. Customer Service: http://localhost:8091/api/customer
3. Product Service: http://localhost:8092/api/product

Acknowledgments
1. Spring Boot Documentation: https://spring.io/projects/spring-boot
2. Spring Cloud Netflix: https://spring.io/projects/spring-cloud-netflix
3. OpenFeign: https://spring.io/projects/spring-cloud-openfeign
