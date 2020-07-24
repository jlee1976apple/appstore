package guru.storefront.appstore.converter;

import guru.storefront.appstore.model.MobileApp;
import guru.storefront.appstore.pojo.MobileAppPojo;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MobileAppModelToPojo implements Converter<MobileApp, MobileAppPojo> {

    private final PlatformTypeModelToPojo platformTypeConverter;
    private final RatingModelToPojo ratingConverter;
    private final ReviewModelToPojo reviewConverter;

    public MobileAppModelToPojo(PlatformTypeModelToPojo platformTypeConverter, RatingModelToPojo ratingConverter,
                                ReviewModelToPojo reviewConverter) {

        this.platformTypeConverter = platformTypeConverter;
        this.ratingConverter = ratingConverter;
        this.reviewConverter = reviewConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public MobileAppPojo convert(MobileApp source) {
        if (source == null){return null;}

        else{
            final MobileAppPojo target = new MobileAppPojo();

            target.setId(source.getId());
            target.setName(source.getName());
            target.setDescription(source.getDescription());
            target.setCost(source.getCost());

            //deal with platform type
            target.setPlatformType(platformTypeConverter.convert(source.getPlatformType()));

            //get image
            target.setImage(source.getImage());

            target.setCurrentVersion(source.getCurrentVersion());
            target.setTotalRatings(source.getTotalRatings());
            target.setAvgRating(source.getAvgRating());

            //deal with ratings
            if (source.getRatings() != null && source.getRatings().size() > 0){
                source.getRatings().forEach(rating->{
                    target.getRatings().add(ratingConverter.convert(rating));
                });
            }

            //deal with reviews
            if (source.getReviews() != null && source.getReviews().size() > 0){
                source.getReviews().forEach(review->{
                    target.getReviews().add(reviewConverter.convert(review));
                });
            }

            return target;
        }
    }
}
