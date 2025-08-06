# Kafka-Spring-Boot-Messages

Sistema de microservicios con **Spring Boot** y **Apache Kafka** que permite enviar mensajes desde un productor (API REST) hacia un consumidor, que los guarda en un archivo `.txt`.

---

## 🛠️ Herramientas Utilizadas

- Java 17
- Spring Boot
- Apache Kafka
- Docker
- Maven

---

## 📦 Dependencias Clave

- `spring-boot-starter-web`
- `spring-kafka`
- `lombok` (opcional)

---

## ⚙️ ¿Qué hace este proyecto?

- El **Producer Service** expone un endpoint HTTP para publicar mensajes en un tópico Kafka.
- El **Consumer Service** escucha ese tópico y guarda los mensajes recibidos con fecha/hora en un archivo de texto.

