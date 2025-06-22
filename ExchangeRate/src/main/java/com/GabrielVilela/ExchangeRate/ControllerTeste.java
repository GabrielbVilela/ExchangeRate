package com.GabrielVilela.ExchangeRate;

import com.GabrielVilela.ExchangeRate.services.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTeste {
    @Autowired
    private Request request;

    @GetMapping
    public RecordTeste get(){
        return request.setApi("/latest/USD");
    }
}
