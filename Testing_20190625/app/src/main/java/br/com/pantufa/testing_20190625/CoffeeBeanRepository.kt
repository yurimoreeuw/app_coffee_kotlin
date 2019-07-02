package br.com.pantufa.testing_20190625

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//TODO transformar em singleton
class CoffeeBeanRepository {

    //lazy is responsible to initialize a object without give it a value
    //can crash if you dont initialize the object later
    private val coffeeBeanRemoteDataSource by lazy { retrofit.create(CoffeeBeanRemoteDataSource::class.java) }

    //link between retrofit and converter is created as well as an url is set as default
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.myjson.com/bins/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun getCoffeeList(onSuccess: (List<CoffeeBeanModel>) -> Unit, onError: (Throwable?) -> Unit) {
        val call = coffeeBeanRemoteDataSource.getCoffeeList()

        call.enqueue(object : Callback<List<CoffeeBeanModel>?> {
            override fun onResponse(call: Call<List<CoffeeBeanModel>?>?, response: Response<List<CoffeeBeanModel>?>?) {
                Log.d("RESULTADO", response?.body()?.first()?.producer ?: "wops")
                onSuccess(response?.body() ?: emptyList())
            }

            override fun onFailure(call: Call<List<CoffeeBeanModel>?>?, t: Throwable?) {
                Log.d("RESULTADO", "erro ${t.toString()}")
                t?.printStackTrace()
                onError(t)
            }
        })
    }


}
