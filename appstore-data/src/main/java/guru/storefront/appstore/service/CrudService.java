package guru.storefront.appstore.service;

import java.util.Set;

public interface CrudService<T,ID> {
    T save(T object);

    T findById (ID Id);

    T find(T object);

    void deleteById(ID Id);

    void delete(T object);
}
