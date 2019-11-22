package team.five.amazonreviewutil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.five.amazonreviewutil.service.ReviewAnalyzerService;

@RestController
@RequestMapping("/results")
public class ReviewAnalyzerController {

    @Autowired
    private ReviewAnalyzerService reviewAnalyzerService;

    @GetMapping("/most-active-user-profiles")
    public List<String> getMostActiveUserProfiles() {
        return reviewAnalyzerService.getMostActiveUserProfiles();
    }

    @GetMapping("/most-commented-item-id")
    public List<String> getMostCommentedItemsId() {
        return reviewAnalyzerService.getMostCommentedItemsId();
    }
}
