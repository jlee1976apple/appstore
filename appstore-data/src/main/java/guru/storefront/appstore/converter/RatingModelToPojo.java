package guru.storefront.appstore.converter;

import guru.storefront.appstore.model.Rating;
import guru.storefront.appstore.pojo.RatingPojo;
import lombok.Getter;
import lombok.Setter;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RatingModelToPojo implements Converter<Rating, RatingPojo> {

    @Synchronized
    @Nullable
    @Override
    public RatingPojo convert(Rating source) {
        if (source == null){
            return null;
        }
        else{
            final RatingPojo target = new RatingPojo();
            target.setId(source.getId());
            target.setUsername(source.getUsername());
            target.setComments(source.getComments());
            target.setRating(source.getRating());

            return target;
        }
    }
}
