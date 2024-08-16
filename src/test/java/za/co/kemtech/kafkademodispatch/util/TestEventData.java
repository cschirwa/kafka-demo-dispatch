package za.co.kemtech.kafkademodispatch.util;

import za.co.kemtech.kafkademodispatch.model.Order;

import java.util.UUID;

public class TestEventData {
    public static Order buildOrderEvent(UUID id, String item){
        return Order.builder()
                .id(id)
                .item(item)
                .build();

    }
}
