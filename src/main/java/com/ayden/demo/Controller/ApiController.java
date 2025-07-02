package com.ayden.demo.Controller;

import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.Amount;
import com.adyen.model.checkout.CreateCheckoutSessionRequest;
import com.adyen.model.checkout.CreateCheckoutSessionResponse;
import com.adyen.service.checkout.PaymentsApi;

import com.adyen.service.exception.ApiException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Value("${adyen.merchant-account}")
    private String merchantAccount;

    private final PaymentsApi paymentsApi;

    @Autowired
    public ApiController(PaymentsApi paymentsApi) {
        this.paymentsApi = paymentsApi;
    }

    @PostMapping("/sessions")
    public ResponseEntity<CreateCheckoutSessionResponse>createSession(@RequestHeader String host, HttpServletRequest request) throws Exception {

        Amount amount = new Amount()
                .currency("JPY")
                .value(3500L);

        String orderRef = "demo-payment-" + UUID.randomUUID();

        CreateCheckoutSessionRequest createCheckoutSessionRequest = new CreateCheckoutSessionRequest()
                .amount(amount)
                .merchantAccount(merchantAccount)
                .reference(orderRef)
                .countryCode("JP")
                .returnUrl("http://localhost:8080/11");

        try {
            var response = paymentsApi.sessions(createCheckoutSessionRequest);
            return ResponseEntity.ok().body(response);
        } catch (ApiException | IOException e) {
            System.out.println("Error while creating Adyen session: " + e.getMessage());
            return ResponseEntity.status(500).build();
        }

    }


}

