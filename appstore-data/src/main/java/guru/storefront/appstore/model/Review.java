package guru.storefront.appstore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review extends BaseEntity{
    private String username;

    @Lob
    private String review;

    @ManyToOne
    @JoinColumn(name="app_id")
    private MobileApp mobileApp;
}
