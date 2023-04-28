package com.example.mycryptocurrency.domain.use_cases.get_coin

import com.example.mycryptocurrency.data.remote.dto.toCoin
import com.example.mycryptocurrency.data.remote.dto.toCoinDetail
import com.example.mycryptocurrency.domain.model.Coin
import com.example.mycryptocurrency.domain.model.CoinDetail
import com.example.mycryptocurrency.domain.repository.CoinRepository
import com.example.mycryptocurrency.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit((Resource.Error(e.localizedMessage ?: "An unexpected error occurred")))
        } catch (e: IOException) {
            emit((Resource.Error("Couldn't reach server. Check your internet connection")))
        }
    }

}