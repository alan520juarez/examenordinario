package com.ingenieriaentecnologias.examenordinario.activity.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ingenieriaentecnologias.examenordinario.R
import com.ingenieriaentecnologias.examenordinario.activity.detail.DetailMainActivity
import com.ingenieriaentecnologias.examenordinario.databinding.ActivityMainBinding
import com.ingenieriaentecnologias.examenordinario.models.Cash

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val Caslist = mutableListOf<Cash>(
            Cash(1,"Bitcoin",Cash.CashGenre.BTC,"1,235,488.71"),
            Cash(2,"Ethereum",Cash.CashGenre.ETHER,"83,166.64"),
            Cash(3,"Litecoin",Cash.CashGenre.LTC,"3,155.21"),
            Cash(4,"Dash",Cash.CashGenre.XCOIN,"2,813.22"),
            Cash(5,"DogenCoin",Cash.CashGenre.DOGE,"3.53"),
            Cash(6,"Tether",Cash.CashGenre.USDT,"20.87"),
            Cash(7,"Polkadot",Cash.CashGenre.DOT,"25.96 "),
            Cash(8,"Cardano",Cash.CashGenre.ADA,"26.29"),
            Cash(9,"Solana",Cash.CashGenre.SOL,"172.13"),
            Cash(10,"Binance",Cash.CashGenre.BNB,"577.81"),
        )
        val cashlistAdapter = CashlistAdapter(Caslist)

        binding.cashList.layoutManager = LinearLayoutManager(this)
        binding.cashList.adapter = cashlistAdapter
        cashlistAdapter.onCashClick ={
            val intent = Intent(this,DetailMainActivity::class.java).apply {

                val imageToSend = when(it.id){
                    1 -> R.drawable.bitcon
                    2-> R.drawable.eeee
                    3 -> R.drawable.litecoin
                    4 -> R.drawable.dash
                    5 -> R.drawable.dogen
                    6 -> R.drawable.tether
                    7 -> R.drawable.polkat
                    8 -> R.drawable.cardano
                    9 -> R.drawable.solana
                    10 -> R.drawable.binace
                    else -> R.drawable.ic_launcher_background
                }
                putExtra(DetailMainActivity.CASH_KEY, it )
                putExtra(DetailMainActivity.CASH_IMAGE, imageToSend)
            }
            startActivity(intent)
        }

    }
}