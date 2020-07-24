package guru.storefront.appstore.converter;

import guru.storefront.appstore.model.Review;
import guru.storefront.appstore.pojo.ReviewPojo;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ReviewPojoToModel implements Converter<ReviewPojo, Review> {

    private final ReviewPojoToModel converter;

    public ReviewPojoToModel(ReviewPojoToModel converter) {
        this.converter = converter;
    }

    @Synchronized
    @Nullable
    @Override
    public Review convert(ReviewPojo source) {
        if (source == null){return null;}

        else{
            final Review target = new Review();
            target.setId(source.getId());
            target.setUsername(source.getUsername());
            target.setReview(source.getReview());

            return target;
        }
    }
}
