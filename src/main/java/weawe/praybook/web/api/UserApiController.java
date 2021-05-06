package weawe.praybook.web.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import weawe.praybook.service.UserService;
import weawe.praybook.web.dto.UserResponseDto;
import weawe.praybook.web.dto.UserSaveRequestDto;
import weawe.praybook.web.dto.UserUpdateRequestDto;

@RequiredArgsConstructor
@RestController
@Slf4j
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/user")
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        log.info("UserApiController-save");
        return userService.save(requestDto);
    }

    @PutMapping("/api/user/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto) {
        log.info("UserApiController-update");
        return userService.update(id, requestDto);
    }

    @GetMapping("/api/user/{id}")
    public UserResponseDto findById (@PathVariable Long id) {
        log.info("UserApiController-findById");
        return userService.findById(id);
    }

    @DeleteMapping("/api/user/{id}")
    public Long delete(@PathVariable Long id) {
        log.info("UserApiController-delete");
        userService.delete(id);
        return id;
    }
}
