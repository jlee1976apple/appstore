package guru.storefront.appstore.converter;

import guru.storefront.appstore.model.Rating;
import guru.storefront.appstore.pojo.RatingPojo;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RatingPojoToModel implements Converter<RatingPojo, Rating> {

    @Synchronized
    @Nullable
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
