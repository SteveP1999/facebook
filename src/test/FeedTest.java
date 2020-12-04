package test;

import org.junit.Test;
import sample.Feed;

import static org.junit.Assert.assertEquals;

public class FeedTest {

    Feed feed = new Feed();
    String str = "lali";

    @Test
    public void addFeed() {
        feed.AddFeed(str);
        assertEquals(feed.getPost().get(0), "lali");
    }
}
