package io.github.mayunfei.drivingquestion.dagger;

import dagger.Component;
import io.github.mayunfei.drivingquestion.MainActivity;
import javax.inject.Singleton;

@Component(modules = { AppModule.class }) @Singleton public interface AppComponent {
  void inject(MainActivity mainActivity);
}
