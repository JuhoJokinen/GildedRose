package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay_Vest() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		assertEquals(19, itemVest.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_VestSellInNegative() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", -1, 20));
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		assertEquals(18, itemVest.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_VestQuality_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 0, 0));
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		assertEquals(0, itemVest.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Brie50Quality() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 0, 50));
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_SulfurasQuality() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemSulf = items.get(0);
		assertEquals(80, itemSulf.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_SulfurasSellIn() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemSulf = items.get(0);
		assertEquals(0, itemSulf.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Passes_SellIn12() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 30));
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(31, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Passes_SellIn8() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 8, 30));
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(32, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Passes_SellIn3() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 30));
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(33, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Passes_SellIn0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30));
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(0, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_SulfurasQuality_40() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 40));
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemSulf = items.get(0);
		assertEquals(80, itemSulf.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Vest1Week() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 5, 20));
				
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
				
		// Assert
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		assertEquals(11, itemVest.getQuality());
	}
}
