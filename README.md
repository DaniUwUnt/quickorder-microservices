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
* Postman (para pruebas de endpoints)
* Git & GitHub
* SLF4J (logs)

---

## 🗄️ Base de Datos

Se utilizaron bases de datos MySQL independientes por microservicio, por ejemplo:

quickorder_users
quickorder_products
quickorder_orders


Las tablas se generan automáticamente mediante:

spring.jpa.hibernate.ddl-auto=update


---

## ⚙️ Configuración

Ejemplo de configuración (`application.properties`):

spring.datasource.url=jdbc:mysql://localhost:3306/quickorder_orders

spring.datasource.username=root

spring.datasource.password=******

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true


---

## 🚀 Ejecución del Proyecto

Cada microservicio se ejecuta de forma independiente desde su respectiva carpeta:

mvnw.cmd spring-boot:run


⚠️ Es necesario ejecutar múltiples servicios en paralelo para probar la comunicación entre microservicios.

---

## 🌐 Puertos Utilizados

| Microservicio         | Puerto |
|----------------------|--------|
| users-service         | 8081   |
| products-service      | 8082   |
| inventory-service     | 8083   |
| order-items-service   | 8084   |
| payments-service      | 8085   |
| shipping-service      | 8086   |
| notifications-service | 8087   |
| reviews-service       | 8088   |
| auth-service          | 8089   |
| orders-service        | 8080   |

---

## 🔗 Comunicación entre Microservicios

Se implementó comunicación síncrona utilizando **WebClient**.

### Casos implementados:

orders-service → users-service

orders-service → products-service


### Endpoints de prueba:

GET http://localhost:8080/api/pedidos/usuarios

GET http://localhost:8080/api/pedidos/productos


Esto permite que el microservicio de pedidos consuma información desde otros servicios mediante HTTP.

---

## 🧪 Pruebas

Los endpoints fueron probados utilizando Postman y navegador.

Métodos utilizados:

* **GET** → obtener datos
* **POST** → crear registros

Se validó:

* Respuesta 200 OK
* Retorno de datos en formato JSON
* Correcta integración entre microservicios

---

## 🧾 Logs (SLF4J)

Se implementaron logs utilizando SLF4J en los controladores.

Ejemplos de logs:

Solicitud recibida: listar todos los pedidos

Comunicación entre microservicios: orders-service llama a users-service

Comunicación entre microservicios: orders-service llama a products-service


Esto permite monitorear el comportamiento del sistema y las interacciones entre servicios.

---

## 🏗️ Arquitectura

Se implementó una arquitectura en capas en cada microservicio:

* **Controller** → Manejo de solicitudes HTTP
* **Service** → Lógica de negocio
* **Repository** → Acceso a datos
* **Model (Entity)** → Representación de la base de datos

---

## 📌 Características

* Arquitectura basada en microservicios
* Independencia entre servicios
* API REST
* Persistencia con JPA / Hibernate
* Generación automática de tablas
* Comunicación entre microservicios
* Logs con SLF4J
* Separación clara de responsabilidades

---

## 👥 Integrantes

* Daniela Salinas
* Danilo Guzman
* Ignacio Castro

---

## 📚 Contexto Académico

Proyecto desarrollado para la asignatura de Desarrollo FullStack, enfocado en la implementación de microservicios utilizando Spring Boot y bases de datos relacionales.

---

## 🚀 Estado del Proyecto

✔ Proyecto completamente funcional  
✔ Todos los microservicios implementados  
✔ Endpoints probados correctamente  
✔ Integración con base de datos operativa  
✔ Comunicación entre microservicios implementada  
✔ Logs implementados  
