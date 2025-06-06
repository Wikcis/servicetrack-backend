package pl.servicetrack.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record AddTechnicianRequest(
        @NotNull
        UUID id,

        @Nullable
        UUID userId,

        @NotBlank
        @Size(max = 32)
        String firstName,

        @NotBlank
        @Size(max = 64)
        String lastName,

        @NotBlank
        @Size(max = 32)
        String email,

        @NotBlank
        @Size(max = 9)
        String phoneNumber) {
}
