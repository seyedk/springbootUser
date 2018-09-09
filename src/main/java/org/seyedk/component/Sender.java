/*
 * Copyright (c) 2018. Developed by Seyed Ketabchi on 9/9/18 2:14 PM. Last Modified 9/7/18 9:51 AM. Please use as is under your own discretion.
 */

package org.seyedk.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;




@Component
public class Sender {
    RabbitMessagingTemplate template;

    @Autowired
    Sender(RabbitMessagingTemplate template) {
        this.template = template;


    }

    @Bean
    Queue queue() {
        return new Queue("SearchQ", false);
    }

    public void send(Object message) {
        template.convertAndSend("SearchQ", message);

    }
}


