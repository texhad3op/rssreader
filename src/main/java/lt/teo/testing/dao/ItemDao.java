package lt.teo.testing.dao;

import java.util.List;

import lt.teo.testing.model.Item;

public interface ItemDao {

    Item findById(int id);

    void saveItem(Item item);

    public List<Item> loadItemsOfFeed(int feedId);

}
