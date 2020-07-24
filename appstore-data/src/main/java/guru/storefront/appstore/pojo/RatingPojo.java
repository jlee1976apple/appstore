package guru.storefront.appstore.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RatingPojo {
    private Long id;
    private String username;
    private double rating;

    private String comments;
}
