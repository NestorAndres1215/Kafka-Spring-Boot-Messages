package com.example.consumer_service.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MessageConsumer {

    private static final String FILE_PATH = "mensajes-recibidos.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @KafkaListener(topics = "demo-topic", groupId = "group_id")
    public void listen(String message) {
        System.out.println("Mensaje recibido del topic: " + message);
        guardarEnArchivo(message);
    }

    private void guardarEnArchivo(String mensaje) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String mensajeFormateado = "[" + timestamp + "] Mensaje recibido: " + mensaje;
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(mensajeFormateado);
        } catch (IOException e) {
            System.err.println("Error al guardar mensaje en archivo: " + e.getMessage());
        }
    }
}