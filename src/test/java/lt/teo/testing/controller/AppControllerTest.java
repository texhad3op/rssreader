package lt.teo.testing.controller;

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
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import lt.teo.testing.Utils;
import lt.teo.testing.model.Feed;
import lt.teo.testing.service.FeedService;

public class AppControllerTest {

    @Mock
    FeedService feedService;

    @Mock
    MessageSource message;

    @InjectMocks
    AppController appController;

    @Spy
    List<Feed> feeds = new ArrayList<Feed>();

    @Spy
    ModelMap model;

    @Mock
    BindingResult result;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        feeds = Utils.getFeedList();
    }

    @Test
    public void listEmployees() {
        when(feedService.findAllFeeds()).thenReturn(feeds);
        Assert.assertEquals(appController.listFeeds(model), "feeds");
        Assert.assertEquals(model.get("feeds"), feeds);
        verify(feedService, atLeastOnce()).findAllFeeds();
    }

    @Test
    public void saveFeedWithSuccess() throws Exception {
        when(result.hasErrors()).thenReturn(false);
        feedService.saveFeed(new Feed());
        Assert.assertEquals(appController.saveFeed(feeds.get(0), result, model), "redirect:/feeds");
    }

}
