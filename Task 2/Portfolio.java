import java.util.HashMap;

public class Portfolio {
    private HashMap<String, Integer> holdings = new HashMap<>();
    private double balance;

    public Portfolio(double initialBalance) {
        this.balance = initialBalance;
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (balance >= cost) {
            holdings.put(stock.getSymbol(), holdings.getOrDefault(stock.getSymbol(), 0) + quantity);
            balance -= cost;
            System.out.println("Purchased " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        int owned = holdings.getOrDefault(stock.getSymbol(), 0);
        if (owned >= quantity) {
            holdings.put(stock.getSymbol(), owned - quantity);
            balance += stock.getPrice() * quantity;
            System.out.println("Sold " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Not enough shares to sell!");
        }
    }

    public void displayPortfolio(HashMap<String, Stock> market) {
        System.out.println("\n--- Portfolio ---");
        System.out.printf("Balance: $%.2f\n", balance);
        for (String symbol : holdings.keySet()) {
            int quantity = holdings.get(symbol);
            double price = market.get(symbol).getPrice();
            System.out.printf("%s - %d shares (Current Price: $%.2f, Value: $%.2f)\n",
                    symbol, quantity, price, price * quantity);
        }
        System.out.println("------------------\n");
    }
}

