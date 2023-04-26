package com.server.dto;

import com.server.service.VnPayService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/vnpay")
public class VnPayController {

    @Autowired private VnPayService vnPayService;

    @PostMapping
    public String vnpay(HttpServletRequest request, HttpServletResponse response, @Param("orderId") String orderId,
                        @Param("transDate") String transDate) throws IOException {
        return vnPayService.queryTransaction(request ,orderId, transDate);
    }
}
