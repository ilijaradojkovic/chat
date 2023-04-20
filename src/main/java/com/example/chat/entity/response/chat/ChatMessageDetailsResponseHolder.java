package com.example.chat.entity.response.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatMessageDetailsResponseHolder {

    private List<ChatMessageDetailsResponse> data;
}
