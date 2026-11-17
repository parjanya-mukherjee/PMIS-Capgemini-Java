
package com.versionone.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(
            @RequestParam("q") String q) {

        String response = chatClient.prompt()
                .user(q)
                .call()
                .content();

        return ResponseEntity.ok(response);
    }
}
