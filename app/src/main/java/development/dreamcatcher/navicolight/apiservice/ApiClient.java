package development.dreamcatcher.navicolight.apiservice;

import development.dreamcatcher.navicolight.data.pojo.Contributor;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import java.util.List;


public interface ApiClient {

    @GET("/repos/ruby/ruby/contributors")
    @Headers({
            "appVersion: 1.0.0",
            "apiVersion: 1.0.0"
    })
    Single<List<Contributor>> getContributors();
}