package weawe.praybook.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import weawe.praybook.service.GroupService;
import weawe.praybook.web.dto.GroupResponseDto;
import weawe.praybook.web.dto.GroupSaveRequestDto;
import weawe.praybook.web.dto.GroupUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class GroupApiController {

    private final GroupService groupService;

    @PostMapping("/api/group")
    public Long save(@RequestBody GroupSaveRequestDto requestDto) {
        return groupService.save(requestDto);
    }

    @PutMapping("/api/group/{id}")
    public Long update(@PathVariable Long id, @RequestBody GroupUpdateRequestDto requestDto) {
        return groupService.update(id, requestDto);
    }

    @GetMapping("/api/group/{id}")
    public GroupResponseDto findById (@PathVariable Long id) {
        return groupService.findById(id);
    }

    @DeleteMapping("/api/group/{id}")
    public Long delete(@PathVariable Long id) {
        groupService.delete(id);
        return id;
    }
}
