package jiho.marvel01.service;

import jiho.marvel01.domain.Entity.UserEntity;
import jiho.marvel01.domain.Repository.UserRepository;
import jiho.marvel01.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

    @Transactional
    public Long saveUser(UserDto userDto) {
        return userRepository.save(userDto.toEntity()).getUid();
    }

    @Transactional
    public List<UserDto> getUserlist() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for(UserEntity userEntity : userEntities) {
            UserDto userDTO = UserDto.builder()
                    .uid(userEntity.getUid())
                    .name(userEntity.getName())
                    .email(userEntity.getEmail())
                    .corp(userEntity.getCorp())
                    .department(userEntity.getDepartment())
                    .i_group(userEntity.getI_group())
                    .build();

            userDtoList.add(userDTO);
        }
        return userDtoList;
    }

    @Transactional
    public List<UserDto> getUserlistbyId(List<Long> uids) {
        List<UserEntity> userEntities = userRepository.findAllById(uids);
        List<UserDto> userDtoList = new ArrayList<>();

        for(UserEntity userEntity : userEntities) {
            UserDto userDTO = UserDto.builder()
                    .uid(userEntity.getUid())
                    .name(userEntity.getName())
                    .email(userEntity.getEmail())
                    .corp(userEntity.getCorp())
                    .department(userEntity.getDepartment())
                    .i_group(userEntity.getI_group())
                    .build();

            userDtoList.add(userDTO);
        }
        return userDtoList;
    }

    @Transactional
    public UserDto getUser(Long uid) {
        Optional<UserEntity> userEntityWrapper = userRepository.findById(uid);
        UserEntity userEntity = userEntityWrapper.get();

        UserDto userDTO = UserDto.builder()
                .uid(userEntity.getUid())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .corp(userEntity.getCorp())
                .department(userEntity.getDepartment())
                .i_group(userEntity.getI_group())
                .build();

        return userDTO;
    }

    @Transactional
    public void deleteUser(Long uid) {
        userRepository.deleteById(uid);
    }

    @Transactional //idx 기준으로 조회하여 리스팅 후 유저 삭제
    public void deleteUsers(List<Long> uid) {
        List<UserEntity> userEntities = userRepository.findAllById(uid);
        List<UserDto> userDtoList = new ArrayList<>();

        for(UserEntity userEntity : userEntities) {
            userRepository.deleteById(userEntity.getUid());
        }
    }

}
