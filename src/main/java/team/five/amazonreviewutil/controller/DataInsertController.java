package team.five.amazonreviewutil.controller;

import javax.annotation.PostConstruct;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.five.amazonreviewutil.service.ServiceParsing;

@Component
public class DataInsertController {

    private static final String DATA_FILE_NAME = "D:\\My\\MA\\project\\Reviews.csv";

    @Autowired
    ServiceParsing serviceParsing;

    @PostConstruct
    public void injectReviewsToDb() throws IOException {
        serviceParsing.processInputFile(DATA_FILE_NAME);
    }
}
