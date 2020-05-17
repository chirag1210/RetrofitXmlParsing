package com.mycode.chapter1.rss;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "item", strict = false)
public class RssItem 
{
	@Path("itunes:summary")
	@Text(required=false)
	private String description;
	
	@Path("itunes:author")
	@Text(required=false)
	private String author;
	
	@Path("itunes:duration")
	@Text(required=false)
	private String duration;
	
	
	@Path("title")
	@Text(required=false)
	private String title = "";
	
	@Path("pubDate")
	@Text(required=false)
	private String pubDate = "";
	
	@Path("enclosure")
	@Attribute(name = "url", required = false)
	public String enclosureUrl = "";
	
	@Path("rawvoice:poster")
	@Attribute(name = "url", required = false)
	public String rawvoice = "";
	
	public String getDescription() {
		return description;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getEnclosureUrl() {
		return enclosureUrl;
	}
	
	public String getRawvoice() {
		return rawvoice;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getPubDate() {
		return pubDate;
	}
	
	public String getDuration() {
		return duration;
	}
}
