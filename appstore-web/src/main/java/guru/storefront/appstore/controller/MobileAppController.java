package guru.storefront.appstore.controller;

import guru.storefront.appstore.service.MobileAppService;
import org.springframework.stereotype.Controller;

@Controller
public class MobileAppController {
    private final MobileAppService service;

    public MobileAppController(MobileAppService service) {
        this.service = service;
    }
}
