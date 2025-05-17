import java.util.*;

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Simulated market data
        HashMap<String, Stock> market = new HashMap<>();
        market.put("AAPL", new Stock("AAPL", "Apple Inc.", 150.0));
        market.put("GOOGL", new Stock("GOOGL", "Alphabet Inc.", 2800.0));
        market.put("TSLA", new Stock("TSLA", "Tesla Inc.", 700.0));

        // Create user portfolio
        Portfolio portfolio = new Portfolio(10000.0);

        int choice;
        do {
            System.out.println("\n=== Stock Trading Platform ===");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stocks");
            System.out.println("3. Sell Stocks");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Market Data ---");
                    for (Stock stock : market.values()) {
                        System.out.printf("%s (%s): $%.2f\n", stock.getName(), stock.getSymbol(), stock.getPrice());
                    }
                    break;

                case 2:
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = sc.next().toUpperCase();
                    if (market.containsKey(buySymbol)) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        portfolio.buyStock(market.get(buySymbol), qty);
                    } else {
                        System.out.println("Invalid stock symbol!");
                    }
                    break;

                case 3:
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = sc.next().toUpperCase();
                    if (market.containsKey(sellSymbol)) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        portfolio.sellStock(market.get(sellSymbol), qty);
                    } else {
                        System.out.println("Invalid stock symbol!");
                    }
                    break;

                case 4:
                    portfolio.displayPortfolio(market);
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}
