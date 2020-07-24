package guru.storefront.appstore.service;

import guru.storefront.appstore.model.PlatformType;
import guru.storefront.appstore.repository.PlatformTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PlatformTypeService implements CrudService<PlatformType, Long> {
    private final PlatformTypeRepository repository;

    public PlatformTypeService(PlatformTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public PlatformType save(PlatformType object) {
        return repository.save(object);
    }

    @Override
    public PlatformType findById(Long Id) {
        return repository.findById(Id).get();
    }

    @Override
    public PlatformType find(PlatformType object) {
        return findById(object.getId());
    }

    @Override
    public void deleteById(Long Id) {
        repository.deleteById(Id);
    }

    @Override
    public void delete(PlatformType object) {
        repository.delete(object);
    }
}
