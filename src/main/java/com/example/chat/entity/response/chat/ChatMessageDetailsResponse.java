package com.example.chat.entity.response.chat;

import com.example.chat.entity.body.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class ChatMessageDetailsResponse {
    private String id;
    private String conversationId;
    private String sender;
    private String receiverType;
    private String receiver;
    private String category;
    private String type;
    private Data data;
    private float sentAt;
    private float updatedAt;





}


