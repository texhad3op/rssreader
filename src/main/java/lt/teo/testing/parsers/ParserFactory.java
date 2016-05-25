package lt.teo.testing.parsers;

import lt.teo.testing.constants.FORMAT;
import lt.teo.testing.parsers.impl.RSSParser;

public class ParserFactory {
    public Parser getParser(FORMAT format) {
        switch (format) {
        case RSS:
            return new RSSParser();
        case OTHER:
            throw new RuntimeException("Parser for format " + format.name() + " is not implemented yet.");
        default:
            throw new RuntimeException("Parser for format " + format.name() + " is not implemented yet.");
        }

    }
}
