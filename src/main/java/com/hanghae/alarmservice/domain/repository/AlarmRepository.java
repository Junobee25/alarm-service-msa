package com.hanghae.alarmservice.domain.repository;

import com.hanghae.alarmservice.domain.entity.Alarm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {

    Page<Alarm> findAllByFromUserIdIn(List<Long> fromUserId,
                                      Pageable pageable);
}
