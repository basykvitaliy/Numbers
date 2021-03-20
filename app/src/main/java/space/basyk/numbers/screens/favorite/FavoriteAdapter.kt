package space.basyk.numbers.screens.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.num_item.view.*
import space.basyk.numbers.R
import space.basyk.numbers.models.modelroom.NumModel

class FavoriteAdapter: RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>() {

    private var listNumModel = emptyList<NumModel>()

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.num_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.tv_text_desc.text = listNumModel[position].description
        holder.itemView.tv_text_number.text = listNumModel[position].number.toString()

    }

    override fun getItemCount(): Int {
        return listNumModel.size
    }

    fun setList(list: List<NumModel>){
        listNumModel = list
        notifyDataSetChanged()
    }
}