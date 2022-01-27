package com.company.SOLID_Principle.SingleResponsibilityPrinciple;

public class NotificationService {

     public void sendOTP(String medium){
        if(medium.equals("email")){
            // write email related logic
            // useJavaMailSenderAPI
        }

        if(medium.equals("mobile")){
            // write mobile related logic
            // twillio API
        }
    }
}
