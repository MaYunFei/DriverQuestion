package io.github.mayunfei.drivingquestion;

import android.app.Application;
import io.github.mayunfei.drivingquestion.dagger.AppComponent;
import io.github.mayunfei.drivingquestion.dagger.AppModule;
import io.github.mayunfei.drivingquestion.dagger.ComponentHolder;
import io.github.mayunfei.drivingquestion.dagger.DaggerAppComponent;

/**
 * Created by mayunfei on 17-4-1.
 */

public class App extends Application {
  @Override public void onCreate() {
    super.onCreate();

    initDagger();
  }

  private void initDagger() {
    AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    ComponentHolder.setAppComponent(appComponent);
  }
}
