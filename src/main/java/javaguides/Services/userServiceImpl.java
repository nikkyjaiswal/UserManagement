package javaguides.Services;

import javaguides.Entity.users;
import javaguides.Mapper.UserMapper;
import javaguides.Repository.userRepository;
import javaguides.UserDto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class userServiceImpl {
    private userRepository userRepository;


    public UserDto createUser(UserDto userDto) {
       // UserDto to user JPA entity
            users user= UserMapper.mapTousers(userDto);

        users savedUser = userRepository.save(user);
        // users JPA entity to UserDto
    UserDto savedUserDto=UserMapper.mapToUserdto(user);
    return savedUserDto;
    }

    public UserDto getUserById(Long id) {
        Optional<users> user = userRepository.findById(id);
        users users= user.orElse(null);
        return UserMapper.mapToUserdto(users);

    }

    public List<UserDto> getAllUsers() {
        List<users> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserdto).collect(Collectors.toList());
    }


    public UserDto updateUser( UserDto user) {
        users existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        users updateduser =userRepository.save(existingUser);
        return UserMapper.mapToUserdto(updateduser);
    }

    public void deleteUser(Long id) {
    userRepository.deleteById(id);

    }
}
