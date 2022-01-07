import java.math.BigDecimal;
import java.util.ArrayList;

public class Cart {
    Customer customer;
    ArrayList<IceCream> items = new ArrayList<>();

    Cart(Customer customer) {
        this.customer = customer;
    }

    public void addItem(IceCream item) {
        this.items.add(item);
    }

    public void removeItem(IceCream item) {
        if(this.isInCart(item))
            this.items.remove(item);
    }

    public int getItemCount(IceCream item) {
        int cnt = 0;
        for (int i = 0; i < this.items.size(); i++) {
            if(this.items.get(i).equals(item))
                cnt++;
        }
        return cnt;
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal("0.00");
        for (int i = 0; i < this.items.size(); i++)
            total = total.add(this.items.get(i).getPrice());
        return total;
    }

    public boolean isExceeded(IceCream item) {
        BigDecimal total = new BigDecimal("0.00");
        for (int i = 0; i < this.items.size(); i++)
            total = total.add(this.items.get(i).getPrice());
        BigDecimal res = new BigDecimal("0.00");
        res = res.add(total);
        res = res.add(item.getPrice());

        return res.doubleValue() > this.customer.budget.doubleValue();
    }

    public void checkout() {
        this.customer.budget = this.customer.budget.subtract(this.getTotal());
    }

    boolean isInCart(IceCream item) {
        for (int i = 0; i < items.size(); i++)
            if(items.get(i).equals(item))
                return true;
        return false;
    }

}
