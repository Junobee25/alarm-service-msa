package com.hanghae.alarmservice.dto.request;

import com.hanghae.alarmservice.domain.constant.AlarmType;

public record AlarmRequest(
        Long toUserId,
        Long fromUserId,
        Long targetId,
        AlarmType alarmType
) {
}
