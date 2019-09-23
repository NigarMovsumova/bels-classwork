package az.pashabank.ls.belsclasswork.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CustomerDTO {

    private static Long instanceCounter = Long.valueOf(0);

    private Long counter = Long.valueOf(0);

    private String name;

    public CustomerDTO(String name) {
        instanceCounter++;
        counter = instanceCounter;
        this.name = name;
    }


}
