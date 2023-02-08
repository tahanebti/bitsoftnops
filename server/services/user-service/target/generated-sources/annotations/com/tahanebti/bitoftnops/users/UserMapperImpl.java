package com.tahanebti.bitoftnops.users;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-07T17:08:18+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toCreate(CreateUserRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( request.getUsername() );
        user.password( request.getPassword() );
        user.email( request.getEmail() );

        return user.build();
    }

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( user.getId() );
        userResponse.username( user.getUsername() );
        userResponse.email( user.getEmail() );
        userResponse.updatedAt( user.getUpdatedAt() );
        userResponse.createdAt( user.getCreatedAt() );

        return userResponse.build();
    }

    @Override
    public void updateFromRequest(UpdateUserRequest request, User user) {
        if ( request == null ) {
            return;
        }

        if ( request.getUsername() != null ) {
            user.setUsername( request.getUsername() );
        }
        if ( request.getEmail() != null ) {
            user.setEmail( request.getEmail() );
        }
    }
}
