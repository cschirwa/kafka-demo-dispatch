package za.co.kemtech.kafkademodispatch.util;

import za.co.kemtech.kafkademodispatch.model.OrderCreated;

import java.util.UUID;

public class TestEventData {
    public static OrderCreated buildOrderEvent(UUID id, String item){
        return OrderCreated.builder()
                .id(id)
                .item(item)
                .build();

    }
}
