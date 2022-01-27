package com.company.SOLID_Principle.OpenClosedPrinciple;

public class Doctor extends Employee{
    public Doctor(int id, String name, String department, boolean working) {
        super(id, name, department, working);
        System.out.println("Doctor created ");
    }

    @Override
    public void performDuties() {
        prescribeMedicine();
        diagnosePatients();

    }


    private void prescribeMedicine(){
        System.out.println("Prescribe Medicine ...");
    }

    private void diagnosePatients(){
        System.out.println("Diagnosing Patient ...");
    }
}
