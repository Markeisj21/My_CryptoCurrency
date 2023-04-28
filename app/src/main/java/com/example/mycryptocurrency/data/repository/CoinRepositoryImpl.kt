package com.example.mycryptocurrency.data.repository

import com.example.mycryptocurrency.data.remote.CoinPaprikaApi
import com.example.mycryptocurrency.data.remote.dto.CoinDetailDto
import com.example.mycryptocurrency.data.remote.dto.CoinDto
import com.example.mycryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi

) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }


}