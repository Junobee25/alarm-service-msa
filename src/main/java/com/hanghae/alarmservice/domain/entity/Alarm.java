package com.hanghae.alarmservice.domain.entity;

import com.hanghae.alarmservice.domain.constant.AlarmType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Alarm extends AuditingField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long toUserId;

    private Long fromUserId;

    private Long targetId;

    @Enumerated(EnumType.STRING)
    private AlarmType alarmType;

    public static Alarm of(Long toUserId, Long fromUserId, Long targetId, AlarmType alarmType) {
        Alarm entity = new Alarm();
        entity.setToUserId(toUserId);
        entity.setFromUserId(fromUserId);
        entity.setTargetId(targetId);
        entity.setAlarmType(alarmType);
        return entity;
    }
}
