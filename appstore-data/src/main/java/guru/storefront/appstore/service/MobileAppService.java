package guru.storefront.appstore.service;

import guru.storefront.appstore.model.MobileApp;
import guru.storefront.appstore.repository.MobileAppRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MobileAppService implements CrudService<MobileApp,Long> {
    private final MobileAppRepository repository;

    public MobileAppService(MobileAppRepository repository) {
        this.repository = repository;
    }

    @Override
    public MobileApp save(MobileApp object) {
        return repository.save(object);
    }

    @Override
    public MobileApp findById(Long Id) {
        return repository.findById(Id).get();
    }

    @Override
    public MobileApp find(MobileApp object) {
        return findById(object.getId());
    }

    @Override
    public Set<MobileApp> findAll() {
        Set<MobileApp> apps = new HashSet<>();
        repository.findAll().forEach(apps :: add);

        return apps;
    }

    @Override
    public void deleteById(Long Id) {
        repository.deleteById(Id);
    }

    @Override
    public void delete(MobileApp object) {
        repository.delete(object);
    }

}
