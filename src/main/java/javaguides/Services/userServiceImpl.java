package javaguides.Services;

import javaguides.Entity.users;
import javaguides.Mapper.AutoUserMapper;
import javaguides.Mapper.UserMapper;
import javaguides.Repository.userRepository;
import javaguides.UserDto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class userServiceImpl {

    private userRepository userRepository;
    private ModelMapper modelmapper;


    public UserDto createUser(UserDto userDto) {
        // UserDto to user JPA entity
        //users user= UserMapper.mapTousers(userDto);
        // users user = modelmapper.map(userDto, users.class);
        users user = AutoUserMapper.Mapper.mapTousers(userDto);
        users savedUser = userRepository.save(user);
        // users JPA entity to UserDto
        // UserDto savedUserDto=UserMapper.mapToUserdto(user);
        //UserDto savedUserDto = modelmapper.map(savedUser, UserDto.class);
        UserDto savedUserDto = AutoUserMapper.Mapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    public UserDto getUserById(Long id) {
        Optional<users> user = userRepository.findById(id);
        users users = user.orElse(null);
        //return UserMapper.mapToUserdto(users);
        //return modelmapper.map(users, UserDto.class);
        return AutoUserMapper.Mapper.mapToUserDto(users);

    }

    public List<UserDto> getAllUsers() {
        List<users> users = userRepository.findAll();
        //return users.stream().map(UserMapper::mapToUserdto).collect(Collectors.toList());
       // return users.stream().map(users1 -> modelmapper.map(users1, UserDto.class)).collect(Collectors.toList());
        return users.stream().map(AutoUserMapper.Mapper::mapToUserDto).collect(Collectors.toList());
    }


    public UserDto updateUser(UserDto user) {
        users existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        users updateduser = userRepository.save(existingUser);
        //return modelmapper.map(updateduser, UserDto.class);
        return AutoUserMapper.Mapper.mapToUserDto(updateduser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
