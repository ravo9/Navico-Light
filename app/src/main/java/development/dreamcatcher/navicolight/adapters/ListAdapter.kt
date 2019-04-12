package development.dreamcatcher.navicolight.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import development.dreamcatcher.navicolight.R
import development.dreamcatcher.navicolight.data.pojo.Contributor
import kotlinx.android.synthetic.main.contributors_list_row.view.*


class ListAdapter(private val items : List<Contributor>, private val context: Context, private val activity: Activity)
    : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.contributors_list_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Prepare fetched data
        val username = items[position].username
        val commitsAmount = "Commits Amount: " + items[position].commitsAmount.toString()
        val avatarUrl = items[position].avatarUrl

        // Set data within the holder
        holder.username.text = username
        holder.commitsAmount.text = commitsAmount

        // Load avatar
        Picasso.with(context).load(avatarUrl).into(holder.avatar)

        // Set animation
        val animation = AnimationUtils.loadAnimation(context, R.anim.recycler_view_single_row_animation)
        holder.container?.startAnimation(animation)

        // Set onClickListener
        holder.itemView.setOnClickListener{
            ///
        }
    }

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val container = view.row_container
        val username = view.textView_username
        val commitsAmount = view.textView_contributions_amount
        val avatar = view.avatar
    }
}

