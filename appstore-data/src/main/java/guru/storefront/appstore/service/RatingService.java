package guru.storefront.appstore.service;

import guru.storefront.appstore.model.Rating;
import guru.storefront.appstore.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RatingService implements CrudService<Rating, Long> {
    private final RatingRepository repository;

    public RatingService(RatingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Rating save(Rating object) {
        return repository.save(object);
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
    public void deleteById(Long Id) {
        repository.deleteById(Id);
    }

    @Override
    public void delete(Rating object) {
        repository.delete(object);
    }

    public Set<Rating> findAll() {
        Set<Rating> ratings = new HashSet<>();

        repository.findAll().forEach(ratings :: add);
        return ratings;
    }
}
