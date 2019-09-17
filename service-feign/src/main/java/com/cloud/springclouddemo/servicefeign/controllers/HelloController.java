package com.cloud.springclouddemo.servicefeign.controllers;

import com.cloud.springclouddemo.servicefeign.interfaces.ServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>服务消费控制层</p>
 * @author hanchao 2018/5/19 15:59
 **/
@RestController
public class HelloController {
    /** 注入服务"service-hi"的Feign客户端ServiceHi */
    @Autowired
    private ServiceHi serviceHi;

    /**
     * 调用Feign客户端提供的服务，自带负载均衡
     * @param name
     * @return
     */
    @GetMapping("/hello/{name}")
    public String sayHi(@PathVariable String name){
        //调用Feign客户端ScheduleServiceHi的接口
        return serviceHi.sayHiFromServiceHi(name);
    }
    @GetMapping("/hello1/{name}")
    public String sayHi1(@PathVariable String name){
        //调用Feign客户端ScheduleServiceHi的接口
        return "hi " + name + ",I am from port :8765" ;
    }
}