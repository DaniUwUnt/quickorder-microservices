# 🧾 QuickOrder Microservices

Sistema de gestión de pedidos basado en una arquitectura de microservicios desarrollado con Spring Boot, Spring Cloud, Eureka Server, API Gateway, OpenFeign y Docker.

---

# 📦 Descripción del Proyecto

QuickOrder es un sistema distribuido para la gestión de pedidos que utiliza una arquitectura de microservicios. Cada servicio tiene una responsabilidad específica, permitiendo una mejor escalabilidad, mantenibilidad y desacoplamiento entre componentes.

Actualmente el proyecto implementa comunicación entre microservicios mediante **Spring Cloud OpenFeign** y **Eureka Server**, utilizando el patrón de descubrimiento de servicios.

---

# 🧩 Microservicios Implementados

El sistema está compuesto por los siguientes servicios:

- **users-service** → Gestión de usuarios.
- **products-service** → Gestión de productos.
- **orders-service** → Gestión de pedidos.
- **api-gateway** → Punto único de acceso a los microservicios.
- **eureka-server** → Registro y descubrimiento de servicios.

---

# 🛠️ Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Spring Cloud OpenFeign
- Eureka Server
- Spring Cloud Gateway
- MySQL
- Maven
- Docker
- Docker Compose
- Swagger / OpenAPI
- Git y GitHub
- JUnit 5
- Mockito
- SLF4J

---

# 🌐 Servicios Implementados

| Servicio | Puerto | Descripción |
|----------|:------:|-------------|
| Eureka Server | **8761** | Registro y descubrimiento de servicios |
| API Gateway | **8090** | Punto único de entrada al sistema |
| Orders Service | **8085** | Gestión de pedidos |
| Users Service | **8081** | Gestión de usuarios |
| Products Service | **8082** | Gestión de productos |

---

# 🔗 Comunicación entre Microservicios

La comunicación entre servicios se realiza mediante **Spring Cloud OpenFeign**, utilizando **Eureka Server** para localizar automáticamente cada servicio registrado.

Actualmente se implementa la siguiente comunicación:

- Orders Service → Users Service
- Orders Service → Products Service

Gracias a Eureka, Orders Service no necesita conocer las direcciones IP ni los puertos de los demás servicios; únicamente utiliza el nombre lógico del servicio registrado.

---

# 🏗️ Arquitectura

```text
                 Cliente
                    │
                    ▼
          API Gateway (8090)
                    │
                    ▼
           Eureka Server (8761)
                    │
        ┌───────────┴───────────┐
        │                       │
        ▼                       ▼
 Orders Service (8085)     Users Service (8081)
        │
        ▼
 Products Service (8082)
```

Cada microservicio posee su propia base de datos MySQL y puede desplegarse de forma independiente.

---

# 📖 Documentación API

Cada microservicio dispone de documentación interactiva mediante Swagger/OpenAPI.

| Servicio | URL |
|----------|-----|
| Orders Service | http://localhost:8085/swagger-ui/index.html |
| Users Service | http://localhost:8081/swagger-ui/index.html |
| Products Service | http://localhost:8082/swagger-ui/index.html |

---

# 🚀 Endpoints de Comunicación

Orders Service consume información desde otros microservicios mediante OpenFeign.

### Obtener usuarios desde Users Service

```
GET /api/pedidos/usuarios
```

### Obtener productos desde Products Service

```
GET /api/pedidos/productos
```

También pueden accederse mediante el API Gateway:

```
GET http://localhost:8090/api/pedidos/usuarios
GET http://localhost:8090/api/pedidos/productos
```

---

# 🗄️ Base de Datos

Cada microservicio utiliza una base de datos independiente en MySQL:

- quickorder_users
- quickorder_products
- quickorder_orders

Esto permite mantener el desacoplamiento entre servicios.

---

# ✅ Funcionalidades Implementadas

- CRUD de Usuarios
- CRUD de Productos
- CRUD de Pedidos
- Validaciones con Bean Validation
- Documentación con Swagger/OpenAPI
- Registro de servicios mediante Eureka
- API Gateway
- Comunicación entre microservicios con OpenFeign
- Persistencia con Spring Data JPA y MySQL
- Logging mediante SLF4J

---

# 📁 Repositorio

Repositorio del proyecto:

https://github.com/DaniUwUnt/quickorder-microservices
