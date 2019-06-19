package com.tensquare.friend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient("tensquare-user")
public interface UserClient {

    @RequestMapping(value = "/user/{userid}/{friendid}/{x}")
    void updatefanscountandfollowcount(@PathVariable String userid,
                                              @PathVariable String friendid,
                                              @PathVariable int x);
}
