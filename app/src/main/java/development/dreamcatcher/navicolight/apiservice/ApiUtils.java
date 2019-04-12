package development.dreamcatcher.navicolight.apiservice;

import development.dreamcatcher.navicolight.data.pojo.Contributor;
import io.reactivex.Single;

import java.util.List;


public class ApiUtils {

    private static ApiClient apiClient;
    private static final String BASE_URL = "https://api.github.com";

    public static void initializeAPIService() {
        if (apiClient == null)
            apiClient = RetrofitClient.getClient(BASE_URL).create(ApiClient.class);
    }

    public static Single<List<Contributor>> getContributors() {
        return apiClient.getContributors();
    }
}