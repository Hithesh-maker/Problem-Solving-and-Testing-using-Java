import java.util.*;

class Sale {
    String category;
    String itemName;
    int amount;

    Sale(String category, String itemName, int amount) {
        this.category = category;
        this.itemName = itemName;
        this.amount = amount;
    }
}

class CategoryData {
    int totalSales = 0;
    String maxItem = "";
    int maxAmount = Integer.MIN_VALUE;

    void addSale(String item, int amount) {
        totalSales += amount;

        if (amount > maxAmount) {
            maxAmount = amount;
            maxItem = item;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // LinkedHashMap keeps categories in first appearance order
        Map<String, CategoryData> categories = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String category = sc.next();
            String itemName = sc.next();
            int amount = sc.nextInt();

            categories.putIfAbsent(category, new CategoryData());

            categories.get(category).addSale(itemName, amount);
        }

        for (Map.Entry<String, CategoryData> entry : categories.entrySet()) {

            String category = entry.getKey();
            CategoryData data = entry.getValue();

            System.out.println(
                    category + " " +
                    data.totalSales + " " +
                    data.maxItem
            );
        }

        sc.close();
    }
}