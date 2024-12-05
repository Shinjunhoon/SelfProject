package com.example.demo.Dto;


import com.example.demo.Domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {

    String passWord;
    String userName;
    String userEmail;

    public User fromUserRequestDto(UserRequestDto userRequestDto){
        return new User(null,userRequestDto.getPassWord(),userRequestDto.getUserName(),userRequestDto.getUserEmail());
    }
}
