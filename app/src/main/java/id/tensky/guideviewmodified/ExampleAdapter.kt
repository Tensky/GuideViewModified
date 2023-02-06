package id.tensky.guideviewmodified

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ExampleAdapter(
    private var itemList: List<String>,
    private val onItemClicked: (position: Int) -> Unit,
) :
    RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_title)
        val mainLayout: LinearLayout = itemView.findViewById(R.id.ll_main)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_example, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.apply {
            title.text = item
            mainLayout.setOnClickListener {
                onItemClicked(position)
            }
        }
    }

    override fun getItemCount(): Int = itemList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItemList(itemList: List<String>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }
}