package javaguides.Services;

import javaguides.Entity.users;
import javaguides.Exception.EmailsAlredyExists;
import javaguides.Exception.ResourceNotFoundException;
import javaguides.Mapper.AutoUserMapper;
import javaguides.Repository.userRepository;
import javaguides.UserDto.UserDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
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
        Optional<users> userEmail= userRepository.findByEmail(userDto.getEmail());
        if(userEmail.isPresent()){
            throw new EmailsAlredyExists("Email  already exist for this user");
        }
        users user = AutoUserMapper.Mapper.mapTousers(userDto);
        users savedUser = userRepository.save(user);
        // users JPA entity to UserDto
        // UserDto savedUserDto=UserMapper.mapToUserdto(user);
        //UserDto savedUserDto = modelmapper.map(savedUser, UserDto.class);
        UserDto savedUserDto = AutoUserMapper.Mapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    public UserDto getUserById(Long id) {
        users user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
       // users users = user.orElse(null);
        //return UserMapper.mapToUserdto(users);
        //return modelmapper.map(users, UserDto.class);
        return AutoUserMapper.Mapper.mapToUserDto(user);

    }

    public List<UserDto> getAllUsers() {
        List<users> users = userRepository.findAll();
        //return users.stream().map(UserMapper::mapToUserdto).collect(Collectors.toList());
       // return users.stream().map(users1 -> modelmapper.map(users1, UserDto.class)).collect(Collectors.toList());
        return users.stream().map(AutoUserMapper.Mapper::mapToUserDto).collect(Collectors.toList());
    }


    public UserDto updateUser(UserDto user) {
        users existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        users updateduser = userRepository.save(existingUser);
        //return modelmapper.map(updateduser, UserDto.class);
        return AutoUserMapper.Mapper.mapToUserDto(updateduser);
    }

    public void deleteUser(Long id) {
        users existingUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        userRepository.deleteById(id);

    }
}
