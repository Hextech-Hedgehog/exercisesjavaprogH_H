package be.abis.acc.model;

public class AbisEmployee extends Person {

    private double salary;
    private Address home;
    private Role role;

    public AbisEmployee(String firstName, String lastName, int age, int personId, double salary, Address home, String company, Address companyAddress) {
        super(firstName, lastName, age, personId, company, companyAddress);
        this.salary = salary;
        this.home = home;
        this.role = new Instructor();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getHome() {
        return home;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(" Has a montlhy income of " + this.salary + ". Home address: ");
        this.home.printInfo();
    }

    public double getYearlyGrossSalary() {
        return this.salary * 12;
    }

    public double monthlyTaxation() {
        return this.yearlyTaxation() / 12;
    }

    public double yearlyTaxation() {
        double result = 0;
        double[] taxationRate = {0.25, 0.40, 0.45, 0.50};
        int[] limits = {0, 13780, 24480, 42370};
        double yearlySalary = this.getYearlyGrossSalary();

        for(int index = 1; index < limits.length; index++) {
            if (yearlySalary >= limits[index]) {
                result += (limits[index] - limits[index - 1]) * (1 - taxationRate[index - 1]); // 13780 * 0.75
            } else {
                result += (yearlySalary - limits[index - 1]) * (1 - taxationRate[index - 1]);
                break;
            }
        }

        if (yearlySalary > limits[3]) {
            result += (yearlySalary - limits[3]) * (1 - taxationRate[3]);
        }

        return result;
    }

    public void printRoleInfo() {
        this.role.printRoleInfo();
    }
}
