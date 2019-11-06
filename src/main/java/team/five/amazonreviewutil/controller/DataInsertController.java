package team.five.amazonreviewutil.controller;

import java.io.IOException;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.five.amazonreviewutil.service.CsvParserService;

@Component
public class DataInsertController {

    private static final String FILE_NAME = "Reviews.csv";

    @Autowired
    CsvParserService csvParserService;

    @PostConstruct
    public void injectReviewsToDb() throws IOException {
        csvParserService.processInputFile(FILE_NAME);
    }
}
