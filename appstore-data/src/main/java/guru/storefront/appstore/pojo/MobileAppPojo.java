package guru.storefront.appstore.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class MobileAppPojo {
    private Long id;
    private String name;
    private double cost;

    private PlatformTypePojo platformType;

    private Byte[] image;
    private String currentVersion;
    private double totalRatings;
    private double avgRating;

    Set<RatingPojo> ratings = new HashSet<>();
    Set<ReviewPojo> reviews = new HashSet<>();

}
