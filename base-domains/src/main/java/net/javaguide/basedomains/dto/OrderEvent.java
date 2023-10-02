package net.javaguide.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
    private String message;
    private String status;
    private String replyTopic;
    private Order order;

    @Override
    public String toString() {
        return "OrderEvent [message=" + message + ", status=" + status + ", replyTopic=" + replyTopic + ", order="
                + order + "]";
    }    
}
