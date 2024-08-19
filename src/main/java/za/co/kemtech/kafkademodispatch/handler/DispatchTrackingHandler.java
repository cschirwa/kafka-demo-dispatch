package za.co.kemtech.kafkademodispatch.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import za.co.kemtech.kafkademodispatch.model.DispatchPreparing;
import za.co.kemtech.kafkademodispatch.service.DispatchService;
import za.co.kemtech.kafkademodispatch.service.TrackingService;

@Slf4j
@Component
@RequiredArgsConstructor
public class DispatchTrackingHandler {

    private final TrackingService trackingService;

    @KafkaListener(id = "dispatchTrackingConsumerClient", topics = "dispatch.tracking",
            groupId = "tracking.dispatch.tracking", containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(DispatchPreparing dispatchPreparing){
        trackingService.process(dispatchPreparing);
    }
}
