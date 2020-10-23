package com.veigar.springcloud.controller;

import com.sun.javafx.collections.ListListenerHelper;
import com.veigar.springcloud.entities.CommonResult;
import com.veigar.springcloud.entities.Payment;
import com.veigar.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author VeigarBaron
 * @date 2020/10/20 18:13
 * @Description *
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("插入");
        if(i>0)
            return new CommonResult(200,"插入成功, serverPort: " + serverPort,i);
        return new CommonResult(300,"插入失败, serverPort: " + serverPort,i);
    }

    @GetMapping(value = "/getPayment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getPayment(id);
        log.info("查询");
        if(payment != null)
            return new CommonResult(200,"查询成功, serverPort: " + serverPort,payment);
        return new CommonResult(300,"查询失败, serverPort: " + serverPort);
    }

    @GetMapping("getDiscoveryClient")
    public Object getDiscoveryClient(){

        List<String> list = discoveryClient.getServices();

        for (String str : list) {
            log.info("###########" + str + " #############");
        }
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance serviceInstance : serviceInstanceList) {
            log.info("###########" + serviceInstance.getHost() + "##" + serviceInstance.getPort() + "##" + serviceInstance.getUri() + "##");
        }

        return this.discoveryClient;
    }
}
