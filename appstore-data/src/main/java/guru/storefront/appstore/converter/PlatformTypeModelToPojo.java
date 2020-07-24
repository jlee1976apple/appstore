package guru.storefront.appstore.converter;

import guru.storefront.appstore.model.PlatformType;
import guru.storefront.appstore.pojo.PlatformTypePojo;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PlatformTypeModelToPojo implements Converter<PlatformType, PlatformTypePojo> {

    @Synchronized
    @Nullable
    @Override
    public PlatformTypePojo convert(PlatformType source) {
        if (source == null){return null;}

        else{
            final PlatformTypePojo target = new PlatformTypePojo();

            target.setId(source.getId());
            target.setName(source.getName());

            return target;
        }
    }
}
