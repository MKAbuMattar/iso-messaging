package io.github.MKAbuMattar.isomessaging.service;

import io.github.MKAbuMattar.isomessaging.model.SMSRequestModel;

public interface SMSSenderService {
    public void sendSms(SMSRequestModel smsRequestModel);
}
