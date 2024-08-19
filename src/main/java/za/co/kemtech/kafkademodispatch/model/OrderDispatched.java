package za.co.kemtech.kafkademodispatch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class OrderDispatched {
    private UUID id;
    private String item;
}
