package weawe.praybook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import weawe.praybook.domain.User;
import weawe.praybook.repository.UserRepository;
import weawe.praybook.web.dto.UserListResponseDto;
import weawe.praybook.web.dto.UserResponseDto;
import weawe.praybook.web.dto.UserSaveRequestDto;
import weawe.praybook.web.dto.UserUpdateRequestDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UserUpdateRequestDto requestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));
        user.update(requestDto.getName(), requestDto.getEmail(), requestDto.getPicture());
        return id;
    }

    public UserResponseDto findById (Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));
        return new UserResponseDto(entity);
    }

    @Transactional
    public List<UserListResponseDto> findAllDesc() {
        return userRepository.findAllDesc().stream()
                .map(UserListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다 id=" + id));

        userRepository.delete(user);
    }
}
