package com.hanghae.alarmservice.external.controller;

import com.hanghae.alarmservice.dto.request.AlarmRequest;
import com.hanghae.alarmservice.external.service.ExternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alarm-service")
public class ExternalController {

    private final ExternalService externalService;

    @PostMapping("/save-alarm")
    public void saveAlarm(@RequestBody AlarmRequest alarmRequest) {
        externalService.saveAlarm(alarmRequest.toUserId(), alarmRequest.fromUserId(), alarmRequest.targetId(), alarmRequest.alarmType());
    }
}
