# Notas

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.3-6DB33F)
![MongoDB](https://img.shields.io/badge/MongoDB-47A248)
![Kafka](https://img.shields.io/badge/Apache_Kafka-black)
![JWT](https://img.shields.io/badge/Auth-JWT-blue)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36)


Microservicio REST desarrollado con **Spring Boot** para la gestión de notas.

Permite crear, consultar, actualizar y eliminar notas, protege los endpoints mediante **JWT**, persiste los datos en **MongoDB** y publica eventos en **Kafka** cuando se crea una nueva nota.

---

## Enfoque del proyecto

> Este proyecto no solo tiene un objetivo funcional, sino también formativo. Ha servido como entorno de aprendizaje para incorporar y aplicar tecnologías que no había trabajado previamente durante el grado superior, adquiriendo experiencia práctica en su uso, entendiendo mejor cómo se integran dentro de una arquitectura real y reforzando una base técnica más sólida.

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
