package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private List<Payment> paymentList = new ArrayList<>();

    public Payment save(Payment payment) {
        Payment existingPayment = findById(payment.getId());

        if (existingPayment != null) {
            int index = paymentList.indexOf(existingPayment);
            paymentList.set(index, payment);
        } else {
            paymentList.add(payment);
        }

        return payment;
    }

    public Payment findById(String id){
        for (Payment savedPayment : paymentList) {
            if (savedPayment.getId().equals(id)) {
                return savedPayment;
            }
        }
        return null;
    }

    public List<Payment> findAll() {
        return paymentList;
    }
}