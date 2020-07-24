package guru.storefront.appstore.converter;

import guru.storefront.appstore.model.MobileApp;
import guru.storefront.appstore.pojo.MobileAppPojo;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MobileAppPojoToModel implements Converter<MobileAppPojo, MobileApp> {
    private final PlatformTypePojoToModel platformTypeConverter;
    private final RatingPojoToModel ratingConverter;
    private final ReviewPojoToModel reviewConverter;

    public MobileAppPojoToModel(PlatformTypePojoToModel platformTypeConverter, RatingPojoToModel ratingConverter,
                                ReviewPojoToModel reviewConverter) {

        this.platformTypeConverter = platformTypeConverter;
        this.ratingConverter = ratingConverter;
        this.reviewConverter = reviewConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public MobileApp convert(MobileAppPojo source) {
        if (source == null){return null;}

        else{
            final MobileApp target = new MobileApp();

            target.setId(source.getId());
            target.setName(source.getName());
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
