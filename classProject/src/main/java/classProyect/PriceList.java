package classProyect;

import kotlin.Pair;

import java.util.*;

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

    public Double totalCost(Map<Integer, Integer> productsMap) {
        double total = 0;
         for(Integer productsMapKey : productsMap.keySet()) {
             if (products.keySet().contains(productsMapKey)) {
                 total += products.get(productsMapKey).component2() *  productsMap.get(productsMapKey);
             }
         }
             return total;
         }}



