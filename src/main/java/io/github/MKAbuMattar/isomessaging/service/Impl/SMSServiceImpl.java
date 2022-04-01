package io.github.MKAbuMattar.isomessaging.service.Impl;

import io.github.MKAbuMattar.isomessaging.model.SMSRequestModel;
import io.github.MKAbuMattar.isomessaging.service.SMSSenderService;
import io.github.MKAbuMattar.isomessaging.service.SMSService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SMSServiceImpl implements SMSService {

    private final SMSSenderService smsSenderService;

    public SMSServiceImpl(@Qualifier("twilio.com") SMSSenderService smsSenderService) {
        this.smsSenderService = smsSenderService;
    }

    @Override
    public void sendSms(SMSRequestModel smsRequestModel) {
        smsSenderService.sendSms(smsRequestModel);
    }
}
