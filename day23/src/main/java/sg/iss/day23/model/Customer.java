package sg.iss.day23.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer id;

    @NotEmpty(message = "First Name is a mandatory field")
    private String firstName;

    @NotEmpty(message = "Last Name is a mandatory field")
    private String lastName;

}