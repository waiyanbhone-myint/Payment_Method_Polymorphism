package com.ps.Interfaces;

import com.ps.model.Payment;

public interface PaymentProcessor {
    void initializePayment(Payment payment);
    boolean validatePayment(Payment payment);
    void secondConfirmation(Payment payment);
    void logTransaction(Payment payment);
    String getProcessorName();
}
