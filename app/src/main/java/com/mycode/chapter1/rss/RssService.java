package com.mycode.chapter1.rss;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RssService {
	@GET("feed/podcast/") Call<RssFeed> getFeed();
}
