package com.example.mycryptocurrency.presentation.coin_detail

import com.example.mycryptocurrency.domain.model.Coin
import com.example.mycryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
