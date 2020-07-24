package guru.storefront.appstore.converter;

import guru.storefront.appstore.model.Review;
import guru.storefront.appstore.pojo.ReviewPojo;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ReviewModelToPojo implements Converter<Review, ReviewPojo> {

    @Synchronized
    @Nullable
    @Override
    public ReviewPojo convert(Review source) {
        if (source == null){return null;}

        else{
            final ReviewPojo target = new ReviewPojo();
            target.setId(source.getId());
            target.setUsername(source.getUsername());
            target.setReview(source.getReview());

            return target;
        }
    }
}
