package com.company.SOLID_Principle.OpenClosedPrinciple;

public class Nurse extends Employee{
    public Nurse(int id, String name, String department, boolean working) {
        super(id, name, department, working);
        System.out.println("Nurse created ...");
    }

    @Override
    public void performDuties() {
        checkVitalSigns();
        drawBlood();
        cleanPatientArea();
    }


    private void checkVitalSigns(){
        System.out.println("Checking vital signs ...");
    }

    private void drawBlood(){
        System.out.println("Drawing blood ...");
    }

    private void cleanPatientArea(){
        System.out.println("Cleaning Patient Area ...");
    }


}
