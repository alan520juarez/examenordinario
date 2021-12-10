package com.ingenieriaentecnologias.examenordinario.activity.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ingenieriaentecnologias.examenordinario.databinding.CashListItemBinding
import com.ingenieriaentecnologias.examenordinario.models.Cash

class CashlistAdapter(private val cashlist: List<Cash>) : RecyclerView.Adapter<CashlistAdapter.ViewHolder>(){
   lateinit var onCashClick: (Cash) -> Unit

    inner class ViewHolder(private val binding: CashListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(cash: Cash){
            binding.cashId.text = cash.id.toString()
            binding.name.text = cash.name
            binding.genre.text = cash.genre.name
            binding.root.setOnClickListener(){
                   if(::onCashClick.isInitialized)
                onCashClick(cash)
                else
                    Log.i("edgCashAdappter"," The onCashClick from CashlistAdapter is not initialized")
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = CashListItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bind(cashlist[position])
    }

    override fun getItemCount(): Int {
        return cashlist.count()
    }
}