package com.apirest.webflux.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@Configuration
public class ConfigRabbitMQ {

    //@PostConstruct
    public static void send() throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, InterruptedException {

        String uri = System.getenv("CLOUDAMQP_URL");
        if (uri == null) uri = "amqp://guest:guest@localhost";

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("bllgogzg");
        factory.setPassword("t0wumviI14BrHZ36hNQVOh20h6U-DqbZ");
        factory.setVirtualHost("bllgogzg");
        factory.setHost("mosquito.rmq.cloudamqp.com");
        //factory.setPort(1883);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("teste", false, false, false, null);
        String message = "Teste CloudAMQP!";
        channel.basicPublish("", "teste", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume("hello", true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message1 = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message1 + "'");
        }
    }
}
