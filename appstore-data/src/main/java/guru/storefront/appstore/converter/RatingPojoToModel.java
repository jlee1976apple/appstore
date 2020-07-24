package guru.storefront.appstore.converter;

import guru.storefront.appstore.model.Rating;
import guru.storefront.appstore.pojo.RatingPojo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RatingPojoToModel implements Converter<RatingPojo, Rating> {

    private final MobileAppPojoToModel converter;

    public RatingPojoToModel(MobileAppPojoToModel converter) {
        this.converter = converter;
    }

    @Override
    public Rating convert(RatingPojo source) {
        if (source == null){
            return null;
        }
        else{
            final Rating target = new Rating();
            target.setId(source.getId());
            target.setUsername(source.getUsername());
            target.setComments(source.getComments());
            target.setRating(source.getRating());

            return target;
        }
    }
}
