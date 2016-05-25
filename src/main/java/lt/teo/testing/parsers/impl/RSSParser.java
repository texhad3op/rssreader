package lt.teo.testing.parsers.impl;

import java.net.URL;
import java.sql.Timestamp;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import lt.teo.testing.model.Feed;
import lt.teo.testing.model.Item;
import lt.teo.testing.parsers.Parser;

public class RSSParser implements Parser {
    public Feed parse(Feed feed) throws Exception {

        URL url = new URL(feed.getUrl());
        XmlReader reader = null;
        try {
            reader = new XmlReader(url);
            SyndFeed syndFeed = new SyndFeedInput().build(reader);
            syndFeed.getEntries().forEach(e -> {
                SyndEntry entry = (SyndEntry) e;
                Item item = new Item();
                item.setFeed(feed);
                item.setDescription(entry.getDescription().getValue());
                item.setLink(entry.getLink());
                item.setPublished(new Timestamp(entry.getPublishedDate().getTime()));
                item.setTitle(entry.getTitle());
                feed.getItems().add(item);
            });
        } finally {
            if (reader != null)
                reader.close();
        }
        return feed;
    }
}
