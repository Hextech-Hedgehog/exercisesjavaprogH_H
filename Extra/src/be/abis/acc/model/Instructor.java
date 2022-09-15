package be.abis.acc.model;

public class Instructor implements Role {

    public void teach() {
        System.out.println("Is teaching courses.");
    }

    @Override
    public void printRoleInfo() {
        System.out.println(Role.class.getSimpleName() + ": " + this.getClass().getSimpleName());
    }
}
