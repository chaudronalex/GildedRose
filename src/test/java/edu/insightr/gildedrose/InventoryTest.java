package edu.insightr.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InventoryTest {
    Item[] itemsTab = new Item[1];

    @Test
    public void updateQuality()
    {
        // SETUP
        Item vest = new Item("+5 Dexterity Vest", 10, 20);
        Item agedBrie = new Item("Aged Brie", 2, 0);
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);

        Item[] items = new Item[1];
        items[0] = vest;
        Inventory inventTest = new Inventory(items);

        // ACTION
        inventTest.updateQuality();

        // TEST DU RESULTAT
        assertEquals(19, inventTest.getItems()[0].getQuality());
    }

    @Test
    public void sellInLessThanZero()
    {
        Item [] itemsTest = new Item[1];
        Item agedBrie = new Item("Aged Brie", 1, 6);
        itemsTest[0] = agedBrie;
        Inventory inventTest = new Inventory(itemsTest);

        agedBrie.setSellIn(0);
        inventTest.updateQuality();

        assertEquals(6, agedBrie.getQuality());
    }

    @Test
    public void datePassedQualityDecreaseTwice() {

        //SETUP
        Item elixir = new Item("Elixir of the Mongoose", 0, 7);
        itemsTab[0] = elixir;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST DU RESULTAT
        assertEquals(5, inventTest.getItems()[0].getQuality());
    }

    @Test
    public void noNegativeQuality(){
        //SETUP
        Item elixir = new Item("Elixir of the Mongoose", 5, 0);
        itemsTab[0] = elixir;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST DU RESULTAT
        assertEquals(0, inventTest.getItems()[0].getQuality());
    }

    @Test
    public void brieQtyIncreaseWhenGetsOld(){
        //SETUP
        Item agedBrie = new Item("Aged Brie", 2, 1);
        itemsTab[0] = agedBrie;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();


        //TEST DU RESULTAT
        assertEquals(2,inventTest.getItems()[0].getQuality());
    }

    @Test
    public void qtyNeverMoreThan50(){
        //SETUP
        Item agedBrie = new Item("Aged Brie", 2, 50);
        itemsTab[0] = agedBrie;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST DU RESULTAT
        assertEquals(50,inventTest.getItems()[0].getQuality());
    }

    @Test
    public void sulfuraNeverGetSoldQtyNeverDecreases(){
        //SETUP
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        itemsTab[0] = sulfuras;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST DU RESULTAT
        assertEquals(80,inventTest.getItems()[0].getQuality());

    }


    @Test //Quality increases by 2 when there are 10 days or less
    public void backstageQualIncreasesby2(){
        //SETUP
        Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        itemsTab[0] = backstage;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST DU RESULTAT
        assertEquals(22,inventTest.getItems()[0].getQuality());
    }


    @Test //Quality increases by 2 when there are 5 days or less
    public void backstageQualIncreasesby3(){
        //SETUP
        Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        itemsTab[0] = backstage;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST DU RESULTAT
        assertEquals(23,inventTest.getItems()[0].getQuality());
    }

    @Test //Quality drops to 0 after the concert
    public void backstageQualDropsTo0 (){
        //SETUP
        Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        itemsTab[0] = backstage;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST DU RESULTAT
        assertEquals(0,inventTest.getItems()[0].getQuality());
    }

    @Test
    public void conjuredQual(){
        //SETUP
        Item conjured = new Item("Conjured Mana Cake", 3, 6);
        itemsTab[0] = conjured;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST DU RESULTAT
        assertEquals(4,inventTest.getItems()[0].getQuality());
    }

    @Test
    public void conjuredQualSellIn0(){
        //SETUP
        Item conjured = new Item("Conjured Mana Cake", 0, 6);
        itemsTab[0] = conjured;
        Inventory inventTest = new Inventory(itemsTab);

        //ACTION
        inventTest.updateQuality();

        //TEST DU RESULTAT
        assertEquals(2,inventTest.getItems()[0].getQuality());

    }

}