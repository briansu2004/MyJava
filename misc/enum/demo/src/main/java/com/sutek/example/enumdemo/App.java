package com.sutek.example.enumdemo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        Provider provider = new Provider();
        provider.setProgramStatus(ProgramStatus.ENROLLED);
        
        ProgramStatus status = provider.getProgramStatus();

        // Now you can check the value of the status
        if (status == ProgramStatus.ENROLLED) {
            System.out.println("The status is ENROLLED");
        } else if (status == ProgramStatus.NOT_ENROLLED) {
            System.out.println("The status is NOT_ENROLLED");
        } else if (status == ProgramStatus.DO_NOT_ENROL) {
            System.out.println("The status is DO_NOT_ENROL");
        } else {
            System.out.println("Unknown status");
        }

    }
}
