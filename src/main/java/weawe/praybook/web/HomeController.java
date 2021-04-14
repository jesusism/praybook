package weawe.praybook.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import weawe.praybook.web.dto.GroupSaveRequestDto;
import weawe.praybook.web.dto.PraySaveRequestDto;
import weawe.praybook.web.dto.UserSaveRequestDto;

@RequiredArgsConstructor
@Controller
@Slf4j
public class HomeController {

    @GetMapping(value = "/")
    public String home() {
        log.info("home controller");
        return "home";
    }

    @GetMapping(value = "/user/new")
    public String createUser(Model model) {
        model.addAttribute("userSaveRequestDto", new UserSaveRequestDto());
        return "user/createUserForm";
    }

    @GetMapping(value = "/pray/new")
    public String createPray(Model model) {
        model.addAttribute("praySaveRequestDto", new PraySaveRequestDto());
        return "user/createPrayForm";
    }

    @GetMapping(value = "/group/new")
    public String createGroup(Model model) {
        model.addAttribute("groupSaveRequestDto", new GroupSaveRequestDto());
        return "user/createGroupForm";
    }
}