package com.hanghae.alarmservice.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="follow-service")
public interface FollowServiceClient {

    @GetMapping("/follow-service/find-following-user")
    List<Long> getFollowingUsers(@RequestParam(value = "fromUserId", required = false) Long fromUserId);
}

