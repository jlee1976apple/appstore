package guru.storefront.appstore.bootstrap;

import guru.storefront.appstore.model.MobileApp;
import guru.storefront.appstore.model.PlatformType;
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

        //set platform Types;
        PlatformType iosType = new PlatformType();
        iosType.setName("ios");
        PlatformType androidType = new PlatformType();
        iosType.setName("Android");


        //initialize all apps.
        app1.setName("Waze App");
        app1.setCost(0.00);
        app1.setCurrentVersion("1.0");
        app1.setTotalRatings(100.00);
        app1.setAvgRating(4.5);

        app2.setName("Kakao");
        app2.setCost(0.00);
        app2.setCurrentVersion("1.1");
        app2.setTotalRatings(50.00);
        app2.setAvgRating(4.3);

        app3.setName("Uber");
        app3.setCost(0.00);
        app3.setCurrentVersion("2.0");
        app3.setTotalRatings(200.00);
        app3.setAvgRating(4.0);

        app4.setName("Bank of America");
        app4.setCost(0.00);
        app4.setCurrentVersion("1.0");
        app4.setTotalRatings(240.00);
        app4.setAvgRating(4.49);

        app5.setName("US Bank");
        app5.setCost(0.00);
        app5.setCurrentVersion("2.0");
        app5.setTotalRatings(440.00);
        app5.setAvgRating(4.59);

        //saving apps into repository....
        service.save(app1);
        service.save(app2);
        service.save(app3);
        service.save(app4);
        service.save(app5);

    }
}
