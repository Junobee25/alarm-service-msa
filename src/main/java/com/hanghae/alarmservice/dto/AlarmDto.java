package com.hanghae.alarmservice.dto;

import com.hanghae.alarmservice.domain.constant.AlarmType;
import com.hanghae.alarmservice.domain.entity.Alarm;

import java.time.LocalDateTime;

public record AlarmDto(
        Long id,
        Long toUserId,
        Long fromUserId,
        Long targetId,
        AlarmType alarmType,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) {

    public static AlarmDto fromEntity(Alarm entity) {
        return new AlarmDto(
                entity.getId(),
                entity.getToUserId(),
                entity.getFromUserId(),
                entity.getTargetId(),
                entity.getAlarmType(),
                entity.getCreatedAt(),
                entity.getModifiedAt()
        );
    }
}
