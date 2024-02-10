package com.hanghae.alarmservice.service;

import com.hanghae.alarmservice.domain.repository.AlarmRepository;
import com.hanghae.alarmservice.dto.AlarmDto;
import com.hanghae.alarmservice.external.client.FollowServiceClient;
import com.hanghae.alarmservice.external.client.UserServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlarmService {

    private final AlarmRepository alarmRepository;
    private final UserServiceClient userServiceClient;
    private final FollowServiceClient followServiceClient;

    public Page<AlarmDto> alarmList(@RequestHeader HttpHeaders headers, Pageable pageable) {
        Optional<Long> fromUserIdOptional = userServiceClient.getFromUserId(headers);

        if (fromUserIdOptional.isPresent()) {
            Long fromUserId = fromUserIdOptional.get();
            return alarmRepository.findAllByFromUserIdIn(followServiceClient.getFollowingUsers(fromUserId), pageable)
                    .map(AlarmDto::fromEntity);
        }
        return Page.empty();
    }
}
