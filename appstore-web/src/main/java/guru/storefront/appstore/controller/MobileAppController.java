package guru.storefront.appstore.controller;

import guru.storefront.appstore.converter.MobileAppModelToPojo;
import guru.storefront.appstore.model.PlatformType;
import guru.storefront.appstore.pojo.MobileAppPojo;
import guru.storefront.appstore.pojo.PlatformTypePojo;
import guru.storefront.appstore.service.MobileAppService;
import guru.storefront.appstore.service.PlatformTypeService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

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

    @PostMapping("/app/{id}/saveImage")
    public String saveAppImage(@RequestParam("image") MultipartFile appImage, @PathVariable String id){
        try{
            Byte[] image = new Byte[appImage.getBytes().length];
            int i=0;

            for (byte b: appImage.getBytes()){
                image[i++] = b;
            }

            mobileAppService.saveImage(image, Long.valueOf(id));
        }
        catch (IOException e){
            System.out.println("ERROR: file cannot be saved.");
            e.printStackTrace();
        }

        return "redirect:/app/" + id + "/view";
    }

    @GetMapping("/app/{id}/renderImageFromDB")
    public void renderImage(@PathVariable String id, HttpServletResponse response) throws IOException{
        MobileAppPojo pojo = mobileAppService.findPojoById(Long.valueOf(id));
        int i=0;
        byte[] imageArr = new byte[pojo.getImage().length];

        for(byte b: pojo.getImage()){
            imageArr[i++] = b;
        }

        response.setContentType("image/png");
        InputStream is = new ByteArrayInputStream(imageArr);
        IOUtils.copy(is, response.getOutputStream());
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
