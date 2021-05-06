package weawe.praybook.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
@Slf4j
public class HomeController {

    /*
    @GetMapping(value = "/")
    public String home() {
        log.info("home controller");
        return "home";
    }

    @GetMapping(value = "/user/new")
    public String createUser(Model model) {
        model.addAttribute("userSaveRequestDto", new UserSaveRequestDto());
        log.info("HomeController-createUser");
        return "user/createUserForm";
    }

    @GetMapping(value = "/pray/new")
    public String createPray(Model model) {
        model.addAttribute("praySaveRequestDto", new PraySaveRequestDto());
        log.info("HomeController-createPray");
        return "pray/createPrayForm";
    }

    @GetMapping(value = "/group/new")
    public String createGroup(Model model) {
        model.addAttribute("groupSaveRequestDto", new GroupSaveRequestDto());
        log.info("HomeController-createGroup");
        return "group/createGroupForm";
    }
    */
}