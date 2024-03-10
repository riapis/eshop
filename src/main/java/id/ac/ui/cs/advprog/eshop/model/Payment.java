package id.ac.ui.cs.advprog.eshop.model;

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

        if (method.equals("VoucherCode") || method.equals("CashOnDelivery")){
            this.method = method;
        }else {
            throw new IllegalArgumentException();
        }

        if(paymentData.isEmpty()){
            throw new IllegalArgumentException();
        }else {
            this.paymentData = paymentData;
        }

        if(order == null){
            throw new IllegalArgumentException();
        }else {
            this.order = order;
        }
    }

}