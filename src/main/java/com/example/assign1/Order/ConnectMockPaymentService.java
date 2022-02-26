package com.example.assign1.Order;

import com.example.assign1.MockAPI.MockPaymentResPonse;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Setter
public class ConnectMockPaymentService {

    public Boolean getIsPaidFromMockAPI(Long orderId) {
        String url = "http://localhost:8080/mockup/paypal/" + orderId;
        RestTemplate restTemplate = new RestTemplate();
        MockPaymentResPonse result = restTemplate.getForObject(url, MockPaymentResPonse.class);
        if (result.getIsPaid())
            return true;

        return false;

    }

}
