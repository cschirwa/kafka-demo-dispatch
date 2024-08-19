package za.co.kemtech.kafkademodispatch.service;


import org.springframework.stereotype.Service;
import za.co.kemtech.kafkademodispatch.model.DispatchPreparing;

@Service
public class TrackingService {

    private static final String ORDER_TRACKING_TOPIC = "dispatch.tracking";

    public void process(DispatchPreparing dispatchPreparing) {
    }
}
