package lt.teo.testing;

import java.util.ArrayList;
import java.util.List;

import lt.teo.testing.model.Feed;

public class Utils {

    public static List<Feed> getFeedList() {
        Feed f1 = new Feed();
        f1.setId(1);
        f1.setUrl("http://host1/rss");
        f1.setTitle("Title1");
        f1.setFeedName("FeedName1");

        Feed f2 = new Feed();
        f2.setId(2);
        f2.setUrl("http://host2/rss");
        f2.setTitle("Title2");
        f2.setFeedName("FeedName2");

        List<Feed> feeds = new ArrayList<Feed>();
        feeds.add(f1);
        feeds.add(f2);
        return feeds;
    }
}
