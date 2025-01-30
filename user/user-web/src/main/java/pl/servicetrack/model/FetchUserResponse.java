package pl.servicetrack.model;

import pl.servicetrack.user.model.User;

import java.util.UUID;

public record FetchUserResponse(UUID id,
                                String firstName,
                                String lastName,
                                String email,
                                String phoneNumber,
                                Role role) {

    public enum Role {
        ADMIN,
        USER
    }
}
