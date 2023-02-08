package com.tahanebti.bitoftnops.roles;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-07T17:08:18+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public UserRole toCreate(CreateRoleRequest request) {
        if ( request == null ) {
            return null;
        }

        UserRole.UserRoleBuilder userRole = UserRole.builder();

        if ( request.getName() != null ) {
            userRole.name( Enum.valueOf( RoleName.class, request.getName() ) );
        }

        return userRole.build();
    }

    @Override
    public RoleResponse toResponse(UserRole role) {
        if ( role == null ) {
            return null;
        }

        RoleResponse.RoleResponseBuilder roleResponse = RoleResponse.builder();

        roleResponse.id( role.getId() );
        if ( role.getName() != null ) {
            roleResponse.name( role.getName().name() );
        }
        roleResponse.createdAt( role.getCreatedAt() );
        roleResponse.updatedAt( role.getUpdatedAt() );

        return roleResponse.build();
    }

    @Override
    public void updateFromRequest(UpdateRoleRequest request, UserRole role) {
        if ( request == null ) {
            return;
        }

        if ( request.getId() != null ) {
            role.setId( request.getId() );
        }
        if ( request.getName() != null ) {
            role.setName( Enum.valueOf( RoleName.class, request.getName() ) );
        }
    }
}
