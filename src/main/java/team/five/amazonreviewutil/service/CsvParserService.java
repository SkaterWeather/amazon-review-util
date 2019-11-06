package team.five.amazonreviewutil.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.five.amazonreviewutil.entity.Review;
import team.five.amazonreviewutil.repositiry.ReviewRepository;

@Service
public class CsvParserService {

    @Autowired
    ReviewRepository reviewRepository;

    private static Logger logger = Logger.getLogger(CsvParserService.class);

    private final int fieldsCount = 10;
    private int itemsRead;
    private final String fieldSeparator = ",";
    Charset charset = StandardCharsets.UTF_8;
    private final char lineBreak = '\n';

    public void processInputFile(String fileName) throws IOException {
        boolean isHeader = true;
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        try (FileInputStream source = new FileInputStream(file);
                FileChannel fileChannel = source.getChannel();) {
            ByteBuffer buffer = ByteBuffer.allocate(300 * 1024 * 1024);
            StringBuilder line = new StringBuilder(1 * 1024);
            char symbol;
            while (fileChannel.read(buffer) > 0) {
                buffer.flip();
                CharBuffer charBuffer = charset.decode(buffer);
                buffer.clear();
                for (int i = 0; i < charBuffer.limit(); i++) {
                    symbol = charBuffer.get();
                    if (symbol != lineBreak) {
                        if (symbol != '\r') {
                            line.append(symbol);
                        }
                    } else {
                        if (isHeader) {
                            isHeader = false;
                        } else {
                            final String[] fields = line.toString()
                                    .split(fieldSeparator, fieldsCount);
                            if (fields.length == fieldsCount) {
                                Review review = new Review();
                                review.setProductId(fields[1]);
                                review.setUserId(fields[2]);
                                review.setProfileName(fields[3]);
                                review.setSummary(fields[8]);
                                review.setTextReview(fields[9]);
                                reviewRepository.save(review);
                                itemsRead++;
                                if (itemsRead % 100000 == 0) {
                                    logger.info("Read number of items: " + itemsRead);
                                }
                            } else {
                                logger.error("Error reading file. Got " + fields.length
                                        + " columns of data. Read line: " + line.toString());
                            }
                        }
                        line.setLength(0);
                    }
                }
            }
        }
        logger.info("Items read from file: " + itemsRead);
    }
}
