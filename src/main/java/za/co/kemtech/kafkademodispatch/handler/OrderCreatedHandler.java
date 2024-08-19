package za.co.kemtech.kafkademodispatch.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import za.co.kemtech.kafkademodispatch.model.OrderCreated;
import za.co.kemtech.kafkademodispatch.service.DispatchService;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedHandler {

    private final DispatchService dispatchService;

    @KafkaListener(id = "orderConsumerClient",
            groupId = "dispatch.order.created.consumer",
            topics = "order.created",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(OrderCreated payload){
        log.info("Message consumed : payload " + payload);
        try {
            dispatchService.process(payload);
        } catch (Exception e) {
            log.error("Processing failed", e);
        }
    }


}
