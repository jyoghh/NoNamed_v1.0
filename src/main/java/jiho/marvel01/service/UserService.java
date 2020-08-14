package jiho.marvel01.service;

import jiho.marvel01.domain.Repository.UserRepository;
import jiho.marvel01.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

    @Transactional
    public Long saveUser(UserDto userDto) {
        return userRepository.save(userDto.toEntity()).getUid();
    }
}
