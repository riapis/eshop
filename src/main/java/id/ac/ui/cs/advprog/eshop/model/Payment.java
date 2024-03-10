package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
public class Payment {
    private String id;
    private String method;
    private Order order;
    private Map<String, String> paymentData;
    @Setter
    private String status;

    public Payment(String id, String method, Order order, Map<String, String> paymentData){
        this.id = id;
        setStatus("SUCCESS");

        if (!PaymentMethod.contains(method)){
            throw new IllegalArgumentException();
        }
        this.method = method;

        if(paymentData.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.paymentData = paymentData;

        if(order == null){
            throw new IllegalArgumentException();
        }
        this.order = order;
    }

}