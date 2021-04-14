package weawe.praybook.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import weawe.praybook.service.PrayService;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PrayService prayService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("pray", prayService.findAllDesc());
        return "index";
    }

    @GetMapping("/pray/save")
    public String praySave() {
        return "pray-save";
    }
}