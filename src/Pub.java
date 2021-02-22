import java.util.Scanner;

public class Pub {

    enum Drinks {
        ONE_BEER, ONE_CIDER, A_PROPER_CIDER, GT, BACARDI_SPECIAL
    }

    Drinks drink;

    public static void main(String[] args) {

        System.out.println("Total price:");
        System.out.println(computeCost(Drinks.GT, true, 2));
    }

    public static int computeCost(Drinks drink, boolean student, int amount) {

        if (amount > 2 && (drink == Drinks.GT || drink == Drinks.BACARDI_SPECIAL)) {
            System.out.println("Too many drinks, max 2.");
        }

        int price = 0;
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

        if (student && (drink == Drinks.ONE_CIDER || drink == Drinks.ONE_BEER || drink == Drinks.A_PROPER_CIDER)) {
            price = price - price / 10;
        }

        return price * amount;
    }

}
