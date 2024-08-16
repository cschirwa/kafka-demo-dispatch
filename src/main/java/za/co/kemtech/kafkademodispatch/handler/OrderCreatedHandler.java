package za.co.kemtech.kafkademodispatch.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import za.co.kemtech.kafkademodispatch.service.DispatchService;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedHandler {

    private final DispatchService dispatchService;

    @KafkaListener(id = "orderConsumerClient",
            groupId = "dispatch.order.created.consumer",
            topics = "order.created"
    )
    public void listen(String payload){
        dispatchService.process(payload);
        log.info("Message consumed : payload " + payload);
    }


}
