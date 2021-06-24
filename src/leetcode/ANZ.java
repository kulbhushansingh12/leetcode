package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ANZ {
    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        // Write your code here
        Map<String, Float> expectedPriceMap = new HashMap <>();

        for (int i=0; i<products.size(); i++) {
            expectedPriceMap.put(products.get(i), productPrices.get(i));
        }

        int errorCount = 0;
        for (int i=0; i<productSold.size(); i++) {
            if (expectedPriceMap.get(productSold.get(i))!= soldPrice.get(i)) {
                ++errorCount;
            }
        }
        return errorCount;
    }

    public static void main(String[] args) {
        System.out.println(priceCheck(List.of("chocolate", "cheese", "tomato"), List.of(15F, 300.90F, 23.44F), List.of("cheese", "tomato", "chocolate"),
                List.of(300.90F, 23.44F, 10F)));
    }
}
