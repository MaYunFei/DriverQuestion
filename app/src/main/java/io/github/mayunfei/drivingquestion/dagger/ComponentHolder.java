package io.github.mayunfei.drivingquestion.dagger;

/**
 * Created by mayunfei on 17-4-1.
 */

public class ComponentHolder {
  private static AppComponent sAppComponent;

  public static void setAppComponent(AppComponent appComponent) {
    sAppComponent = appComponent;
  }

  public static AppComponent getAppComponent() {
    return sAppComponent;
  }
}
