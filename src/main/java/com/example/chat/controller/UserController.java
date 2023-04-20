package com.example.chat.controller;

import com.example.chat.chatimpl.CometChatImpl;
import com.example.chat.entity.body.DeleteChatBody;
import com.example.chat.entity.response.chat.ChatMessageDetailsResponseHolder;
import com.example.chat.entity.response.chat.ChatCardResponseHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController
{
    private final CometChatImpl chatImpl;

    @GetMapping("/{id}/messages")
    public ChatMessageDetailsResponseHolder getAllMessagesForChat(@PathVariable("id") String id, @RequestParam(name = "otherside") String otherSide){
       return  chatImpl.getChatDetails(id,otherSide);
    }
    @GetMapping("/{id}/chats")
    public ChatCardResponseHolder getALlUserChats(@PathVariable("id") String id){
       return  chatImpl.getAllChats(id);
    }
    @DeleteMapping("/{id}/chats")
    public String getALlUserChats(@PathVariable("id") String id,@RequestBody DeleteChatBody deleteChatBody){
       return  chatImpl.deleteChat(id,deleteChatBody);
    }
}
