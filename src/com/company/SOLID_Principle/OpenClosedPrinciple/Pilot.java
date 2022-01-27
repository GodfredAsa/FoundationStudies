package com.company.SOLID_Principle.OpenClosedPrinciple;

public class Pilot extends Employee {
    public Pilot(int id, String name, String department, boolean working) {
        super(id, name, department, working);
    }

    @Override
    public void performDuties() {
        drive();
    }


    private void drive(){
        System.out.println("drives a plan");
    }



}
