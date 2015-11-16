package org.fbc.prototypes.websocket_push_to_browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private SimpMessagingTemplate template;

    @Autowired
    public MessageService(SimpMessagingTemplate template) {
    	System.out.println("created Message service");
        this.template = template;
    }

    @Scheduled(fixedDelay=1000)
    public void send() {
    	System.out.println("autofire");
        this.template.convertAndSend("/topic/updates", new Message("Update from " + System.currentTimeMillis()));
    }

}