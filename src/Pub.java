import java.util.*;

public class Pub {

    enum Drinks {
        ONE_BEER, ONE_CIDER, A_PROPER_CIDER, GT, BACARDI_SPECIAL
    }

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Choose your drink (ONE_BEER, ONE_CIDER, A_PROPER_CIDER, GT, BACARDI_SPECIAL):");
        Drinks drink = Drinks.valueOf(input.nextLine());

        System.out.println("Are you a student? (true/false)");
        boolean student = input.nextBoolean();

        System.out.println("How many drinks do you want?");
        int amount = input.nextInt();

        System.out.println("And the total is:");
        System.out.println(computeCost(drink, student, amount));
        System.out.println();
        System.out.println();
    }

    public static double computeCost(Drinks drink, boolean student, int amount) {

        double price = 0;
        if (amount > 2 && (drink == Drinks.GT || drink == Drinks.BACARDI_SPECIAL)) {
            System.out.println("Too many strong drinks for you friend, I can give you max 2.");

        } else {

            switch (drink) {
                case ONE_BEER:
                    price = 74;
                    break;
                case ONE_CIDER:
                    price = 103;
                    break;
                case A_PROPER_CIDER:
                    price = 110;
                    break;
                case GT:
                    price = 115;
                    break;
                case BACARDI_SPECIAL:
                    price = 127;
                    break;
                default:
                    System.out.println("No such drink exists");
            }
        }

        if (student && (drink == Drinks.ONE_CIDER || drink == Drinks.ONE_BEER || drink == Drinks.A_PROPER_CIDER)) {
            price = price - price / 10;
        }
        return price * amount;

    }
}