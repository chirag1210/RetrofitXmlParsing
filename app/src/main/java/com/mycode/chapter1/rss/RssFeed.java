package com.mycode.chapter1.rss;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss", strict = false)
public class RssFeed {
	@Element
	public RssChannel channel;
	
	public RssChannel getChannel() {
		return channel;
	}
}
