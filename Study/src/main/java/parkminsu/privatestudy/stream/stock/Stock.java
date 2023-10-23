package parkminsu.privatestudy.stream.stock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String stockName;
    private LocalDate tradeDate;
    private LocalDateTime tradeTime;
    private double tradePrice;

    public Stock(String stockName, LocalDate tradeDate, LocalDateTime tradeTime, double tradePrice) {
        this.stockName = stockName;
        this.tradeDate = tradeDate;
        this.tradeTime = tradeTime;
        this.tradePrice = tradePrice;
    }

    public String getStockName() {
        return stockName;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public LocalDateTime getTradeTime() {
        return tradeTime;
    }

    public double getTradePrice() {
        return tradePrice;
    }

    public static List<Stock> createStockTrades() {
        List<Stock> stockTrades = new ArrayList<>();
        stockTrades.add(new Stock("AAPL", LocalDate.of(2023, 10, 1), LocalDateTime.of(2023, 10, 1, 9, 30), 150.25));
        stockTrades.add(new Stock("AAPL", LocalDate.of(2023, 10, 2), LocalDateTime.of(2023, 10, 1, 9, 45), 151.50));
        stockTrades.add(new Stock("AAPL1", LocalDate.of(2023, 10, 3), LocalDateTime.of(2023, 10, 1, 10, 0), 149.75));
        stockTrades.add(new Stock("AAPL1", LocalDate.of(2023, 10, 4), LocalDateTime.of(2023, 10, 1, 10, 15), 152.00));
        stockTrades.add(new Stock("AAPL1", LocalDate.of(2023, 10, 5), LocalDateTime.of(2023, 10, 2, 9, 30), 153.25));
        stockTrades.add(new Stock("AAPL2", LocalDate.of(2023, 10, 6), LocalDateTime.of(2023, 10, 2, 9, 45), 154.50));
        stockTrades.add(new Stock("AAPL2", LocalDate.of(2023, 10, 7), LocalDateTime.of(2023, 10, 2, 10, 0), 155.75));
        stockTrades.add(new Stock("AAPL2", LocalDate.of(2023, 10, 8), LocalDateTime.of(2023, 10, 2, 10, 15), 156.00));
        return stockTrades;
    }
}





