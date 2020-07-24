package guru.storefront.appstore.service;

import guru.storefront.appstore.model.MobileApp;
import guru.storefront.appstore.repository.MobileAppRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MobileAppService implements CrudService<MobileApp,Long> {
    private final MobileAppRepository mobileAppRepository;

    public MobileAppService(MobileAppRepository mobileAppRepository) {
        this.mobileAppRepository = mobileAppRepository;
    }

    @Override
    public MobileApp save(MobileApp object) {
        if (object == null){return null;}
        else{
         return mobileAppRepository.save(object);
        }
    }

    @Override
    public MobileApp findById(Long Id) {
        return mobileAppRepository.findById(Id).get();
    }

    @Override
    public MobileApp find(MobileApp object) {
        return findById(object.getId());
    }

    public Set<MobileApp> findAll() {
        Set<MobileApp> apps = new HashSet<>();
        mobileAppRepository.findAll().forEach(apps :: add);

        return apps;
    }

    @Override
    public void deleteById(Long Id) {
        mobileAppRepository.deleteById(Id);
    }

    @Override
    public void delete(MobileApp object) {
        mobileAppRepository.delete(object);
    }
}
