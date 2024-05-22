package javaguides.UserDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    //user first name should not be empty
    @NotEmpty(message="first name cant be empty")
    private String firstName;
    //user last name should not be empty
    @NotEmpty(message="last name cannot be empty")
    private String lastName;
    //user email  should not be empty and should be emailformat
    @NotEmpty(message="email can not be empty")
    @Email(message="should be in email format")
    private String email;
}
