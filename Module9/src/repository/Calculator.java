package repository;

@FunctionalInterface
public interface Calculator {
    double performCalculation(int price, double reduction);
}
