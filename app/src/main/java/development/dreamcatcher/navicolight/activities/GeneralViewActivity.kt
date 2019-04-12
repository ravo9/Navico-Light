package development.dreamcatcher.navicolight.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import development.dreamcatcher.navicolight.R
import development.dreamcatcher.navicolight.adapters.ListAdapter
import development.dreamcatcher.navicolight.data.pojo.Contributor
import development.dreamcatcher.navicolight.viewmodels.GeneralViewModel
import kotlinx.android.synthetic.main.general_view.*
import kotlinx.android.synthetic.main.loading_badge.*


class GeneralViewActivity : AppCompatActivity() {

    private lateinit var viewModel: GeneralViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.general_view)

        // Initialize ViewModel
        viewModel = ViewModelProviders.of(this).get(GeneralViewModel::class.java)
        viewModel.setActivityReference(this)

        // Let ViewModel prepare data
        viewModel.loadContributorsData()
    }

    fun displayContributors(contributors: List<Contributor>) {

        // Hide "loading badge"
        dataFetchedProperly()

        // Sort contributors before displaying
        contributors.sortedBy { contributor -> contributor.commitsAmount }

        // Display loaded data
        recyclerView_contributors.adapter = ListAdapter(contributors, this, this)
        recyclerView_contributors.layoutManager = LinearLayoutManager(this)
    }

    private fun dataFetchedProperly() {
        loading_container.visibility = View.GONE
        appbar_container.visibility = View.VISIBLE
    }

    fun dataFetchingError() {
        Toast.makeText(this, R.string.data_couldnt_be_fetched, Toast.LENGTH_LONG).show()
    }
}
