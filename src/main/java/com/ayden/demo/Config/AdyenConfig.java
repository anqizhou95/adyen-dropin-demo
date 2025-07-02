package com.ayden.demo.Config;

import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.service.checkout.PaymentsApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdyenConfig {

    @Value("${adyen.api-key}")
    private String apiKey;

    @Value("${adyen.environment}")
    private String environment;

    @Bean
    public Client adyenClient() {
        Environment adyenEnvironment = Environment.valueOf(environment.toUpperCase());
        return new Client(apiKey, adyenEnvironment);
    }

    @Bean
    public PaymentsApi paymentsApi(Client client) {
        return new PaymentsApi(client);
    }
}