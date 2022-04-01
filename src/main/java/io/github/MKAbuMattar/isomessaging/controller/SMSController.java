package io.github.MKAbuMattar.isomessaging.controller;

import io.github.MKAbuMattar.isomessaging.model.SMSRequestModel;
import io.github.MKAbuMattar.isomessaging.service.SMSService;
import io.github.MKAbuMattar.isomessaging.util.ApiConstants;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiConstants.VERSION_V1)
public class SMSController {
    private final SMSService smsService;

    public SMSController(SMSService smsService) {
        this.smsService = smsService;
    }

    @PostMapping(ApiConstants.SMS)
    public void sendSms(@Valid @RequestBody SMSRequestModel smsRequestModel) {
        smsService.sendSms(smsRequestModel);
    }
}
