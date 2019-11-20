package team.five.amazonreviewutil.repositiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import team.five.amazonreviewutil.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value =
            "SELECT profile_name FROM reviews GROUP BY profile_name ORDER BY COUNT (profile_name) DESC LIMIT 1000;",
            nativeQuery = true)
    List<String> getMostActiveUserProfiles();

    @Query(value =
            "SELECT product_id FROM reviews GROUP BY product_id ORDER BY COUNT (product_id) DESC LIMIT 1000;",
            nativeQuery = true)
    List<String> getMostCommentedItemsId();

    //todo: problem - will return emptyList with profile_name's like - "C. F. Hill ""CFH"""
    //just a test method
    //comments will be removed before merge
    @Query(value =
            "SELECT * FROM reviews WHERE profile_name=:name ;",
            nativeQuery = true)
    List<Review> getReviewsByProfileName(@Param("name") String name);
}
