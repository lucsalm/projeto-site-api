package com.project.mapper;

import com.project.dto.UserRequestDTO;
import com.project.dto.UserRequestRegisterDTO;
import com.project.model.User;
import com.project.security.SecurityService;

public class UserMapper {
    
    public static User toUser(UserRequestDTO userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());

        user.setPassword(SecurityService.convertPassword(userDto.getPassword()));
        if(userDto instanceof UserRequestRegisterDTO){
            UserRequestRegisterDTO userRequestDTO = (UserRequestRegisterDTO) userDto;
            user.setUsername(userRequestDTO.getUsername());
            user.setTelephone(userRequestDTO.getTelephone());
        }

        return user;
    }


}
