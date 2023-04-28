package com.example.mycryptocurrency.domain.use_cases.get_coins

import com.example.mycryptocurrency.data.remote.dto.toCoin
import com.example.mycryptocurrency.domain.model.Coin
import com.example.mycryptocurrency.domain.repository.CoinRepository
import com.example.mycryptocurrency.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit((Resource.Error(e.localizedMessage ?: "An unexpected error occured")))
        } catch (e: IOException) {
            emit((Resource.Error("Couldn't reach server. Check your internet connection")))
        }
    }

}