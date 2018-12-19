package com.yuanchun.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yuanchun.order.api.IOrderService;
import com.yuanchun.springcloud.service.feign.MemberFeign;
import com.yuanchun.springcloud.service.feign.MemberFeign1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderService implements IOrderService {

    @Autowired
    private MemberFeign memberFeign;
    @Autowired
    private MemberFeign1 memberFeign1;

    @RequestMapping("/callMemberServiceImpl")
    public String callMember() {
        System.out.println("callMemberServiceImpl thread is "+Thread.currentThread().getName());
        return memberFeign.getMember();
    }

    /**
     * @HystrixCommand
     * 默认开启线程池方式的服务隔离，看不同服务线程
     * 服务降级，正常业务逻辑会走，只是提前响应
     * 开启服务熔断
     * 超出ribbon 的响应时间，走服务降级策略，实际业务也会走
     * 注意幂等设计
     */
    @HystrixCommand(fallbackMethod = "callMemberServiceHystrixfallback")
    @RequestMapping("/callMemberServiceFallback")
    public String callMemberServiceHystrix() {

        System.out.println("callMemberServiceFallback thread is "+Thread.currentThread().getName());
        return memberFeign1.getMember();
    }

    public String callMemberServiceHystrixfallback() {
        return "fallbackMethod 服务器走丢了。。。。。。";
    }


    @RequestMapping("/orberService")
    public String orberService() {
        System.out.println("orberService thread is "+Thread.currentThread().getName());
        return "this is orberService";
    }


}
