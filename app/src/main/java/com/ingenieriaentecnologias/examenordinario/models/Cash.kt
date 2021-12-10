package com.ingenieriaentecnologias.examenordinario.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Cash (
    val id: Int,
    val name: String,
    val genre: CashGenre,
    val Price: String?,

) : Parcelable {
    enum class CashGenre{
        BTC, ETHER, LTC, XCOIN, DOGE, USDT, DOT, ADA, SOL, BNB
    }
}