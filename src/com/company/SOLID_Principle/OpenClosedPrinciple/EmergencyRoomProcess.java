package com.company.SOLID_Principle.OpenClosedPrinciple;

public class EmergencyRoomProcess {

    public static void main(String[] args) {
        HospitalManagement ERDirector = new HospitalManagement();
        Employee peggy = new Nurse(1, "Peggy", "Emergency", true);
        ERDirector.callEmployees(peggy);

        System.out.println(" -------------------------------------------------------------------- ");

        Employee susan = new Doctor(1,"Susan Holmes", "Emergency", true);
        ERDirector.callEmployees(susan);

        System.out.println(" -------------------------------------------------------------------- ");

        Employee judith  = new Pilot(1,"Judith Ofosu", "Airport", true);

        ERDirector.callEmployees(judith);
    }
}
