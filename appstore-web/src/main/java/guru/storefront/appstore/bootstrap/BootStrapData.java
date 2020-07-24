package guru.storefront.appstore.bootstrap;

import guru.storefront.appstore.model.MobileApp;
import guru.storefront.appstore.model.PlatformType;
import guru.storefront.appstore.model.Rating;
import guru.storefront.appstore.service.MobileAppService;
import guru.storefront.appstore.service.PlatformTypeService;
import guru.storefront.appstore.service.RatingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final MobileAppService mobileAppService;
    private final PlatformTypeService platformTypeService;
    private final RatingService ratingService;

    public BootStrapData(MobileAppService mobileAppService, PlatformTypeService platformTypeService,
                         RatingService ratingService) {

        this.mobileAppService = mobileAppService;
        this.platformTypeService = platformTypeService;
        this.ratingService = ratingService;
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
        androidType.setName("Android");

        platformTypeService.save(iosType);
        platformTypeService.save(androidType);

        //instantiate rating objects;
        Rating r1 = new Rating();
        Rating r2 = new Rating();
        Rating r3 = new Rating();
        Rating r4 = new Rating();
        Rating r5 = new Rating();

        r1.setUsername("jon1");
        r1.setComments("Waze App is NOT bad for usage on highway.");
        r1.setRating(4.9);

        r2.setUsername("jon1");
        r2.setComments("Waze App is NOT bad for usage on streets.");
        r2.setRating(4.75);

        r3.setUsername("jon1");
        r3.setComments("Waze App is really bad for usage on side walks.");
        r3.setRating(4.25);

        r4.setUsername("jon1");
        r4.setComments("Waze App is awesome!!!");
        r4.setRating(4.85);

        r5.setUsername("jon1");
        r5.setComments("Waze App is really sucks!!");
        r5.setRating(3.25);

        //initialize all apps.
        app1.setName("Waze App");
        app1.setPlatformType(iosType);
        app1.getRatings().add(r1);
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

        app1.getRatings().add(r1);
        app1.getRatings().add(r2);
        app1.getRatings().add(r3);
        app1.getRatings().add(r4);
        app1.getRatings().add(r5);

        r1.setMobileApp(app1);
        r2.setMobileApp(app1);
        r3.setMobileApp(app1);
        r4.setMobileApp(app1);
        r5.setMobileApp(app1);

        //saving apps into repository....
        MobileApp savedApp = mobileAppService.save(app1);
        mobileAppService.save(app2);
        mobileAppService.save(app3);
        mobileAppService.save(app4);
        mobileAppService.save(app5);
    }
}
