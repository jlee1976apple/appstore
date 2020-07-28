package guru.storefront.appstore.controller;

import guru.storefront.appstore.model.PlatformType;
import guru.storefront.appstore.pojo.MobileAppPojo;
import guru.storefront.appstore.pojo.PlatformTypePojo;
import guru.storefront.appstore.service.MobileAppService;
import guru.storefront.appstore.service.PlatformTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MobileAppController {
    private final MobileAppService mobileAppService;
    private final PlatformTypeService platformTypeService;

    public MobileAppController(MobileAppService mobileAppService, PlatformTypeService platformTypeService) {
        this.mobileAppService = mobileAppService;
        this.platformTypeService = platformTypeService;
    }

    @GetMapping("/app/{id}/view")
    public String showMobileAppView(@PathVariable String id, Model model){
        model.addAttribute("mobileApp",mobileAppService.findPojoById(Long.valueOf(id)));

        return "app/view";
    }

    @GetMapping("/app/{id}/edit")
    public String displayAppEditForm(@PathVariable String id, Model model){
        model.addAttribute("mobileApp",mobileAppService.findPojoById(Long.valueOf(id)));
        model.addAttribute("platformTypes", platformTypeService.findAll());

        return "app/form";
    }

    @GetMapping("/app/{id}/uploadImage")
    public String displayImageForm(@PathVariable String id, Model model){
        model.addAttribute("mobileApp", mobileAppService.findPojoById(Long.valueOf(id)));

        return "app/appImageForm";
    }

    @PostMapping("/app/save")
    public String saveAppForm(@ModelAttribute MobileAppPojo pojo, @RequestParam("platformTypeNum") String platformID){
        //retrieve platformType object based on ID submitted from the form, then save the object into pojo...
        PlatformTypePojo platformTypePojo = platformTypeService.findPojoById(Long.valueOf(platformID));
        pojo.setPlatformType(platformTypePojo);

        //save pojo as model, then return back pojo version of model from repository...
        MobileAppPojo target = mobileAppService.saveMobileAppPojo(pojo);

        //redirect the control to view page.
        return "redirect:/app/" + target.getId() + "/view";
    }
}
