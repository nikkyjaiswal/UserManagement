package javaguides.Mapper;

import javaguides.Entity.users;
import javaguides.UserDto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper Mapper = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(users user);

    users mapTousers(UserDto userdto);
}