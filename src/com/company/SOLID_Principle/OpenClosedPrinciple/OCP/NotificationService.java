package com.company.SOLID_Principle.OpenClosedPrinciple.OCP;

public interface NotificationService {

     void sendOTP(String medium);

    void sendTransactionReport(String medium);
}
