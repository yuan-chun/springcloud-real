package com.yuanchun.springcloud.service.feign;

import com.yuanchun.member.api.IMemberService;
import com.yuanchun.springcloud.service.fallback.MemberFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
@FeignClient(value = "member-service-impl")
public interface MemberFeign1 extends IMemberService {

}
