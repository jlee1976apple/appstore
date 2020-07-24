package guru.storefront.appstore.bootstrap;

import guru.storefront.appstore.model.MobileApp;
import guru.storefront.appstore.service.MobileAppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final MobileAppService service;

    public BootStrapData(MobileAppService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        //test bootstrap...
        MobileApp app1 = new MobileApp();
        MobileApp app2 = new MobileApp();
        MobileApp app3 = new MobileApp();
        MobileApp app4 = new MobileApp();
        MobileApp app5 = new MobileApp();


    }
}
