package com.example.cse438_rest_studio.Network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.cse438_rest_studio.data.Brewery
import com.example.cse438_rest_studio.data.BreweryPayload
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class BreweryRepository {

    val service = ApiClient.makeRetrofitService()

    //TODO #6: Create a function that launches a coroutine for searching by city
    fun getBreweriesByCity(resBody: MutableLiveData<List<Brewery>>, city: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val res = service.getBreweriesByCity(city)

            withContext(Dispatchers.Main) {
                try {
                    if (res.isSuccessful) {
                        resBody.value = res.body()
                        Log.d("GOT RESPONSE", res.body().toString())
                    }
                } catch (e: HttpException) {
                    println("HTTP Err")
                }
            }
        }
    }
    //TODO #7: Create a function that launches a coroutine for searching by a generic term
    fun getBreweriesByTerm(resBody: MutableLiveData<List<Brewery>>, query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val res = service.getBreweriesByTerm(query)

            withContext(Dispatchers.Main) {
                try {
                    if (res.isSuccessful) {
                        resBody.value = res.body()
                    }
                } catch (e: HttpException) {
                    println("HTTP Err")
                }
            }
        }
    }
}