package com.isiyi.payment.controller;


import com.isiyi.common.entity.vo.ResultVO;
import com.isiyi.payment.entity.Payment;
import com.isiyi.payment.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xpf
 * @since 2020-08-04
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/findOne/{id}")
    public ResultVO<Payment> findById(@PathVariable("id") Long id){
        Payment payment = paymentService.findById(id);
        System.out.println("serverPort:"+serverPort);
        return new ResultVO().success(payment);
    }


}

