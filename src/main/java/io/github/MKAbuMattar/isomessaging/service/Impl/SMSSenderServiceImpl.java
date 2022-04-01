package io.github.MKAbuMattar.isomessaging.service.Impl;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import io.github.MKAbuMattar.isomessaging.config.TwilioConfig;
import io.github.MKAbuMattar.isomessaging.model.SMSRequestModel;
import io.github.MKAbuMattar.isomessaging.service.QuoteService;
import io.github.MKAbuMattar.isomessaging.service.SMSSenderService;
import io.github.MKAbuMattar.isomessaging.util.RegExConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("twilio.com")
public class SMSSenderServiceImpl implements SMSSenderService {

    private static final String TAG = "SMSSenderServiceImpl";
    private static final Logger log = LoggerFactory.getLogger(SMSSenderServiceImpl.class);

    private final TwilioConfig twilioConfig;
    private final QuoteService quoteService;

    public SMSSenderServiceImpl(TwilioConfig twilioConfig, QuoteService quoteService) {
        this.twilioConfig = twilioConfig;
        this.quoteService = quoteService;
    }

    @Override
    public void sendSms(SMSRequestModel smsRequestModel) {
        if (isPhoneNumberValid(smsRequestModel.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequestModel.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTestNumber());
            String message = quoteService.getQuote();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            log.info("{} ::: Send sms {}", TAG, smsRequestModel);
        } else {
            throw new IllegalArgumentException(TAG + "Phone number [" + smsRequestModel.getPhoneNumber() + "] is not a valid number");
        }
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        Pattern pattern = Pattern.compile(RegExConstants.PHONE_NUMBER_RegEx);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
