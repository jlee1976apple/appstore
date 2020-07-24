package guru.storefront.appstore.controller;

import guru.storefront.appstore.service.MobileAppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final MobileAppService mobileAppService;

    public IndexController(MobileAppService mobileAppService) {
        this.mobileAppService = mobileAppService;
    }

    @GetMapping("/")
    public String displayMobileApps(Model model){
        model.addAttribute("apps",mobileAppService.findAll());

        return "index";
    }
}
