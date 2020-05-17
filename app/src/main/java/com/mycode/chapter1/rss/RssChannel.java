package com.mycode.chapter1.rss;

import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "channel", strict = false)
public class RssChannel {
  
  @ElementList(inline = true, required = false)
  public List<RssItem> item;
	
	@Element(name = "title", required = false)
  private String title;
  
  public String getTitle() {
    return title;
  }
  
  public List<RssItem> getItem() {
    return item;
  }
}
