package com.dmitrenko.leetcode.problems.company;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.Collectors.toUnmodifiableMap;
import static java.util.stream.Collectors.toUnmodifiableSet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SolutionUsTraders {
    public static final String DELIMITER = ",";
    public static final String SECTION_DELIMITER = "#";

    public static Stream<String> calculateValue(List<String> rebalanceDates, List<String> positionData, List<String> stockData) {
        Set<String> rebalanceDays = rebalanceDates.stream()
            .skip(1)
            .map(line -> line.split(DELIMITER))
            .map(line -> line[0])
            .collect(toUnmodifiableSet());
        List<String> etfHeader = Arrays.asList(positionData.get(0).split(DELIMITER));
        String[] stockHeader = stockData.get(0).split(DELIMITER);
        List<String[]> positionArray = positionData.stream()
            .skip(1)
            .map(line -> line.split(DELIMITER))
            .collect(toUnmodifiableList());
        int actualPositionIndex = etfHeader.indexOf("Actual Position");
        int targetPositionIndex = etfHeader.indexOf("Target Position");
        Map<String, Integer> currentPosition = mapToSymbol(positionArray, line -> Integer.parseInt(line[actualPositionIndex]));
        Map<String, Double> targetPosition = reindex(mapToSymbol(positionArray, line -> Double.parseDouble(line[targetPositionIndex])));
        int symbolIndex = Arrays.asList(stockHeader).indexOf(StockPrice.SYMBOL);
        int priceIndex = Arrays.asList(stockHeader).indexOf(StockPrice.CLOSE_PRICE);
        int dateIndex = Arrays.asList(stockHeader).indexOf(StockPrice.DATE);
        NavigableMap<String, Map<String, Double>> stockPrices = stockData.stream()
            .skip(1)
            .map(line -> line.split(DELIMITER))
            .map(line -> new StockPrice(line[symbolIndex], line[priceIndex], line[dateIndex]))
            .collect(Collectors.groupingBy(StockPrice::getDate,
                TreeMap::new,
                toUnmodifiableMap(StockPrice::getSymbol, StockPrice::getPrice)));
        return stockPrices.entrySet()
            .stream()
            .skip(1)
            .filter(entry -> rebalanceDays.contains(entry.getKey()))
            .flatMap(entry -> rebalance(entry.getKey(), targetPosition, currentPosition, entry.getValue()));
    }

    private static <T> Map<String, T> mapToSymbol(List<String[]> positionArray, Function<String[], T> function) {
        return positionArray.stream()
            .collect(toMap(line -> line[0], function));
    }

    /**
     * If the totals of the target position doesn't sum up to 1.00, it needs to be indexed, so the total does add up to 1
     */
    private static Map<String, Double> reindex(Map<String, Double> targetPosition) {
        double total = sum(targetPosition.values());
        if (total == 1.0) return targetPosition;
        Map<String, Double> newPosition = new HashMap<>();
        targetPosition.entrySet()
            .stream()
            .filter(e -> e.getValue() > 0)
            .forEach(k -> newPosition.merge(k.getKey(), total / k.getValue(), Double::sum));
        return newPosition;
    }

    private static Stream<String> rebalance(String rebalanceDate,
                                            Map<String, Double> targetPosition,
                                            Map<String, Integer> currentPosition,
                                            Map<String, Double> prices) {
        Map<String, Double> currentNotionalValues = currentPosition.entrySet().stream()
            .collect(toUnmodifiableMap(
                Entry::getKey,
                entry -> entry.getValue() * prices.get(entry.getKey())
            ));
        double totalNotionalValue = sum(currentNotionalValues.values());
        Map<String, Double> targetNotionalValues = targetPosition.entrySet().stream()
            .collect(toUnmodifiableMap(
                Entry::getKey,
                e -> e.getValue() * totalNotionalValue
            ));
        return targetPosition.keySet().stream()
            .sorted()
            .filter(symbol -> prices.getOrDefault(symbol, 0.0) > 0)
            .map(symbol -> {
                double target = targetNotionalValues.getOrDefault(symbol, 0.0);
                double current = currentNotionalValues.getOrDefault(symbol, 0.0);
                double diff = target - current;
                long amount = Math.round(diff / prices.get(symbol));
                return String.format("%s %s %s %d", rebalanceDate, symbol, amount > 0 ? "BUY" : "SELL", Math.abs(amount));
            });
    }

    private static double sum(Collection<Double> values) {
        return values.stream().mapToDouble(p -> p).sum();
    }

    private static class StockPrice {
        public static final String SYMBOL = "Symbol";
        public static final String CLOSE_PRICE = "Close";
        public static final String DATE = "Date";

        private final String symbol;
        private final double price;
        private final String date;

        private StockPrice(String symbol, String price, String date) {
            this.symbol = symbol;
            this.price = Double.parseDouble(price);
            this.date = date;
        }

        public String getSymbol() {
            return symbol;
        }

        public double getPrice() {
            return price;
        }

        public String getDate() {
            return date;
        }
    }

    public static void main(String[] args) throws IOException {
        var outputPath = System.getenv("OUTPUT_PATH");
        try (var input = new InputStreamReader(System.in);
             var output = outputPath != null
                 ? new FileWriter(outputPath)
                 : new OutputStreamWriter(System.out)) {
            execute(input, output);
        }
    }

    public static void execute(Reader input, Writer output) {
        try (var bufferedReader = new BufferedReader(input);
             var bufferedWriter = new BufferedWriter(output)) {
            List<String> data = Stream.generate(() -> readLine(bufferedReader))
                .takeWhile(Objects::nonNull)
                .map(String::trim)
                .collect(toUnmodifiableList());
            List<String> rebalanceDates = subList(data, "Rebalance Dates");
            List<String> positions = subList(data, "Position");
            List<String> stockData = subList(data, "Prices");
            calculateValue(rebalanceDates, positions, stockData)
                .forEach(str -> write(bufferedWriter, str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> subList(List<String> data, String subListName) {
        int startIndex = IntStream.range(0, data.size())
            .filter(i -> data.get(i).startsWith(SECTION_DELIMITER))
            .filter(i -> data.get(i).toLowerCase().contains(subListName.toLowerCase()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No stock section delimiter found"));
        int endIndex = IntStream.range(startIndex, data.size())
            .skip(1)
            .filter(i -> data.get(i).startsWith(SECTION_DELIMITER))
            .findFirst()
            .orElse(data.size());
        return data.subList(startIndex + 1, endIndex);
    }

    private static String readLine(BufferedReader bufferedReader) {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write(BufferedWriter bufferedWriter, String str) {
        try {
            bufferedWriter.write(str);
            bufferedWriter.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

