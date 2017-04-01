package io.github.mayunfei.drivingquestion.bean;

import android.support.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue public abstract class Question {

  @Nullable @SerializedName("item1") public abstract String item1();

  @Nullable @SerializedName("item2") public abstract String item2();

  @Nullable @SerializedName("item3") public abstract String item3();

  @Nullable @SerializedName("item4") public abstract String item4();

  @SerializedName("question") public abstract String question();

  @SerializedName("answer") public abstract String answer();

  @SerializedName("id") public abstract String id();

  @SerializedName("explains") public abstract String explains();

  @SerializedName("url") public abstract String url();

  public static TypeAdapter<Question> typeAdapter(Gson gson) {
    return new AutoValue_Question.GsonTypeAdapter(gson);
  }
}