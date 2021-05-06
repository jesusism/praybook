package weawe.praybook.web.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import weawe.praybook.service.PrayService;
import weawe.praybook.web.dto.PrayResponseDto;
import weawe.praybook.web.dto.PraySaveRequestDto;
import weawe.praybook.web.dto.PrayUpdateRequestDto;

@RequiredArgsConstructor
@RestController
@Slf4j
public class PrayApiController {

    private final PrayService prayService;

    @PostMapping("/api/pray")
    public Long save(@RequestBody PraySaveRequestDto requestDto) {
        log.info("PrayApiController-save");
        return prayService.save(requestDto);
    }

    @PutMapping("/api/pray/{id}")
    public Long update(@PathVariable Long id, @RequestBody PrayUpdateRequestDto requestDto) {
        log.info("PrayApiController-update");
        return prayService.update(id, requestDto);
    }

    @GetMapping("/api/pray/{id}")
    public PrayResponseDto findById (@PathVariable Long id) {
        log.info("PrayApiController-findById");
        return prayService.findById(id);
    }


    @DeleteMapping("/api/pray/{id}")
    public Long delete(@PathVariable Long id) {
        log.info("PrayApiController-delete");
        prayService.delete(id);
        return id;
    }
}
