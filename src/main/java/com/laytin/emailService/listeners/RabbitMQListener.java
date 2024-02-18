package com.laytin.emailService.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laytin.emailService.models.TripOrder;
import com.laytin.emailService.service.TripOrderNotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {
    private final TripOrderNotificationService tripOrderNotificationService;
    private final ObjectMapper objectMapper;
    @Autowired
    public RabbitMQListener(TripOrderNotificationService tripOrderNotificationService, ObjectMapper objectMapper) {
        this.tripOrderNotificationService = tripOrderNotificationService;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "q.order-create")
    public void receivedMessage2(String o) {
        System.out.println("message in queue `q.order-create`");
        try {
            tripOrderNotificationService.notifyOwner(objectMapper.readValue(o, TripOrder.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @RabbitListener(queues = "q.order-edit")
    public void receivedMessage1(String o) {
        System.out.println("message in queue `q.order-edit`");
    }
}
