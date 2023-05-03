package com.andriiv.in100gram.facade;

import com.andriiv.in100gram.dto.UserDTO;
import com.andriiv.in100gram.entities.User;
import org.springframework.stereotype.Component;

/**
 * Created by Roman Andriiv (03.05.2023 - 09:43)
 */
@Component
public class UserFacade {

    public UserDTO usertoUserDTO(User user){

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUsername(user.getUsername());
        userDTO.setBio(userDTO.getBio());

        return userDTO;

    }
}
