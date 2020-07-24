package guru.storefront.appstore.converter;

import guru.storefront.appstore.model.PlatformType;
import guru.storefront.appstore.pojo.PlatformTypePojo;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class PlatformTypePojoToModel implements Converter<PlatformTypePojo, PlatformType> {

    @Synchronized
    @Nullable
    @Override
    public PlatformType convert(PlatformTypePojo source) {
        if (source == null){return null;}

        else{
            final PlatformType target = new PlatformType();

            target.setId(source.getId());
            target.setName(source.getName());

            return target;
        }
    }
}
