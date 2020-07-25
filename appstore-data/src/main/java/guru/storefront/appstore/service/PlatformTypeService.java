package guru.storefront.appstore.service;

import guru.storefront.appstore.converter.PlatformTypeModelToPojo;
import guru.storefront.appstore.model.PlatformType;
import guru.storefront.appstore.pojo.PlatformTypePojo;
import guru.storefront.appstore.repository.PlatformTypeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PlatformTypeService implements CrudService<PlatformType, Long> {
    private final PlatformTypeRepository repository;
    private final PlatformTypeModelToPojo modelToPojo;

    public PlatformTypeService(PlatformTypeRepository repository, PlatformTypeModelToPojo modelToPojo) {
        this.repository = repository;
        this.modelToPojo = modelToPojo;
    }

    @Override
    public PlatformType save(PlatformType object) {
        return repository.save(object);
    }

    @Override
    public PlatformType findById(Long Id) {
        return repository.findById(Id).get();
    }

    public PlatformTypePojo findPojoById(Long Id){
        return modelToPojo.convert(findById(Id));
    }

    @Override
    public PlatformType find(PlatformType object) {
        return findById(object.getId());
    }

    @Override
    public Set<PlatformType> findAll() {
        Set<PlatformType> types = new HashSet<>();
        repository.findAll().forEach(types :: add);
        return types;
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
