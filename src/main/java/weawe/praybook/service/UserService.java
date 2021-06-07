package weawe.praybook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;


    /**
     * Spring Security 필수 메소드 구현
     *
     * @param email 이메일
     * @return UserDetails
     * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
     */
    @Override // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 UserInfo로 반환 타입 지정 (자동으로 다운 캐스팅됨)
    public User loadUserByUsername(String email) throws UsernameNotFoundException { // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException((email)));
    }

    /**
     * 회원정보 저장
     *
     * @param userSaveRequestDto 회원정보가 들어있는 DTO
     * @return 저장되는 회원의 PK
     */
    @Transactional
    public Long save(UserSaveRequestDto userSaveRequestDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userSaveRequestDto.setPassword(encoder.encode(userSaveRequestDto.getPassword()));

        return userRepository.save(User.builder()
                .email(userSaveRequestDto.getEmail())
                .password(userSaveRequestDto.getPassword())
                .auth(userSaveRequestDto.getAuth()).build()).getId();
    }

    @Transactional
    public Long update(Long id, UserUpdateRequestDto requestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));

        user.update(requestDto.getName(), requestDto.getEmail());

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
