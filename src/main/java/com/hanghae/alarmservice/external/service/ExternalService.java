package com.hanghae.alarmservice.external.service;

import com.hanghae.alarmservice.domain.constant.AlarmType;
import com.hanghae.alarmservice.domain.entity.Alarm;
import com.hanghae.alarmservice.domain.repository.AlarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExternalService {

    private final AlarmRepository alarmRepository;

    public void saveAlarm(Long toUser, Long fromUser, Long targetId, AlarmType alarmType) {
        alarmRepository.save(Alarm.of(toUser, fromUser, targetId, alarmType));
    }
}
