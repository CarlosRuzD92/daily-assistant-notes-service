# notas

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.3-6DB33F)
![MongoDB](https://img.shields.io/badge/MongoDB-47A248)
![Kafka](https://img.shields.io/badge/Apache_Kafka-black)
![JWT](https://img.shields.io/badge/Auth-JWT-blue)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36)

Microservicio REST desarrollado con **Spring Boot** para la gestión de notas.

Permite crear, consultar, actualizar y eliminar notas, protege los endpoints mediante **JWT**, persiste los datos en **MongoDB** y publica eventos en **Kafka** cuando se crea una nueva nota.

> Uso de herramientas de IA como asistente de desarrollo para acelerar el flujo de trabajo y asegurar una arquitectura limpia.

---

## Funcionalidades

- CRUD completo de notas
- Protección de endpoints con JWT
- Persistencia en MongoDB
- Publicación de eventos en Kafka al crear notas
- Logging estructurado
- Tests básicos de controlador, servicio y modelo

---

## Stack tecnológico

- **Java 21**
- **Spring Boot 3.5.3**
- **Spring Web**
- **Spring Data MongoDB**
- **Spring Security**
- **JWT**
- **Apache Kafka**
- **Lombok**
- **Logback**
- **JUnit 5**
- **Maven**

---

## Estructura del proyecto

```text
src/main/java/com/asistente/notas
├── config          # Configuración de seguridad
├── controlador     # Endpoints REST
├── eventos         # Eventos y publicación en Kafka
├── logs            # Logging y manejo global de errores
├── modelo          # Entidad Nota
├── repositorio     # Acceso a datos
├── seguridad       # Filtro JWT y utilidades
└── servicio        # Lógica de negocio
