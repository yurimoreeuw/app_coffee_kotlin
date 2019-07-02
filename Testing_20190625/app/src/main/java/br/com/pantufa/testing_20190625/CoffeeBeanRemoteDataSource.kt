package br.com.pantufa.testing_20190625

import retrofit2.Call
import retrofit2.http.GET

interface CoffeeBeanRemoteDataSource {

    @GET("kjiuv")
    fun getCoffeeList(): Call<List<CoffeeBeanModel>>


}