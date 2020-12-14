package jackson.schema.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LivingRoom implements Facility {
    private String atmosphere;
}
