package za.co.kemtech.kafkademodispatch.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.kemtech.kafkademodispatch.model.OrderCreated;
import za.co.kemtech.kafkademodispatch.service.DispatchService;
import za.co.kemtech.kafkademodispatch.util.TestEventData;

import java.util.UUID;

import static org.mockito.Mockito.*;

class OrderCreatedCreatedHandlerTest {

    private OrderCreatedHandler handler;
    private DispatchService dispatchServiceMock;

    @BeforeEach
    void setUp() {
        dispatchServiceMock = mock(DispatchService.class);
        handler = new OrderCreatedHandler(dispatchServiceMock);
    }

    @Test
    void listen_Success() throws Exception {
        OrderCreated eventData = TestEventData.buildOrderEvent(UUID.randomUUID(), UUID.randomUUID().toString());
        handler.listen(eventData);
        verify(dispatchServiceMock, times(1)).process(eventData);
    }


}