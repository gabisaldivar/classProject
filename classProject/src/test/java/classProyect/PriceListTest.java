package classProyect;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PriceListTest {
    @org.junit.jupiter.api.Test
    void addProductAndPrice() {
        PriceList test = new PriceList();
        boolean actual = test.addProductAndPrice(34589, "Картофель сетка 5кг упак",109.00);
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void addProductAndPrice_NullItem() {
        PriceList test = new PriceList();
        boolean actual = test.addProductAndPrice(34589, null, 109.00);
        assertFalse(actual);
    }
    @org.junit.jupiter.api.Test
    void addProductAndPrice_NullPrice() {
        PriceList test = new PriceList();
        boolean actual = test.addProductAndPrice(34589, "Картофель сетка 5кг упак", null);
        assertFalse(actual);
    }

    ///setUp
    @org.junit.jupiter.api.Test
    void changeProductPrice() {
        PriceList test = new PriceList();
        test.addProductAndPrice(34589, "Картофель сетка 5кг упак", 109.00);
        test.addProductAndPrice(76543, "Свинина окорок томленый с томатами", 357.50);
        test.addProductAndPrice(12367, "Томаты черри 250г упак", 89.90);
        boolean actual = test.changeProductPrice(34589, 112.99);
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void changeProductPrice_NullPrice() {
        PriceList test = new PriceList();
        test.addProductAndPrice(34589, "Картофель сетка 5кг упак", 109.00);
        test.addProductAndPrice(76543, "Свинина окорок томленый с томатами", 357.50);
        test.addProductAndPrice(12367, "Томаты черри 250г упак", 89.90);
        boolean actual = test.changeProductPrice(12367, null);
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void changeProductName() {
        PriceList test = new PriceList();
        test.addProductAndPrice(12678, "Соль д/пмм Finish 1,5кг", 194.00);
        test.addProductAndPrice(98758, "Сыр Arla Natura 45% 400г Россия", 340.40);
        test.addProductAndPrice(13478, "Средство чистящее Пемолюкс Лимон 480г", 39.90);
        boolean actual = test.changeProductName(12678, "Пластилин SAFARI детский 10 цв.. 200 г в ");
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void changeProductName_WrongCode() {
        PriceList test = new PriceList();
        test.addProductAndPrice(12678, "Соль д/пмм Finish 1,5кг", 194.00);
        test.addProductAndPrice(98758, "Сыр Arla Natura 45% 400г Россия", 340.40);
        test.addProductAndPrice(13478, "Средство чистящее Пемолюкс Лимон 480г", 39.90);
        boolean actual = test.changeProductName(12389, "Томаты черри 250г упак");
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void deleteProduct() {
        PriceList test = new PriceList();
        test.addProductAndPrice(89765, "Вода минеральная Сенежская н/газ 1.5л ", 17.99);
        test.addProductAndPrice(98182, "Молоко пастер Простоквашино 2,5% ", 54.99);
        test.addProductAndPrice(90765, "Сок Rich яблоко 1л т/п", 89.99);
        boolean actual = test.deleteProduct(90765);
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void deleteProduct_NullCode() {
        PriceList test = new PriceList();
        test.addProductAndPrice(89765, "Вода минеральная Сенежская н/газ 1.5л ", 17.99);
        test.addProductAndPrice(98182, "Молоко пастер Простоквашино 2,5% ", 54.99);
        test.addProductAndPrice(90765, "Сок Rich яблоко 1л т/п", 89.99);
        boolean actual = test.deleteProduct(null);
        assertFalse(actual);
    }
    @org.junit.jupiter.api.Test
    void deleteProduct_WrongCode() {
        PriceList test = new PriceList();
        test.addProductAndPrice(89765, "Вода минеральная Сенежская н/газ 1.5л ", 17.99);
        test.addProductAndPrice(98182, "Молоко пастер Простоквашино 2,5% ", 54.99);
        test.addProductAndPrice(90765, "Сок Rich яблоко 1л т/п", 89.99);
        boolean actual = test.deleteProduct(89769);
        assertFalse(actual);
    }
    @org.junit.jupiter.api.Test
    void totalCost() {
        PriceList test = new PriceList();
        test.addProductAndPrice(44359, "Сыр плавленый Valio Viola с грибами-", 149.00);
        test.addProductAndPrice(71424, "Подгузники Huggies Elite Soft р4 8-14кг 66шт", 1289.00);
        test.addProductAndPrice(24697, "Кофе Nescafe Dolce Gusto американо", 523.90);
        Double actual = test.totalCost(44359, 2);
        assertTrue(actual.compareTo(298.00) == 0 );
    }
    @org.junit.jupiter.api.Test
    void totalCost_NullCode() {
        PriceList test = new PriceList();
        test.addProductAndPrice(44359, "Сыр плавленый Valio Viola с грибами-", 149.00);
        test.addProductAndPrice(71424, "Подгузники Huggies Elite Soft р4 8-14кг 66шт", 1289.00);
        test.addProductAndPrice(24697, "Кофе Nescafe Dolce Gusto американо", 523.90);
        Double actual = test.totalCost(null, 2);
        assertTrue(actual.compareTo(0.0) == 0 );
    }
    @org.junit.jupiter.api.Test
    void totalCost_WrongAmount() {
        PriceList test = new PriceList();
        test.addProductAndPrice(44359, "Сыр плавленый Valio Viola с грибами-", 149.00);
        test.addProductAndPrice(71424, "Подгузники Huggies Elite Soft р4 8-14кг 66шт", 1289.00);
        test.addProductAndPrice(24697, "Кофе Nescafe Dolce Gusto американо", 523.90);
        Double actual = test.totalCost(null, -23);
        assertTrue(actual.compareTo(0.0) == 0 );
    }



}

