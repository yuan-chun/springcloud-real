package com.yuanchun.member.api;


import org.springframework.web.bind.annotation.RequestMapping;

public interface IMemberService {

    @RequestMapping("/getMember")//调用远程服务中的具体方法，接口名提供本项目服务 controller 调用
    public String getMember();

}