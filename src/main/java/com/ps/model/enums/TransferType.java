package com.ps.model.enums;

public enum TransferType {
    ACH(1.50, 3, "ACH Transfer"),
    WIRE(25.00, 1, "Wire Transfer"),
    SAME_DAY(5.00, 0, "Same-Day ACH");

    private final double fee;
    private final int processingDays;
    private final String displayName;

    TransferType(double fee, int processingDays, String displayName){
        this.fee = fee;
        this.processingDays = processingDays;
        this.displayName = displayName;
    }

    public double getFee(){
        return fee;
    }

    public int getProcessingDays(){
        return processingDays;
    }

    public String getDisplayName(){
        return displayName;
    }
}
