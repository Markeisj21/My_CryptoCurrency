package com.example.mycryptocurrency.domain.repository

import com.example.mycryptocurrency.data.remote.dto.CoinDetailDto
import com.example.mycryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto

}