package com.ege.examples.example_templates.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ege.examples.R
import de.hdodenhof.circleimageview.CircleImageView

class CountriesAdapter(
    var countryNameList: ArrayList<String>,
    var countryDescList: ArrayList<String>,
    var imageList: ArrayList<Int>,
    var context: Context) : RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var textViewCountryName : TextView = itemView.findViewById(R.id.textViewCountryName)
        var textViewCountryDesc : TextView = itemView.findViewById(R.id.textViewCountryDesc)
        var countryImage : CircleImageView = itemView.findViewById(R.id.countryImage)
        var cardView : CardView = itemView.findViewById(R.id.cardView)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.card_design,parent, false)

        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryNameList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.textViewCountryName.text = countryNameList.get(position)
        holder.textViewCountryDesc.text = countryDescList.get(position)
        holder.countryImage.setImageResource(imageList.get(position))

        holder.cardView.setOnClickListener {

            Toast.makeText(context, "You selected the ${countryNameList.get(position)}", Toast.LENGTH_LONG).show()

        }
    }

}