package development.dreamcatcher.navicolight.viewmodels

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import development.dreamcatcher.navicolight.activities.GeneralViewActivity
import development.dreamcatcher.navicolight.data.pojo.Contributor
import development.dreamcatcher.navicolight.data.repositories.ContributorsRepository


class GeneralViewModel : ViewModel() {

    var activity: GeneralViewActivity? = null

    val contributorsRepository = ContributorsRepository()

    fun setActivityReference(activity: GeneralViewActivity) {
        this.activity = activity
    }

    fun loadContributorsData() {

        contributorsRepository.allContributors.observe(activity as GeneralViewActivity,
            Observer<List<Contributor>> { posts ->

                (activity as GeneralViewActivity).displayContributors(posts)
        })

        contributorsRepository.errorFlag.observe(activity as GeneralViewActivity,
            Observer<Boolean> { errorOccured ->

                (activity as GeneralViewActivity).dataFetchingError()
        })
    }
}