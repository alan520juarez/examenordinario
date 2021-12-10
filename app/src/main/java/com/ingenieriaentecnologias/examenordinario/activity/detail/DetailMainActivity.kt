package com.ingenieriaentecnologias.examenordinario.activity.detail

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ingenieriaentecnologias.examenordinario.R
import com.ingenieriaentecnologias.examenordinario.databinding.ActivityDetailMainBinding
import com.ingenieriaentecnologias.examenordinario.databinding.ActivityMainBinding
import com.ingenieriaentecnologias.examenordinario.models.Cash

class DetailMainActivity : AppCompatActivity() {
    companion object{
        const val CASH_KEY = "cash_item"
        const val CASH_IMAGE = "cash_image"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_main)
        val binding = DataBindingUtil.setContentView<ActivityDetailMainBinding>(this, R.layout.activity_detail_main)
        val bundle:Bundle? = intent.extras

        if (bundle != null){
            val cash = bundle.getParcelable<Cash>("CASH_KEY")

            val Image = bundle.getInt(CASH_IMAGE)

            binding.title.text = cash?.name

            binding.imageProfile.setImageResource(Image)

        }
    }
}