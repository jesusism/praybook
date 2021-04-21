package weawe.praybook.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {

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