package uz.pdp.appclickup.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginDTO {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
