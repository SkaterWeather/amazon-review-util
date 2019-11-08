package team.five.amazonreviewutil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String productId;
    private String userId;
    private String profileName;
    private String summary;
    @Column(length = 60000)
    private String textReview;

    public Review(String productId, String userId, String profileName,
                  String summary, String textReview) {
        this.productId = productId;
        this.userId = userId;
        this.profileName = profileName;
        this.summary = summary;
        this.textReview = textReview;
    }
}
