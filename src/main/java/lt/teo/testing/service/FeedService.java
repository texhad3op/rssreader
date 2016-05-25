package lt.teo.testing.service;

import java.util.List;

import lt.teo.testing.model.Feed;

public interface FeedService {

    Feed findById(int id);

    void saveFeed(Feed feed) throws Exception;

    public List<Feed> findAllFeeds();

    Long loadFeedItemsCount(int feedId);

}
