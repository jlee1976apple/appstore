package guru.storefront.appstore.repository;

import guru.storefront.appstore.model.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long> {
}
