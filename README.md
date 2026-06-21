# 🧾 QuickOrder Microservices

Sistema de gestión de pedidos basado en arquitectura de microservicios desarrollado con Spring Boot, Eureka Server, API Gateway y Docker.

---

## 📦 Descripción del Proyecto

QuickOrder es un sistema distribuido para la gestión de pedidos que utiliza una arquitectura de microservicios. Cada servicio cumple una responsabilidad específica, permitiendo una mejor escalabilidad, mantenibilidad y desacoplamiento de componentes.

---

## 🧩 Microservicios Implementados

Actualmente el sistema está compuesto por:

* users-service → Gestión de usuarios.
* products-service → Gestión de productos.
* orders-service → Gestión de pedidos.
* api-gateway → Punto único de acceso a los microservicios.
* eureka-server → Registro y descubrimiento de servicios.

---

## 🛠️ Tecnologías Utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Git y GitHub
* Docker
* Docker Compose
* Eureka Server
* Spring Cloud Gateway
* Swagger / OpenAPI
* JUnit 5
* Mockito
* SLF4J

---

## 🌐 Servicios Implementados

| Servicio         | Puerto | Descripción                            |
| ---------------- | ------ | -------------------------------------- |
| Eureka Server    | 8761   | Registro y descubrimiento de servicios |
| API Gateway      | 8090   | Punto único de entrada                 |
| Orders Service   | 8085   | Gestión de pedidos                     |
| Users Service    | 8081   | Gestión de usuarios                    |
| Products Service | 8082   | Gestión de productos                   |

---

## 🏗️ Arquitectura

Cliente
↓
API Gateway (8090)
↓
Eureka Server (8761)
↓
Orders Service
Users Service
Products Service

Cada microservicio mantiene su propia base de datos MySQL y puede desplegarse de forma independiente mediante Docker.
