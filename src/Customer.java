import java.math.BigDecimal;

public class Customer {
    BigDecimal budget = new BigDecimal("0.00");

    public Customer(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
