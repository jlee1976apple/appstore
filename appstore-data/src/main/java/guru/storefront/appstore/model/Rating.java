package guru.storefront.appstore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rating extends BaseEntity{
    private String username;
    private double rating;

    @Lob
    private String comments;

    @ManyToOne
    @JoinColumn(name="app_id")
    private MobileApp mobileApp;
}