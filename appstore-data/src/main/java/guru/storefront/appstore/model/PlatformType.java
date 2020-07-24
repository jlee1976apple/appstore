package guru.storefront.appstore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class PlatformType extends BaseEntity{
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
