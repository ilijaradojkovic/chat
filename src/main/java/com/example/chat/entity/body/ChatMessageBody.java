package com.example.chat.entity.body;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatMessageBody {
    private String category;
    private String type;
    private String receiver;
    private String receiverType;
    private com.example.chat.entity.body.Data data;

}
