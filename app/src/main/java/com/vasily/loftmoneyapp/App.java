package com.vasily.loftmoneyapp;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static final String TAG = "App";
    public static final String PREFERENCES_SESSION = "session";
    public static final String KEY_AUTH_TOKEN = "token";

    private Api api;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");

        HttpLoggingInterceptor.Level level = BuildConfig.DEBUG
                ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE;


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(level);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new AuthInterceptor())
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();


        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://loftschoolandroid.getsandbox.com")
                .baseUrl("http://android.loftschool.com/basic/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        api = retrofit.create(Api.class);
    }

    public Api getApi() {
        return api;
    }

    public void saveAuthToken(String token) {
        getSharedPreferences(PREFERENCES_SESSION, MODE_PRIVATE)
                .edit()
                .putString(KEY_AUTH_TOKEN, token)
                .apply();
    }
    public boolean isLoggedIn() {
        return !TextUtils.isEmpty(getAuthToken());
    }

    public String getAuthToken() {
        return getSharedPreferences(PREFERENCES_SESSION,
                MODE_PRIVATE)
                .getString(KEY_AUTH_TOKEN, "");
    }

    private class AuthInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws
                IOException {
            Request originalRequest = chain.request();
            HttpUrl url = originalRequest.url()
                    .newBuilder()
                    .addQueryParameter("auth-token",
                            getAuthToken()).build();
            return chain.proceed(originalRequest.
                    newBuilder().url(url).build());
        }
    }
}


