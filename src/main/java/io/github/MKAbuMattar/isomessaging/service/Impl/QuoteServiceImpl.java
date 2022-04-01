package io.github.MKAbuMattar.isomessaging.service.Impl;

import io.github.MKAbuMattar.isomessaging.model.QuoteModel;
import io.github.MKAbuMattar.isomessaging.service.QuoteService;
import io.github.MKAbuMattar.isomessaging.util.ApiConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteServiceImpl implements QuoteService {

    private static final String TAG = "QuoteServiceImpl";
    private static final Logger log = LoggerFactory.getLogger(QuoteServiceImpl.class);

    RestTemplate restTemplate = new RestTemplate();

    QuoteModel quoteModel;

    @Override
    public String getQuote() {
        String quote = "";
        try {
            quoteModel = restTemplate.getForObject(ApiConstants.QUOTE_API_URL, QuoteModel.class);

            if (quoteModel.getContent() != null && quoteModel.getAuthor() != null){
                quote = quoteModel.getContent() + "\n\r-" + quoteModel.getAuthor();
            }

        }  catch (Exception error) {
            error.printStackTrace();
            log.info("{} ::: {}", TAG, error.getMessage());
        }

        return quote;
    }
}
