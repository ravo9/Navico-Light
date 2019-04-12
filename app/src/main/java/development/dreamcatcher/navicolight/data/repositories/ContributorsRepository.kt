package development.dreamcatcher.navicolight.data.repositories

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import development.dreamcatcher.navicolight.apiservice.ApiUtils
import development.dreamcatcher.navicolight.data.pojo.Contributor
import io.reactivex.schedulers.Schedulers


class ContributorsRepository {

    var allContributors: MutableLiveData<List<Contributor>> = MutableLiveData()
    val errorFlag: MutableLiveData<Boolean> = MutableLiveData()

    init {
        ApiUtils.initializeAPIService()
        fetchContributors()
    }

    @SuppressLint("CheckResult")
    private fun fetchContributors() {

        ApiUtils.getContributors()
            .subscribeOn(Schedulers.io())
            .subscribe(
                { contributors ->
                    allContributors.postValue(contributors)
                },
                { throwable ->
                    errorFlag.postValue(true)
                    Log.e("Error:", throwable.message)
                }
            )
    }

    fun getContributorById(id: Int?) : Contributor? {
        return allContributors.value?.find { contributor -> contributor.id == id }
    }
}