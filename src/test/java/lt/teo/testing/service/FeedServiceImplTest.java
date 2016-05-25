package lt.teo.testing.service;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import lt.teo.testing.Utils;
import lt.teo.testing.dao.FeedDao;
import lt.teo.testing.model.Feed;

public class FeedServiceImplTest {

    @Mock
    FeedDao dao;

    @InjectMocks
    FeedServiceImpl feedServiceImpl;

    @Spy
    List<Feed> feeds = new ArrayList<Feed>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        feeds = Utils.getFeedList();
    }

    @Test
    public void findById() {
        Feed feed = feeds.get(0);
        when(dao.findById(anyInt())).thenReturn(feed);
        Assert.assertEquals(feedServiceImpl.findById(feed.getId()), feed);
    }

    @Test(expected = Exception.class)
    public void saveEmployee() throws Exception {
        feedServiceImpl.saveFeed(new Feed());
        verify(dao, atLeastOnce()).saveFeed(new Feed());
    }

    @Test
    public void findAllEmployees() {
        when(dao.findAllFeeds()).thenReturn(feeds);
        Assert.assertEquals(feedServiceImpl.findAllFeeds(), feeds);
    }

}
