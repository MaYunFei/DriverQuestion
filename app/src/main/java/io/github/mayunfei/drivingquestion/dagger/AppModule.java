package io.github.mayunfei.drivingquestion.dagger;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;
import io.github.mayunfei.drivingquestion.Api;
import io.github.mayunfei.drivingquestion.BuildConfig;
import io.github.mayunfei.drivingquestion.MyAdapterFactory;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module public class AppModule {
  private Context mContext;

  public AppModule(Context mContext) {
    this.mContext = mContext;
  }

  @Provides @Singleton public Api provideApi(Retrofit retrofit) {
    return retrofit.create(Api.class);
  }

  @Provides @Singleton public Context provideContext() {
    return mContext;
  }

  @Provides @Singleton public OkHttpClient provideOkHttp() {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    if (BuildConfig.DEBUG) {
      HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
      loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      //设置 Debug Log 模式
      builder.addInterceptor(loggingInterceptor);
    }
    //设置超时
    builder.connectTimeout(15, TimeUnit.SECONDS);
    builder.readTimeout(20, TimeUnit.SECONDS);
    builder.writeTimeout(20, TimeUnit.SECONDS);
    //错误重连
    builder.retryOnConnectionFailure(true);

    return builder.build();
  }

  @Provides @Singleton public Gson provideGson() {
    return new GsonBuilder().registerTypeAdapterFactory(MyAdapterFactory.create()).create();
  }

  @Provides @Singleton public Retrofit provideRetrofit(OkHttpClient okhttpClient, Gson gson) {
    return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addConverterFactory(ScalarsConverterFactory.create())
        .client(okhttpClient)
        .build();
  }
}
