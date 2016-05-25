package lt.teo.testing.parsers;

import lt.teo.testing.model.Feed;

public interface Parser {
    Feed parse(Feed feed) throws Exception;
}
