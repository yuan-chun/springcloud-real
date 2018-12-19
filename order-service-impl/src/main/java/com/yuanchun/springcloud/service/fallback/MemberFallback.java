package com.yuanchun.springcloud.service.fallback;

import com.yuanchun.springcloud.service.feign.MemberFeign;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MemberFallback implements MemberFeign {
    @Override
    public String getMember() {
        return "callMemberImpl 服务器走丢了。。。。。。";
    }
}
