package com.example.geomob


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.geomob.model.Pays
import kotlinx.android.synthetic.main.pays_list_item.view.*


class PaysRecyclerAdapter (private val context: Context?, private var list: MutableList<Pays>) :
    RecyclerView.Adapter<PaysRecyclerAdapter.MyViewHolder>() {


    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.pays_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = list[position]
        holder.setData(current, position)
        holder.itemView.setOnClickListener({
         val intent = Intent(context,PaysDetailActivity::class.java)
            intent.putExtra("pays",current)

            if (context != null) {
                context.startActivity(intent)
            }

        })

    }

    override fun getItemCount(): Int = list.size



    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private var pos: Int = 0
        lateinit var current: Pays

        fun setData(current: Pays, position: Int) {
            itemView.nom_pays.text = current.nom
            if (context != null) {
                Glide.with(context)
                    .load(current.drapeau)
                    .into(itemView.detail_drapeau)
            }

            this.pos = position
            this.current = current
        }

    }
}