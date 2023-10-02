package net.javaguide.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private String name;
    private int quantity;
    private double price;

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
    }

}
