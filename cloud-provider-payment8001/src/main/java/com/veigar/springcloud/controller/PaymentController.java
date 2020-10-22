package com.veigar.springcloud.controller;

import com.veigar.springcloud.entities.CommonResult;
import com.veigar.springcloud.entities.Payment;
import com.veigar.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


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

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("插入");
        if(i>0)
            return new CommonResult(200,"插入成功",i);
        return new CommonResult(300,"插入失败",i);
    }

    @GetMapping(value = "/getPayment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getPayment(id);
        log.info("查询");
        if(payment != null)
            return new CommonResult(200,"查询成功",payment);
        return new CommonResult(300,"查询失败");
    }
}
