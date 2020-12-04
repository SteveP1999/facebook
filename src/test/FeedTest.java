package test;

import org.junit.Test;
import sample.Feed;

import static org.junit.Assert.assertEquals;

public class FeedTest {

    final Feed feed = new Feed();
    final String str = "lali";

    @Test
    public void addFeed() {
        feed.AddFeed(str);
        assertEquals(feed.getPost().get(0), "lali");
    }
}
