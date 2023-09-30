package com.javaguides.springboot.mapper;

import com.javaguides.springboot.dto.UserDto;
import com.javaguides.springboot.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-18T21:19:11+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
public class AutoGenerateUserMapperImpl implements AutoGenerateUserMapper {

    @Override
    public User convertToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userDto.getEmail() );
        user.setFirstName( userDto.getFirstName() );
        user.setId( userDto.getId() );
        user.setLastName( userDto.getLastName() );

        return user;
    }

    @Override
    public UserDto convertToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setEmail( user.getEmail() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setId( user.getId() );
        userDto.setLastName( user.getLastName() );

        return userDto;
    }
}
