package guru.storefront.appstore.repository;

import guru.storefront.appstore.model.MobileApp;
import org.springframework.data.repository.CrudRepository;

public interface MobileAppRepository extends CrudRepository<MobileApp,Long> {
}
