package team.five.amazonreviewutil.service;

import java.util.List;
import team.five.amazonreviewutil.repositiry.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewAnalyzerService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<String> getMostActiveUserProfiles() {
        return reviewRepository.getMostActiveUserProfiles();
    }

    public List<String> getMostCommentedItemsId() {
        return reviewRepository.getMostCommentedItemsId();
    }
}
