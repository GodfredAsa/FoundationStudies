package com.company.SOLID_Principle.OpenClosedPrinciple.OCP;

public class MobileNotificationService implements NotificationService{
    @Override
    public void sendOTP(String medium) {
        // write logic to integrate with mobile
        // use twillio api
    }

    @Override
    public void sendTransactionReport(String medium) {
        // write logic to integrate with mobile
        // use twillio api
    }
}
