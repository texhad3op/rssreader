package lt.teo.testing.dao;

import java.util.List;

import lt.teo.testing.model.Feed;

public interface FeedDao {

    Feed findById(int id);

    void saveFeed(Feed feed);

    List<Feed> findAllFeeds();

    Long loadFeedItemsCount(int feedId);

}
