import java.util.HashMap;
import java.util.Locale;

public class Instructor {

    private final int startAge;
    private int age;
    private double salary;
    private String firstName;
    private boolean isSenior;
    private Domain[] domains;
    private Gender gender;
    /* private static HashMap<Integer, Integer> taxRating = new HashMap<>(){{
        put(25, 0);
        put(40, 13780);
        put(45, 24480);
        put(50, 42370);
    }}; */

    public Instructor(String firstName, int age, double salary, boolean isSenior, Gender gender) {
        this(firstName, age, age, salary, isSenior, gender);
    }

    public Instructor(String firstName, int age, int startAge, double salary, boolean isSenior, Gender gender) {
        this.startAge = startAge;
        this.age = age;
        this.salary = salary;
        this.firstName = firstName;
        this.isSenior = isSenior;
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double salary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public boolean isSenior() {
        return this.isSenior;
    }

    public String toString() {
        String pronoun = this.gender.pronouns[2].substring(0, 1).toUpperCase() + this.gender.pronouns[2].substring(1);
        return this.firstName + " is " + this.age + ". " + pronoun + " gross salary is " + this.salary + ". Senior: " + this.isSenior;
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

    /* method to raise salary on a biyearly period */
    public void raiseSalary(double rate) {
        if (this.startAge < this.age && this.age - this.startAge > 35) {
            this.salary += this.salary * rate;
        }
        this.age += 2;
    }

    public void printSalaryForNPeriod(int period) {
        this.printNetSalary();
        for (int index = 0; index < period / 2; index++) {
            raiseSalary(0.05);
            this.printNetSalary();
        }
    }

    public void printNetSalary() {
        System.out.println(this.getFirstName() + "'s net salary at age " + this.getAge() + " is " + this.monthlyTaxation());
    }

}
