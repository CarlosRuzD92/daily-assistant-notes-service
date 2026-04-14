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

> Este proyecto nace con un doble objetivo: funcional y formativo. Más allá de su implementación técnica, ha sido una oportunidad para aprender y consolidar tecnologías backend que no había trabajado previamente en profundidad durante el grado superior. Su desarrollo me ha permitido practicar integración entre microservicios, seguridad con JWT, persistencia con MongoDB, comunicación asíncrona con Kafka y despliegue con Docker. Además, he utilizado herramientas de apoyo como la documentación oficial, recursos técnicos y asistencia puntual con IA, siempre con el objetivo de revisar, adaptar y comprender cada solución aplicada.

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
