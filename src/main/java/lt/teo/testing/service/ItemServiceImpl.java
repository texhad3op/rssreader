package lt.teo.testing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.teo.testing.dao.ItemDao;
import lt.teo.testing.model.Item;

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    public Item findById(int id) {
        return itemDao.findById(id);
    }

    public List<Item> loadItemsOfFeed(int feedId) {
        return itemDao.loadItemsOfFeed(feedId);
    }

}
