package lt.teo.testing.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lt.teo.testing.model.Feed;
import lt.teo.testing.model.Item;
import lt.teo.testing.service.FeedService;
import lt.teo.testing.service.ItemService;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    FeedService feedService;

    @Autowired
    ItemService itemService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = { "/", "/feeds" }, method = RequestMethod.GET)
    public String listFeeds(ModelMap model) {
        List<Feed> feeds = feedService.findAllFeeds();
        model.addAttribute("feeds", feeds);
        return "feeds";
    }

    @RequestMapping(value = { "/newfeed" }, method = RequestMethod.GET)
    public String newFeeds(ModelMap model) {
        Feed feed = new Feed();
        model.addAttribute("feed", feed);
        return "newfeed";
    }

    @RequestMapping(value = { "/newfeed" }, method = RequestMethod.POST)
    public String saveFeed(@Valid Feed feed, BindingResult result, ModelMap model) {

        if (StringUtils.isBlank(feed.getUrl())) {
            FieldError error = new FieldError("feed", "url",
                    messageSource.getMessage("url.cannotbeempty", new String[] {}, Locale.getDefault()));
            result.addError(error);
        }

        if (StringUtils.isBlank(feed.getFeedName())) {
            FieldError error = new FieldError("feed", "feedName",
                    messageSource.getMessage("title.cannotbeempty", new String[] {}, Locale.getDefault()));
            result.addError(error);
        }

        if (!result.getAllErrors().isEmpty())
            return "newfeed";

        try {
            feed.setLastUpdate(new Timestamp(System.currentTimeMillis()));
            feedService.saveFeed(feed);
        } catch (Exception e) {
            model.addAttribute("errorMessage",
                    messageSource.getMessage("feed.cannotbeparsed", new String[] {}, Locale.getDefault()));
            return "newfeed";
        }
        return "redirect:/feeds";
    }

    @RequestMapping(value = { "/feed-details-{id}" }, method = RequestMethod.GET)
    public String feedDetails(@PathVariable Integer id, ModelMap model) {
        Feed feed = feedService.findById(id);
        List<Item> items = itemService.loadItemsOfFeed(id);
        Long itemsCount = feedService.loadFeedItemsCount(id);
        model.addAttribute("feed", feed);
        model.addAttribute("items", items);
        model.addAttribute("itemsCount", itemsCount);
        return "feeddetails";
    }

}
