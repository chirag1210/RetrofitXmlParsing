package com.mycode.chapter1.rss;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.mycode.chapter1.R;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RssServiceDemo extends AppCompatActivity {
	private static final String BASE_URL = "https://thehumanxp.com/";

	private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
			.addConverterFactory(SimpleXmlConverterFactory.create());

	private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
			.setLevel(HttpLoggingInterceptor.Level.BODY);

	private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getData();
	}
	
	public void getData() {
		httpClient.addInterceptor(loggingInterceptor);
		builder.client(httpClient.build());

		Retrofit retrofit = builder.build();

		RssService rssService = retrofit.create(RssService.class);

		Call<RssFeed> callAsync = rssService.getFeed();

		callAsync.enqueue(new Callback<RssFeed>() {
			@Override
			public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {
				if (response.isSuccessful()) {
					RssFeed apiResponse = response.body();
					// API response
					System.out.println("Title--->"+apiResponse.getChannel().getItem().get(0).getTitle());
					System.out.println("Description--->"+apiResponse.getChannel().getItem().get(0).getDescription());
					System.out.println("EnclosureUrl--->"+apiResponse.getChannel().getItem().get(0).getEnclosureUrl());
					System.out.println("Rawvoice--->"+apiResponse.getChannel().getItem().get(0).getRawvoice());
					System.out.println("Author--->"+apiResponse.getChannel().getItem().get(0).getAuthor());
					System.out.println("PubDate()--->"+apiResponse.getChannel().getItem().get(0).getPubDate());
					System.out.println("Duration()--->"+apiResponse.getChannel().getItem().get(0).getDuration());
				} else {
					System.out.println("Request Error :: " + response.errorBody());
				}
			}

			@Override
			public void onFailure(Call<RssFeed> call, Throwable t) {
				if (call.isCanceled()) {
					System.out.println("Call was cancelled forcefully");
				} else {
					System.out.println("Network Error :: " + t.getLocalizedMessage());
				}
			}
		});
	}
}
