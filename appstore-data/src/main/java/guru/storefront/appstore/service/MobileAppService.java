package guru.storefront.appstore.service;

import guru.storefront.appstore.converter.MobileAppModelToPojo;
import guru.storefront.appstore.converter.MobileAppPojoToModel;
import guru.storefront.appstore.model.MobileApp;
import guru.storefront.appstore.pojo.MobileAppPojo;
import guru.storefront.appstore.repository.MobileAppRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class MobileAppService implements CrudService<MobileApp,Long> {
    private final MobileAppRepository mobileAppRepository;
    private final MobileAppModelToPojo mobileAppModelToPojo;
    private final MobileAppPojoToModel mobileAppPojoToModel;

    public MobileAppService(MobileAppRepository mobileAppRepository, MobileAppModelToPojo mobileAppModelToPojo,
                            MobileAppPojoToModel mobileAppPojoToModel) {

        this.mobileAppRepository = mobileAppRepository;
        this.mobileAppModelToPojo = mobileAppModelToPojo;
        this.mobileAppPojoToModel = mobileAppPojoToModel;
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

    public MobileAppPojo findPojoById(Long Id){
        return mobileAppModelToPojo.convert(findById(Id));
    }

    @Override
    public MobileApp find(MobileApp object) {
        return findById(object.getId());
    }

    @Override
    public Set<MobileApp> findAll(){
        Set<MobileApp> apps = new HashSet<>();
        mobileAppRepository.findAll().forEach(apps :: add);
        return apps;
    }

    //return POJO version of Mobile App model
    public MobileAppPojo findMobileAppPojoById(Long Id){
        return mobileAppModelToPojo.convert(findById(Id));
    }

    @Override
    public void deleteById(Long Id) {
        mobileAppRepository.deleteById(Id);
    }

    @Override
    public void delete(MobileApp object) {
        mobileAppRepository.delete(object);
    }

    @Transactional
    public MobileAppPojo saveMobileAppPojo (MobileAppPojo pojo){
        MobileApp model = mobileAppPojoToModel.convert(pojo);
        MobileApp savedModel = mobileAppRepository.save(model);

        return mobileAppModelToPojo.convert(savedModel);
    }
}