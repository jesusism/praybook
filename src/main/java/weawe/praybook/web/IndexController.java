package weawe.praybook.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import weawe.praybook.config.auth.dto.SessionUser;
import weawe.praybook.service.PrayService;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PrayService prayService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("prays", prayService.findAllDesc());

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null){
            model.addAttribute("name", user.getName());
        }
        return "index";
    }

    @GetMapping("/user/new")
    public String userNew() {

        return "/user/user-new";
    }

    @GetMapping("/pray/new")
    public String prayNew() {

        return "/pray/pray-new";
    }
}