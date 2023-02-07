package com.tahanebti.bitoftnops.roles;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.tahanebti.bitOftnOps.core.utils.EnumUtil;



@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = EnumUtil.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface RoleMapper {

    UserRole toCreate(CreateRoleRequest request);

    public RoleResponse toResponse(UserRole role);
    
    void updateFromRequest(UpdateRoleRequest request, @MappingTarget UserRole role);

}