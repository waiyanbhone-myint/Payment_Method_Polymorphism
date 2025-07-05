package com.ps.model.processor;

import com.ps.Interfaces.PaymentProcessor;
import com.ps.model.Payment;
//import com.ps.model.Payment;

public class OnlinePaymentProcessor implements PaymentProcessor {

    private String serverUrl;
    private boolean isConnected;

    public OnlinePaymentProcessor(String serverUrl, boolean isConnected) {
        this.serverUrl = "http://secure_payment.com";
        this.isConnected = true;
    }


    @Override
    public void initializePayment(Payment payment) {
        System.out.println("Initializing payment process..");
        System.out.println("Connecting to secure payment server " + serverUrl);
        System.out.println("Establishing encrypted connection..");
        System.out.println("Payment Id " + payment.getPaymentId() + " is ready for online processing.");
    }

    @Override
    public boolean validatePayment(Payment payment) {
        System.out.println("Validating online payment!");

        if(!isConnected){
            System.out.println("Please check internet connection!");
            return false;
        }

        String paymentMethod = payment.getPaymentMethod();

        if(paymentMethod.equals("Credit Card")){
            System.out.println("Credit Card validation: Checking with Bank");
            return true;
        } else if (paymentMethod.equals("Paypal")) {
            System.out.println("Paypal validation: Checking with Paypal");
            return true;
        }else {
            System.out.println("This payment is only for Credit Card and Paypal");
            return false;
        }
    }

    @Override
    public void secondConfirmation(Payment payment) {
        System.out.println("📧 Sending online confirmation...");
        System.out.println("Email confirmation sent to: " + payment.getCustomerName());
        System.out.println("Subject: Payment Confirmation - " + payment.getPaymentId());
        System.out.println("Amount: $" + String.format("%.2f", payment.getFinalAmount()));
        System.out.println("Payment Method: " + payment.getPaymentMethod());
        System.out.println("✅ Email confirmation delivered");
    }

    @Override
    public void logTransaction(Payment payment) {
        System.out.println("💾 Logging to online database...");
        System.out.println("Database: payments_online_db");
        System.out.println("Table: transactions");
        System.out.println("Record created:");
        System.out.println("  - Payment ID: " + payment.getPaymentId());
        System.out.println("  - Customer: " + payment.getCustomerName());
        System.out.println("  - Amount: $" + String.format("%.2f", payment.getAmount()));
        System.out.println("  - Fee: $" + String.format("%.2f", payment.calculateProcessingFee()));
        System.out.println("  - Method: " + payment.getPaymentMethod());
        System.out.println("  - Timestamp: " + java.time.LocalDateTime.now());
        System.out.println("✅ Transaction logged to online database");
    }

    @Override
    public String getProcessorName() {
        return "Online Payment Processor";
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void simulateConnectionLoss() {
        this.isConnected = false;
        System.out.println("Connection lost!");
    }

    public void restoreConnection() {
        this.isConnected = true;
        System.out.println("Connection restored!");
    }
}
