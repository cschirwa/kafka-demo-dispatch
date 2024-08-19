package za.co.kemtech.kafkademodispatch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import za.co.kemtech.kafkademodispatch.model.OrderCreated;
import za.co.kemtech.kafkademodispatch.model.OrderDispatched;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class DispatchService {

    private static final String ORDER_DISPATCHED_TOPIC = "order.dispatched";
    private static final String ORDER_TRACKING_TOPIC = "dispaatch.tracking";
    private final KafkaTemplate kafkaProducer;
    public void process(OrderCreated payload) throws Exception {
        OrderDispatched orderDispatched = OrderDispatched.builder()
                .id(payload.getId())
                .item(payload.getItem())
                .build();
        kafkaProducer.send(ORDER_DISPATCHED_TOPIC, orderDispatched).get();
    }
}
