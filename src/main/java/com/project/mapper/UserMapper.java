package com.project.mapper;

import com.project.dto.request.user.UserRequestDTO;
import com.project.dto.request.user.UserRequestRegisterDTO;
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
            user.setCep(userRequestDTO.getCep());
            user.setAddress(userRequestDTO.getAddress());
            user.setAddressNumber(userRequestDTO.getAddressNumber());
        }

        return user;
    }


}
