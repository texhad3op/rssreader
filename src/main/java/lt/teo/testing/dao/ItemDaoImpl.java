package lt.teo.testing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import lt.teo.testing.model.Item;

@Repository("itemDao")
public class ItemDaoImpl extends AbstractDao<Integer, Item> implements ItemDao {

    public Item findById(int id) {
        return getByKey(id);
    }

    public void saveItem(Item item) {
        persist(item);
    }

    @SuppressWarnings("all")
    public List<Item> loadItemsOfFeed(int feedId) {
        return (List<Item>) getSession().createQuery("select item from Item as item where item.feed.id = :feedId")
                .setParameter("feedId", feedId).setFirstResult(0).setMaxResults(5).list();
    }

}
