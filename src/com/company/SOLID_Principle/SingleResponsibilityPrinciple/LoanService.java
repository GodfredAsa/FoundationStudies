package com.company.SOLID_Principle.SingleResponsibilityPrinciple;

public class LoanService {



    void getLoanInterestInfo(String loanType){
        if(loanType.equals("homeloan")){
            // do some job
        }
        if(loanType.equals("personalLoan")){
            // do some job
        }
        if(loanType.equals("carf")){
            // do some job
        }
    }
}
