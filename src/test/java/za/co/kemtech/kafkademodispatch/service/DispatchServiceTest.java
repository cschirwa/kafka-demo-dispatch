package za.co.kemtech.kafkademodispatch.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;
import za.co.kemtech.kafkademodispatch.model.OrderCreated;
import za.co.kemtech.kafkademodispatch.model.OrderDispatched;
import za.co.kemtech.kafkademodispatch.util.TestEventData;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static org.hamcrest.Matchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RequiredArgsConstructor
class DispatchServiceTest {

    private DispatchService service;
    private KafkaTemplate kafkaProducerMock;

    @BeforeEach
    void setUp() {
        kafkaProducerMock = mock(KafkaTemplate.class);
        service = new DispatchService(kafkaProducerMock);

    }

    @Test
    void process() throws Exception {
        when(kafkaProducerMock.send(anyString(), any(OrderDispatched.class))).thenReturn(mock(CompletableFuture.class));
        OrderCreated eventData = TestEventData.buildOrderEvent(UUID.randomUUID(), UUID.randomUUID().toString());
        service.process(eventData);
verify(kafkaProducerMock, times(1)).send(eq("order.dispatched"), any(OrderDispatched.class));
    }
}