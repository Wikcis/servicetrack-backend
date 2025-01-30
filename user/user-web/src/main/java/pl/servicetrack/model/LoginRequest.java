package pl.servicetrack.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 4, max = 64)
        String password) {
}
