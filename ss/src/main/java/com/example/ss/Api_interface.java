package com.example.ss;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2017/12/4.
 */

public interface Api_interface {
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<Bean> getApi_interface();
}
