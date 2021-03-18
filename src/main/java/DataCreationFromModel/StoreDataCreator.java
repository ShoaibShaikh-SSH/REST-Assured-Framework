package DataCreationFromModel;


import DataModel.StorePojo;
import com.github.javafaker.Faker;

public class StoreDataCreator
{
    public static StorePojo store = new StorePojo();
    public static Faker fake = new Faker();

    public StorePojo NewOrderData()
    {
        store.setId(fake.number().numberBetween(12,999));
        store.setPetID(fake.idNumber().valid());
        store.setQuantity(fake.number().randomDigit());
        store.setShipDate("2021-03-14T12:39:37.622Z");
        store.setStatus("approved");
        store.setComplete(fake.bool().bool());

        return store;
    }
}
