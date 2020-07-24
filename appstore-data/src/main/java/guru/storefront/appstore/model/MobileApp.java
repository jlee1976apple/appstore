package guru.storefront.appstore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="App")
@Getter
@Setter
@NoArgsConstructor
public class MobileApp extends BaseEntity{
    private String name;
    private double cost;

    @ManyToOne
    @JoinColumn(name="platform_type_id")
    private PlatformType platformType;

    @Lob
    private byte[] image;

    private String currentVersion;
    private double totalRatings;
    private double avgRating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mobileApp")
    Set<Rating> ratings = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mobileApp")
    Set<Rating> reviews = new HashSet<>();
}
