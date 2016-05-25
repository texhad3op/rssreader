package lt.teo.testing.service;

import java.util.List;

import lt.teo.testing.model.Item;

public interface ItemService {

    Item findById(int id);

    public List<Item> loadItemsOfFeed(int feedId);

}
