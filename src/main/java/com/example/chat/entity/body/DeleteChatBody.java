package com.example.chat.entity.body;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeleteChatBody {


     private Boolean   deleteMessagesPermanently;
     private String conversationWith;

}
