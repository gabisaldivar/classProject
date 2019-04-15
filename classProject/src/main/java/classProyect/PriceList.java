package classProyect;

import kotlin.Pair;
import java.util.HashMap;
import java.util.Map;

public class PriceList {
    private Map<Integer, Pair<String, Double>> products = new HashMap<>();

    public boolean addProductAndPrice(Integer code, String item, Double price) {
        if ((products.containsKey(code) || item == null || price == null)) return false;
        else {
            products.put(code, new Pair<>(item, price));
            return true;

        }

    }

    public boolean changeProductPrice (Integer code, Double price) {
        if (!products.containsKey(code) || price == null) return false;
        else {
            Pair p = products.get(code);
            products.put(code, new Pair<>((String)p.component1(), price));
            return true;
        }
    }

    public boolean changeProductName (Integer code, String item) {
        if (!products.containsKey(code) || item == null) return false;
        else {
            Pair p = products.get(code);
            products.put(code, new Pair<>(item,(Double)p.component2()));
            return true;
        }
    }

    public boolean deleteProduct(Integer code) {
        if (code == null || !products.containsKey(code)) return false;
        else {
            products.remove(code);
            return true;
        }
    }
    public Double totalCost(Integer code, Integer amount ) {
        if (code == null || amount == null || amount < 0 || !products.containsKey(code)) return 0.0;

        return products.get(code).component2() * amount;
    }



}
