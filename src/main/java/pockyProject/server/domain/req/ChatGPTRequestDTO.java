package pockyProject.server.domain.req;

import lombok.Data;
import pockyProject.server.domain.res.ChatGPTMessage;

import java.util.ArrayList;
import java.util.List;
@Data
public class ChatGPTRequestDTO {
    private String model;
    private List<ChatGPTMessage> messages;

    public ChatGPTRequestDTO(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new ChatGPTMessage("user", prompt));
    }
}