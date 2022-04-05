package The.Geeks.RESM.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import The.Geeks.RESM.dto.UserDto;
import The.Geeks.RESM.entity.UserEntity;
import The.Geeks.RESM.exception.UserException;
import The.Geeks.RESM.repositories.UserRepo;

@Service
public class UserServices {

    @Autowired
    UserRepo userRepo;

    public UserDto register(UserDto userDto) throws UserException {
        if (userDto.getUserName() != null && userDto.getPassword() != null) {
            if (userRepo.findByUserName(userDto.getUserName()).isEmpty()) {
                UserEntity userEntity = userRepo.save(userDtoToUSerEntity(userDto));
                return userDto.id(userEntity.getId());
            } else {
                throw new UserException("the UserName is aleady exist.");
            }

        } else {
            throw new UserException("required fields is null.");
        }

    }

    private UserEntity userDtoToUSerEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity()
                .id(userDto.getId())
                .userName(userDto.getUserName())
                .password(userDto.getPassword());
        return userEntity;
    }

    public UserDto login(UserDto userDto) throws UserException {
        Optional<UserEntity> entity;
        if ((entity = userRepo.findByUserName(userDto.getUserName())).isEmpty()) {
            throw new UserException("no user with this UserName");
        } else {
            if (entity.get().getPassword().equals(userDto.getPassword())) {
                return userEntityToUserDto(entity.get());
            } else {
                throw new UserException("wrong password");
            }
        }

    }

    private UserDto userEntityToUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto()
                .id(userEntity.getId())
                .userName(userEntity.getUserName())
                .password(userEntity.getPassword());
        return userDto;
    }

    public UserDto logout(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        if (userDto.getId() != null)
            userEntity = userRepo.findById(userDto.getId())
                    .orElseThrow(() -> new UserException("no user with this id"));
        userRepo.delete(userEntity);

        return userEntityToUserDto(userEntity);

    }

}
