package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.insightr.gildedrose.Inventory;
import edu.insightr.gildedrose.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConjuredDefs {
    private Inventory inventory;
    private Item[] items;
    private Item vest;
    private Item conjured;
    private Item agedBrie;

    @Given("^I have a new inventory$")
    public void iHaveANewInventory() throws Throwable {
        inventory = new Inventory();
        items = inventory.getItems();
        conjured = items[5];
        agedBrie = items[1];
    }

    @Then("^the quality of the conjured item is (\\d+)$")
    public void theQualityOfTheConjuredItemIs(int conjuredQuality) throws Throwable {
        assertThat(conjured.getQuality(), is(conjuredQuality));
    }

    @When("^I update the inventory$")
    public void iUpdateTheInventory() throws Throwable {
        inventory.updateQuality();
    }



    @Then("^the quality of the aged brie is (\\d+)$")
    public void theQualityOfTheAgedBrieIs(int agedBrieQuality) throws Throwable {
        assertThat(agedBrie.getQuality(), is(agedBrieQuality));
    }

}