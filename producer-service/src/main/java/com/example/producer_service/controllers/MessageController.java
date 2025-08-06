package com.example.producer_service.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.producer_service.model.MessageRequest;

@RestController
@RequestMapping("/mensaje")
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.kafka.topic}")
    private String topic;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String enviarMensaje(@RequestBody MessageRequest request) {
        kafkaTemplate.send(topic, request.getMessage());
        return "Mensaje enviado: " + request.getMessage();
    }

}
