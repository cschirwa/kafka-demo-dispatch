package za.co.kemtech.kafkademodispatch.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.kemtech.kafkademodispatch.model.Order;
import za.co.kemtech.kafkademodispatch.util.TestEventData;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
class DispatchServiceTest {

    private DispatchService service;

    @BeforeEach
    void setUp() {
        service = new DispatchService();

    }

    @Test
    void process() {
        Order eventData = TestEventData.buildOrderEvent(UUID.randomUUID(), UUID.randomUUID().toString());
        service.process(eventData);
    }
}