package be.abis.acc.model;

public class Manager implements Role {

    public void manage() {
        System.out.println("Is managing courses.");
    }

    @Override
    public void printRoleInfo() {
        System.out.println(Role.class.getSimpleName() + ": " + this.getClass().getSimpleName());
    }
}
