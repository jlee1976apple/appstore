package guru.storefront.appstore.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewPojo {
    private Long id;
    private String username;
    private String review;
}

