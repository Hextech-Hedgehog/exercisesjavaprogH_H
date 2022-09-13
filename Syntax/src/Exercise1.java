import java.sql.SQLOutput;
import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Instructor bob = new Instructor("Bob", 43, 3216.54, false, Gender.MALE);
        System.out.println(bob);
        System.out.println(bob.getYearlyGrossSalary());
        System.out.println("Yearly income after taxes: " + bob.yearlyTaxation());
        bob.setAge(23);
        bob.setSalary(2700);
        bob.printSalaryForNPeriod(20);
        processInputInstructor();
    }

    public static void processInputInstructor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Instructor's name");
        String firstName = sc.nextLine();
        System.out.println("Enter Instructor's current age");
        int age = sc.nextInt();
        System.out.println("Enter Instructor's starting age");
        int startingAge = sc.nextInt();
        System.out.println("Enter Instructor's starting gross salary");
        double grossSalary = sc.nextDouble();
        Instructor instructor = new Instructor(firstName, age, grossSalary, false, Gender.OTHER);
        System.out.println(instructor);
    }

}
