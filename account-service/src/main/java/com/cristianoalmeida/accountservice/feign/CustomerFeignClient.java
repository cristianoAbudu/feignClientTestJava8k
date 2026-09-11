package com.cristianoalmeida.accountservice.feign;

import com.cristianoalmeida.accountservice.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", url = "http://localhost:8081/customers/")
public interface CustomerFeignClient {
    @GetMapping("/{id}")
    public CustomerDTO get(@PathVariable("id") Long id);
}
