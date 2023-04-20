package com.example.chat.chatimpl;

import com.example.chat.Chat;
import com.example.chat.entity.request.ChatMessageRequest;
import com.example.chat.entity.body.ChatMessageBody;
import com.example.chat.entity.body.Data;
import com.example.chat.entity.body.DeleteChatBody;
import com.example.chat.entity.response.chat.ChatMessageDetailsResponseHolder;
import com.example.chat.entity.response.chat.ChatCardResponseHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CometChatImpl implements Chat {

    private String apiKey="9a2aa8150b2512c76154259e67964e6b46b44856";
    private final WebClient webClient;
    @Override
    public ChatMessageRequest send(ChatMessageRequest message) {
        webClient.post()
                .uri("https://23727500d0acf346.api-eu.cometchat.io/v3/messages")
                .header("apikey",apiKey)
                .header("onBehalfOf",message.getFrom())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new ChatMessageBody("message","text",message.getTo(),"user",new Data(message.getContent())))
                .retrieve().bodyToMono(Void.class).block();

        return message;
    }

    @Override
    public ChatCardResponseHolder getAllChats(String id) {

        return  webClient.get()
                .uri("https://23727500d0acf346.api-eu.cometchat.io/v3/conversations?perPage=100&page=1")
                .header("apikey", apiKey)
                .header("onBehalfOf", id)
                .retrieve()
                .bodyToMono(ChatCardResponseHolder.class)
                .block();

    }

    @Override
    public ChatMessageDetailsResponseHolder getChatDetails(String id, String otherSide) {
        Mono<ChatMessageDetailsResponseHolder> chatMessageDetailsResponseHolderMono = webClient.get()
                .uri("https://23727500d0acf346.api-eu.cometchat.io/v3/users/" + id + "/messages")
                .header("apikey", apiKey)
                .header("onBehalfOf", otherSide)
                .retrieve()
                .bodyToMono(ChatMessageDetailsResponseHolder.class);

        return chatMessageDetailsResponseHolderMono.block();

    }

    @Override
    public String deleteChat(String id, DeleteChatBody deleteChatBody) {
        webClient.method(HttpMethod.DELETE)
                .uri("https://23727500d0acf346.api-eu.cometchat.io/v3/users/"+id+"/conversation")
                .header("apikey", apiKey)
                .header("onBehalfOf", id)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(deleteChatBody)
                .retrieve()
                .bodyToMono(Void.class).block();

        return id;
    }
}
