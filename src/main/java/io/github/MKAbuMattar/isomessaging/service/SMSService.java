package io.github.MKAbuMattar.isomessaging.service;

import io.github.MKAbuMattar.isomessaging.model.SMSRequestModel;

public interface SMSService {
    public void sendSms(SMSRequestModel smsRequestModel);
}
