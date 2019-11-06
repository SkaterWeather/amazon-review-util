package team.five.amazonreviewutil.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import team.five.amazonreviewutil.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
