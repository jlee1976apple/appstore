package guru.storefront.appstore.service;

import guru.storefront.appstore.converter.RatingModelToPojo;
import guru.storefront.appstore.converter.RatingPojoToModel;
import guru.storefront.appstore.model.Rating;
import guru.storefront.appstore.pojo.RatingPojo;
import guru.storefront.appstore.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RatingService implements CrudService<Rating, Long> {
    private final RatingRepository repository;
    private final RatingPojoToModel ratingPojoToModel;
    private final RatingModelToPojo ratingModelToPojo;

    public RatingService(RatingRepository repository, RatingPojoToModel ratingPojoToModel,
                         RatingModelToPojo ratingModelToPojo) {

        this.repository = repository;
        this.ratingPojoToModel = ratingPojoToModel;
        this.ratingModelToPojo = ratingModelToPojo;
    }

    @Override
    public Rating save(Rating object) {
        return repository.save(object);
    }

    public RatingPojo saveRatingPojo (RatingPojo pojo){
        Rating saveRating = ratingPojoToModel.convert(pojo);
        Rating savedRating = repository.save(saveRating);

        return ratingModelToPojo.convert(savedRating);
    }

    @Override
    public Rating findById(Long Id) {
        return repository.findById(Id).get();
    }

    @Override
    public Rating find(Rating object) {
        return findById(object.getId());
    }

    @Override
    public Set<Rating> findAll(){
        Set<Rating> ratings = new HashSet<>();
        repository.findAll().forEach(ratings :: add);
        return ratings;
    }

    @Override
    public void deleteById(Long Id) {
        repository.deleteById(Id);
    }

    @Override
    public void delete(Rating object) {
        repository.delete(object);
    }

}
