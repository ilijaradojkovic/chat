package com.example.chat.entity.response.chat;

import com.example.chat.entity.body.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatCardResponse {
    private String conversationId;
    private String conversationType;
    private String unreadMessageCount;
    private float createdAt;
    private float updatedAt;
    LastMessage lastMessage;


@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
    public class LastMessage {

    private Data data;
        private float sentAt;


    }


}






