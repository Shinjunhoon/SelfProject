package com.example.demo.Service;

import com.example.demo.Domain.User;
import com.example.demo.Dto.UserRequestDto;
import com.example.demo.Dto.UserResponseDto;
import com.example.demo.Repository.UserRepository;
import jakarta.transaction.Transactional;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@FieldDefaults(makeFinal = true,level= AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class UserService {
    UserRepository userRepository;

    @Transactional
    public UserResponseDto save(UserRequestDto UserRequestDto){
      User user  =  userRepository.save(UserRequestDto.fromUserRequestDto(UserRequestDto));
        return UserResponseDto.builder()
            .UserId(user.getUserId())
            .build();
    }

    @Transactional
    public UserResponseDto findById(Integer id) throws UserPrincipalNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return UserResponseDto.builder()
                .userName(user.get().getUserName())
                .email(user.get().getUserEmail())
                .build();
        }
        else{
            throw  new UserPrincipalNotFoundException("user not foind with id: "+id);
        }
    }
    }
