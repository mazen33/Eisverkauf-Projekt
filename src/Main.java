import java.awt.*;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static String instructions() {
        return "-------------------------------------------" +
                "\nWe have the following types of ice cream: \n" +
                "1- Ed von Schleck,     priced: 2.50$ \n2- cactus ice cream,    priced: 1.20$" +
                "\n3- Flutschfinger,    priced: 0.90$" +
                "\n4- For removing an existing item" +
                "\n5- For checking out all the items" +
                "\nPlease make your selection: ";
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        IceCream[] iceCreamList = new IceCream[4];

        // Available ice cream flavours
        IceCream EdvonSchleck = new IceCream("Ed von Schleck", new BigDecimal("2.50"));
        IceCream cactusIceCream = new IceCream("cactus ice cream", new BigDecimal("1.20"));
        IceCream Flutschfinger = new IceCream("Flutschfinger", new BigDecimal("0.90"));

        iceCreamList[1] = EdvonSchleck;
        iceCreamList[2] = cactusIceCream;
        iceCreamList[3] = Flutschfinger;

        try {
            Scanner scanner = new Scanner(System.in);
            Colored.cyan("Enter customer's budget: ");
            BigDecimal budget = BigDecimal.valueOf(scanner.nextDouble());
            BigDecimal cuurentBudget = budget;

            Customer customer = new Customer(budget);
            IceCream iceCream1 = new IceCream(EdvonSchleck.getName(),EdvonSchleck.getPrice());
            Cart cart = new Cart(customer);

            clearScreen();

            Colored.yellow("\n\n======== << Welcome >> ========\n");
            while (true) {
                Colored.blue("\n" + instructions());
                int input = (int) (scanner.next().charAt(0) - '0');

                switch (input) {
                    case 1:
                        if (cart.isExceeded(iceCreamList[input]))
                            Colored.red("Warning!! Can't buy that.\n");
                        else {
                            cart.addItem(iceCreamList[input]);
                             BigDecimal currentBudget1 = cuurentBudget.subtract(EdvonSchleck.getPrice());
                            System.out.println("Current Budget: " + currentBudget1);
                            Colored.green("Item was added successfully.\n");

                        }
                        break;

                    case 2:
                        if (cart.isExceeded(iceCreamList[input]))
                            Colored.red("Warning!! Can't buy that.\n");
                        else {
                            cart.addItem(iceCreamList[input]);
                            BigDecimal currentBudget2 = cuurentBudget.subtract(Flutschfinger.getPrice());
                            System.out.println("Current Budget: " + currentBudget2);
                            Colored.green("Item was added successfully.\n");
                        }
                        break;
                    case 3:
                        if (cart.isExceeded(iceCreamList[input]))
                            Colored.red("Warning!! Can't buy that.\n");
                        else {
                            cart.addItem(iceCreamList[input]);
                            BigDecimal currentBudget3 = cuurentBudget.subtract(cactusIceCream.getPrice());
                            System.out.println("Current Budget: " + currentBudget3);
                            Colored.green("Item was added successfully.\n");
                        }
                        break;
                    case 4:
                        Colored.purple("Please enter the number of the item: ");
                        int itemIndex = (int) (scanner.next().charAt(0) - '0');
                        if (cart.isInCart(iceCreamList[itemIndex])) {
                            cart.removeItem(iceCreamList[itemIndex]);
                            Colored.green("Item removed!\n");
                        } else {
                            Colored.red("Item is not in cart!!!\n");
                        }
                        break;
                    case 5:
                        Colored.yellow("================= << Your Bill >> =====================");
                        System.out.println("\nYou ordered: ");

                        for(int i = 1; i <= 3; i++){
                            System.out.println(i + "- " + iceCreamList[i].getName() + " flavour: " +
                                    cart.getItemCount(iceCreamList[i]) + " times.");
                        }

                        BigDecimal total = cart.getTotal();
                        cart.checkout();

                        System.out.println("Total: " + total + ", Change: " + customer.budget);


                        Colored.yellow("=======================================================\n");
                        exitSys();

                        break;
                    default:
                       Colored.bkRed("Invalid option.");
                }
                clearScreen();

            }

        } catch (Exception exc) {
            Colored.bkRed("Invalid input.");
        }

    }

    static void exitSys() {
        Colored.green("Thanks for using our system!");
        System.exit(0);
    }
}
