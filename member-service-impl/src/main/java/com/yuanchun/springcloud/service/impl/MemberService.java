package com.yuanchun.springcloud.service.impl;

import com.yuanchun.member.api.IMemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberService implements IMemberService {

    @RequestMapping("getMember")
    public String getMember(){
        System.out.println("order call member getMember start !!!!");
        try {
            Thread.sleep(2500);
            System.out.println("thread name"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "this is memberservice return getMember";
    }
}
