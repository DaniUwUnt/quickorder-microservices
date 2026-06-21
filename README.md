# 🧾 QuickOrder Microservices

Sistema de gestión de pedidos basado en arquitectura de microservicios, desarrollado con Spring Boot.

---

## 📦 Descripción del Proyecto

Este proyecto consiste en el desarrollo de un sistema distribuido para la gestión de pedidos, implementando una arquitectura de microservicios donde cada componente cumple una función específica e independiente.

Cada microservicio se encarga de una responsabilidad concreta, permitiendo escalabilidad, mantenimiento modular y separación de responsabilidades.

---

## 🧩 Microservicios Implementados

El sistema está compuesto por los siguientes servicios:

* **users-service** → gestión de usuarios
* **auth-service** → autenticación básica
* **products-service** → catálogo de productos
* **inventory-service** → control de stock
* **orders-service** → gestión de pedidos
* **order-items-service** → detalle de pedidos
* **payments-service** → procesamiento de pagos
* **shipping-service** → gestión de envíos
* **notifications-service** → sistema de notificaciones
* **reviews-service** → reseñas de productos

---

## 🛠️ Tecnologías Utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Git & GitHub
* Docker / Docker Desktop
* Eureka Server
* API Gateway
* Swagger / OpenAPI
* JUnit 5
* Mockito
* SLF4J

---

## 🌐 Servicios principales levantados

| Servicio         |             Puerto           | Función                                     |
| ---------------- | ----------------------------:| ------------------------------------------- |
| eureka-server    |                          8761| Registro y descubrimiento de microservicios |
| api-gateway      |                          8090| Punto único de entrada a las APIs           |
| orders-service   | 8080 (interno) / Docker 8085 | Gestión de pedidos                          |
| users-service    |                          8081| Gestión de usuarios                         |
| products-service |                          8082| Gestión de productos                        |

---
## 🏗️ Arquitectura del Sistema

Cliente
↓
API Gateway (8090)
↓
Eureka Server
↓
Microservicios

- Orders Service
- Users Service
- Products Service

Cada microservicio mantiene su propia base de datos y puede desplegarse de forma independiente mediante Docker.
---
## 🔎 Eureka Server

Se implementó Eureka Server para registrar los microservicios del sistema y permitir que puedan descubrirse entre sí.

Acceso:

```txt
http://localhost:8761
```

## 🌐 Arquitectura Implementada

El sistema utiliza una arquitectura basada en microservicios con descubrimiento de servicios mediante Eureka Server.

Los servicios se registran automáticamente en Eureka y son consumidos a través de un API Gateway centralizado.

Servicios registrados:

- API Gateway
- Orders Service
- Users Service
- Products Service

La solución fue desplegada utilizando contenedores Docker.

Servicios registrados correctamente en Eureka:

* API-GATEWAY
* ORDERS-SERVICE
* USERS-SERVICE
* PRODUCTS-SERVICE

---

## 🚪 API Gateway

Se implementó API Gateway como punto único de entrada para centralizar el acceso a los microservicios.

Ejemplo de acceso mediante Gateway:

```txt
http://localhost:8090/api/pedidos
```

El Gateway redirige las solicitudes hacia el microservicio correspondiente utilizando Eureka.

---

## 🐳 Docker

Se dockerizaron los siguientes servicios:

* eureka-server
* api-gateway
* orders-service
* users-service
* products-service

Cada servicio cuenta con su propio `Dockerfile`.

Contenedores validados en Docker Desktop:

* quickorder-eureka-test
* quickorder-api-gateway-test
* quickorder-orders-test
* quickorder-users-service
* quickorder-products-service

---

## 📖 Swagger / OpenAPI

El microservicio `orders-service` incorpora documentación automática mediante Swagger/OpenAPI.

Acceso:

```txt
http://localhost:8080/swagger-ui/index.html
```

También se puede visualizar la definición OpenAPI en:

```txt
http://localhost:8080/v3/api-docs
```

---

## 🧪 Pruebas Unitarias

Se implementaron pruebas unitarias con JUnit 5 y Mockito para validar la lógica de negocio de `PedidoService`.

Para ejecutar las pruebas:

```bash
mvnw.cmd test
```

---

## 🚀 Estado del Proyecto

✔ Microservicios principales implementados
✔ Eureka Server operativo
✔ API Gateway operativo
✔ Servicios desplegados en Docker
✔ Registro automático en Eureka
✔ Endpoints validados correctamente

