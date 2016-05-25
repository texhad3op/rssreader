package lt.teo.testing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import lt.teo.testing.model.Feed;

@Repository("feedDao")
public class FeedDaoImpl extends AbstractDao<Integer, Feed> implements FeedDao {

    public Feed findById(int id) {
        return getByKey(id);
    }

    public void saveFeed(Feed feed) {
        persist(feed);
    }

    @SuppressWarnings("all")
    public List<Feed> findAllFeeds() {
        return getSession().createQuery("select feed from Feed as feed order by feed.lastUpdate desc").list();
    }

    public Long loadFeedItemsCount(int feedId) {
        return (Long) getSession().createQuery("select count(item) from Item as item where item.feed.id = :feedId")
                .setParameter("feedId", feedId).uniqueResult();
    }

}
