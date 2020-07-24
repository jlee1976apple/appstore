package guru.storefront.appstore.controller;

import guru.storefront.appstore.pojo.MobileAppPojo;
import guru.storefront.appstore.service.MobileAppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MobileAppController {
    private final MobileAppService mobileAppService;

    public MobileAppController(MobileAppService mobileAppService) {
        this.mobileAppService = mobileAppService;
    }

    @GetMapping("/app/{id}/view")
    public String showMobileAppView(@PathVariable String id, Model model){
        model.addAttribute("mobileApp",mobileAppService.findPojoById(id));

        return "mobileApps/view";
    }
}
