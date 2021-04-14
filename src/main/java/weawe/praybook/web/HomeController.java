package weawe.praybook.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class HomeController {
    @GetMapping(value = "/")
    public String home() {
        log.info("home controller");
        return "home";
    }
}