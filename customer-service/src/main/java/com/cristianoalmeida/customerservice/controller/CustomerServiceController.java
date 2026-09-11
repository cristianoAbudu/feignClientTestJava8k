package com.cristianoalmeida.customerservice.controller;

import com.cristianoalmeida.customerservice.dto.CustomerDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerServiceController {

    private Map<Long,CustomerDTO> database = new HashMap<>();

    public CustomerServiceController(){
        database.put(
            1L,
            new CustomerDTO(
                1L,
                "John Smith",
                "john.smith@email.com"
            )
        );
    }

    @GetMapping("/{id}")
    public CustomerDTO get(
            @PathVariable Long id
    ){
        return database.get(id);
    }
}
