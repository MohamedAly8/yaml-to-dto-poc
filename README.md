### Demo instructions

- View YAML in this path: `src/main/resources/openapi.yaml`


- Run `./gradlew clean build` to generate DTOs, they will be generated in `build/generated-src/openapi/main/src/main/java/com/example/model`

- View Run Main.java to see some sample usages

```
package com.example;

import com.example.model.Item;
import com.example.model.LineItem;
import com.example.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.OffsetDateTime;
import java.util.List;


public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Item keyboard = Item.builder()
                .withItemId("someId")
                .withName("Ergonomic Keyboard")
                .withPrice(125.00)
                .build();

        Item mouse = Item.builder()
                .withItemId("someId")
                .withName("Vertical Mouse")
                .withPrice(45.99)
                .build();

        LineItem keyboardLine = LineItem.builder()
                .withQuantity(1)
                .withItem(keyboard)
                .build();

        LineItem mouseLine = LineItem.builder()
                .withQuantity(2)
                .withItem(mouse)
                .build();


        Order newOrder = Order.builder()
                .withOrderId("some other Id")
                .withCustomerEmail("test.user@example.com")
                .withItems(List.of(keyboardLine, mouseLine))
                .withOrderDate(OffsetDateTime.now())
                .build();


        // -- Getters --
        String someId = newOrder.getOrderId();
        System.out.println("New order Id: " + someId);

        // --- Composition and Serialization ---
        System.out.println("--- Generated DTOs using Lombok Builders ---");
        System.out.println("Item DTO: " + keyboard.toString());
        System.out.println("LineItem DTO: " + keyboardLine);
        System.out.println("Order DTO: " + newOrder.toString());

        System.out.println("\n--- Serialization Demo (Requires ObjectMapper) ---");
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
        String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newOrder);
        System.out.println("--- Order JSON Output (Showcasing Nested Structure) ---");
        System.out.println(jsonOutput);
    }
}
```
