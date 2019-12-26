package com.hp.controller;

import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

//    @GetMapping("/{i}")
//    public User getUser(@PathVariable("i") Long id){
//        //调用user-service方法
//        String str="http:";
//        User user=restTemplate.getForObject("http://localhost:8089/user/"+id,User.class);
//        return user;
//    }


//    @GetMapping("/{i}")
//    public User getUser(@PathVariable("i") Long id){
//        //获取服务列表
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        //列表中取出一个服务实例
//        ServiceInstance serviceInstance = instances.get(0);
//        String str="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
//        User user=restTemplate.getForObject(str,User.class);
//        return user;
//    }

    @GetMapping("/{i}")
    public User getUser(@PathVariable("i") Long id){
        String str="http://user-service/user/"+id;
        User user=restTemplate.getForObject(str,User.class);
        return user;
    }
}
