package com.hanghae.alarmservice.controller;

import com.hanghae.alarmservice.dto.response.AlarmResponse;
import com.hanghae.alarmservice.dto.response.Response;
import com.hanghae.alarmservice.service.AlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alarm-service")
public class AlarmController {

    private final AlarmService alarmService;

    @GetMapping("/alarm-list")
    public Response<Page<AlarmResponse>> alarm(@RequestHeader HttpHeaders headers, Pageable pageable) {
        return Response.success(alarmService.alarmList(headers, pageable).map(AlarmResponse::from));
    }
}
