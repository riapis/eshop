package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
public class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    Order order;
    List<Payment> payments;
    Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();
        
        paymentData = new HashMap<>();
        this.paymentData.put("voucherCode", "ESHOP1234ABC5678");

        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        this.order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                products, 1708560000L, "Safira Sudrajat");

        payments = new ArrayList<>();

        Payment payment1 = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "VOUCHER_CODE",
                order, paymentData);
        payments.add(payment1);

        Payment payment2 = new Payment("7f9e15bb-4b15-42f4-aebc-c3af385fb078", "VOUCHER_CODE",
                order, paymentData);
        payments.add(payment2);

        Payment payment3 = new Payment("e334ef40-9eff-4da8-9487-8ee697ecbf1e", "VOUCHER_CODE",
                order, paymentData);
        payments.add(payment3);
    }

    @Test
    void testSaveCreate() {
        Payment payment = payments.get(1);
        Payment result = paymentRepository.save(payment);

        Payment findResult = paymentRepository.findById(payment.getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getStatus(), findResult.getStatus());
        assertSame(payment.getOrder(), findResult.getOrder());
        assertSame(payment.getPaymentData(), findResult.getPaymentData());
    }

    @Test
    void TestFindByIdFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payments.get(1).getId(), findResult.getId());
        assertEquals(payments.get(1).getMethod(), findResult.getMethod());
        assertEquals(payments.get(1).getStatus(), findResult.getStatus());
        assertSame(payments.get(1).getPaymentData(), findResult.getPaymentData());
        assertSame(payments.get(1).getOrder(), findResult.getOrder());
    }

    @Test
    void TestFindByIdNotFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById("falseID");
        assertNull(findResult);
    }

    @Test
    void TestFindAll() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        List<Payment> paymentList = paymentRepository.findAll();
        assertEquals(3, paymentList.size());
    }
}