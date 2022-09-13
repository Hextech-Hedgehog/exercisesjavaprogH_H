package model;

public abstract class Session extends Service {

    private Course course;
    private Company organizer;

    public Session(Course course, String company) {
        this.course = course;
        this.organizer = new Company(company);
    }

    public Course getCourse() {
        return this.course;
    }

    public Company getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Company company) {
        this.organizer = new Company(company);
    }

    public void printInfo() {
        System.out.print("The " + this.getCourse().getName() + " course will start on " + this.getCourse().getStartTime().toString() + ".");
        System.out.println(" It will take place at " + this.getOrganizer().getName() + ".");
        System.out.println(this.getCourse());
    }

    @Override
    public double calculatePrice() {
        double price = 1300.0;
        System.out.println("The price for the " + this.getClass().getSimpleName() + " is " + price);
        return price;
    }

}