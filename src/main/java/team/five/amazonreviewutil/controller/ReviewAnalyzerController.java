package team.five.amazonreviewutil.controller;

import team.five.amazonreviewutil.service.ReviewAnalyzerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/results")
public class ReviewAnalyzerController {

    @Autowired
    private ReviewAnalyzerService reviewAnalyzerService;
}
