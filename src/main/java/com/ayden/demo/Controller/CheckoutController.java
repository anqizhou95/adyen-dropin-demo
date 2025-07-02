package com.ayden.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CheckoutController {

    private final Logger log = LoggerFactory.getLogger(CheckoutController.class);

    @Value("${adyen.client-key}")
    private String clientKey;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cart")
    public String summary(Model model) {
        model.addAttribute("type", "dropin");
        return "cart";
    }

    @GetMapping("/checkout/dropin")
    public String checkoutDropin(Model model) {
        model.addAttribute("clientKey", clientKey);
        return "dropin";
    }

    @GetMapping("/result/{type}")
    public String result(@PathVariable String type, Model model) {
        model.addAttribute("type", type);
        return "result";
    }

}
