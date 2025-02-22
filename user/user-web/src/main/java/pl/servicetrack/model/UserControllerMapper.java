package pl.servicetrack.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.servicetrack.user.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Mapper
public interface UserControllerMapper {

    UserControllerMapper INSTANCE = Mappers.getMapper(UserControllerMapper.class);

    User registerRequestBodyToUser(RegisterRequest createUserRequest, UUID id, User.Role role, LocalDateTime createdAt);
    RegisterResponse userToRegisterResponse(User user);
    User updateRequestBodyToUser(UpdateUserRequest updateUserRequest, UUID id);
    FetchUserResponse userToFetchUserResponse(User user);
    LoginResponse tokenToAuthenticationResponse(String token);
}
