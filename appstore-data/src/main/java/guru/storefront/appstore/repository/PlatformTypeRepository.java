package guru.storefront.appstore.repository;

import guru.storefront.appstore.model.PlatformType;
import org.springframework.data.repository.CrudRepository;

public interface PlatformTypeRepository extends CrudRepository<PlatformType, Long> {
}