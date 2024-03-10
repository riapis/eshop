package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
public class Payment {
    private String id;
    private String method;
    private Order order;
    private Map<String, String> paymentData;
    private String status;

    public Payment(String id, String method, Order order, Map<String, String> paymentData){
        this.id = id;

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

    String status = paymentDataCheck();
    setStatus(status);

    public Payment(String id, String method, Order order, Map<String, String> paymentData, String status){
        this(id, method, order, paymentData);
        this.setStatus(status);
    }

    public void setStatus(String status) {
        if (PaymentStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private String paymentDataCheck() {
        if(this.method.equals(PaymentMethod.VOUCHER_CODE.getValue())) {
            String voucherCode = this.paymentData.get("voucherCode");

            if(voucherCode.length() == 16){
                if(voucherCode.startsWith("ESHOP")){
                    String numericPart = voucherCode.substring(5, 16);
                    if(hasEightNumeric(numericPart)){
                        return PaymentStatus.SUCCESS.getValue();
                    }
                }
            }

            return PaymentStatus.REJECTED.getValue();
        } else {
            String address = this.paymentData.get("address");
            String deliveryFee = this.paymentData.get("deliveryFee");

            if(address.isBlank() || deliveryFee.isBlank()){
                return PaymentStatus.REJECTED.getValue();
            }else{
                return PaymentStatus.SUCCESS.getValue();
            }
        }
    }

    private static boolean hasEightNumeric(String str) {
        int count = 0;
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                count++;
            }
        }
        return count==8;
    }
}