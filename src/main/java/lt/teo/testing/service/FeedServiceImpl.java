package lt.teo.testing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.teo.testing.constants.FORMAT;
import lt.teo.testing.dao.FeedDao;
import lt.teo.testing.model.Feed;
import lt.teo.testing.parsers.Parser;
import lt.teo.testing.parsers.ParserFactory;

@Service("feedService")
@Transactional
public class FeedServiceImpl implements FeedService {

    @Autowired
    private FeedDao feedDao;

    public Feed findById(int id) {
        return feedDao.findById(id);
    }

    public void saveFeed(Feed inFeed) throws Exception {
        Feed feed = parseFeed(inFeed);
        feedDao.saveFeed(feed);
    }

    public List<Feed> findAllFeeds() {
        return feedDao.findAllFeeds();
    }

    private Feed parseFeed(Feed feed) throws Exception {
        // we are assuming that in the future not only RSS format can be parsed
        // for this purpose we are using Factory Method design pattern
        Parser parser = new ParserFactory().getParser(FORMAT.RSS);
        Feed parsedFeed = parser.parse(feed);
        return parsedFeed;
    }

    public Long loadFeedItemsCount(int feedId) {
        return feedDao.loadFeedItemsCount(feedId);
    }

}
