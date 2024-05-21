package javaguides.Mapper;


import javaguides.Entity.users;
import javaguides.UserDto.UserDto;

public class UserMapper {
    public static UserDto mapToUserdto(users user) {
        UserDto userdto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
                );
        return userdto;
    }
    public static users mapTousers(UserDto userdto) {
        users user = new users(
                userdto.getId(),
                userdto.getFirstName(),
                userdto.getLastName(),
                userdto.getEmail());
        return user;

    }
}
