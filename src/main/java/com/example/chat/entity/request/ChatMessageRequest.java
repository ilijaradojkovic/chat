package com.example.chat.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ChatMessageRequest {

    public String from;
    public  String to;
    public String content;
}
