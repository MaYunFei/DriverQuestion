package io.github.mayunfei.drivingquestion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import io.github.mayunfei.drivingquestion.bean.Question;
import io.github.mayunfei.drivingquestion.dagger.ComponentHolder;
import javax.inject.Inject;

import static io.github.mayunfei.drivingquestion.Constants.API_KEY;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";
  @Inject Api api;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ComponentHolder.getAppComponent().inject(this);
    setContentView(R.layout.activity_main);
    api.query(1, "c1", "order", API_KEY).subscribe(s -> {

      for (Question question : s.getResult()) {
        Log.i(TAG, question.toString());
      }
    }, throwable -> {
      Log.e(TAG, throwable.toString());
    });
  }
}
