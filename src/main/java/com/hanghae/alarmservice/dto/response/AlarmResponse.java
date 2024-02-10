package com.hanghae.alarmservice.dto.response;

import com.hanghae.alarmservice.domain.constant.AlarmType;
import com.hanghae.alarmservice.dto.AlarmDto;

import java.time.LocalDateTime;

public record AlarmResponse(
        Long id,
        Long toUserId,
        Long fromUserId,
        Long targetId,
        AlarmType alarmType,
        String text,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) {
    public static AlarmResponse from(AlarmDto entity) {
        return new AlarmResponse(
                entity.id(),
                entity.toUserId(),
                entity.fromUserId(),
                entity.targetId(),
                entity.alarmType(),
                entity.alarmType().getAlarmType(),
                entity.createdAt(),
                entity.modifiedAt()
        );
    }
}
