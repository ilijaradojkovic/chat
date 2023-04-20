package com.example.chat;

import com.example.chat.entity.request.ChatMessageRequest;
import com.example.chat.entity.body.DeleteChatBody;
import com.example.chat.entity.response.chat.ChatMessageDetailsResponseHolder;
import com.example.chat.entity.response.chat.ChatCardResponseHolder;

public interface Chat {

     ChatMessageRequest send(ChatMessageRequest message);
     ChatCardResponseHolder getAllChats(String id);
     ChatMessageDetailsResponseHolder getChatDetails(String id, String otherSide);
     String deleteChat(String id, DeleteChatBody deleteChatBody);

}
