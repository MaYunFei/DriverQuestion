package io.github.mayunfei.drivingquestion;

import io.github.mayunfei.drivingquestion.bean.BaseResponse;
import io.github.mayunfei.drivingquestion.bean.Question;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mayunfei on 17-4-1.
 */

public interface Api {
  @GET("query") Observable<BaseResponse<List<Question>>> query(@Query("subject") int subject,
      @Query("model") String model, @Query("testType") String testType, @Query("key") String key);
}
