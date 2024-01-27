package com.example.mashe4kinapogodaotivana.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mashe4kinapogodaotivana.R
import com.example.mashe4kinapogodaotivana.businessModel.DailyWeatherModel
import com.example.mashe4kinapogodaotivana.databinding.RvitemDailyMainBinding
import com.example.mashe4kinapogodaotivana.view.DAY_WEEK_NAME_LONG
import com.example.mashe4kinapogodaotivana.view.toDateFormatOF
import com.example.mashe4kinapogodaotivana.view.toDegree


class MainDailyWeatherAdapter : BaseAdapter<DailyWeatherModel>() {

    lateinit var clickListener:DayItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view =
            RvitemDailyMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DailyWeatherViewHolder(view)
    }

    interface DayItemClickListener{
        fun showDetail(data:DailyWeatherModel)
    }

    inner class DailyWeatherViewHolder(private val itemBinding: RvitemDailyMainBinding) :
        BaseViewHolder(itemBinding.root) {
        override fun bindView(position: Int) {
            mData[position].apply {
                itemBinding.rvitemDailyDateMTV.text = dt.toDateFormatOF(DAY_WEEK_NAME_LONG)
                itemBinding.rvitemDailyWeatherIcIV.setImageResource(R.drawable.ic_menu_24)
                itemBinding.rvitemDailyHumidityMTV.text= pop.toString()
                itemBinding.rvitemDailyMaxTemperatureMTV.text=temp.max.toDegree()
                itemBinding.rvitemDailyMinTemperatureMTV.text=temp.min.toDegree()
            }
        }
    }
}