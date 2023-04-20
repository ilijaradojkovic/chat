package com.example.chat.controller;

import com.example.chat.chatimpl.CometChatImpl;
import com.example.chat.entity.request.ChatMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {
    private final CometChatImpl chatImpl;

    @PostMapping()
    public ChatMessageRequest chatMessageSend(@RequestBody ChatMessageRequest chatMessageRequest){
      return  chatImpl.send(chatMessageRequest);
    }


}
