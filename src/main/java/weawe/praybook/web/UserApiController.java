package weawe.praybook.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import weawe.praybook.service.UserService;
import weawe.praybook.web.dto.UserResponseDto;
import weawe.praybook.web.dto.UserSaveRequestDto;
import weawe.praybook.web.dto.UserUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/user")
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }

    @PutMapping("/api/user/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto) {
        return userService.update(id, requestDto);
    }

    @GetMapping("/api/user/{id}")
    public UserResponseDto findById (@PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/api/user/{id}")
    public Long delete(@PathVariable Long id) {
        userService.delete(id);
        return id;
    }
}
