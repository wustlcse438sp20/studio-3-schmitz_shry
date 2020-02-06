package com.example.cse438.studio3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438_rest_studio.Network.BreweryRepository
import com.example.cse438_rest_studio.data.Brewery
import com.example.cse438_rest_studio.data.BreweryPayload


class BreweryViewModel(application: Application): AndroidViewModel(application) {

    //TODO #8: Create a livedata object for tracking breweries
    public var brewList: MutableLiveData<List<Brewery>> = MutableLiveData()
    public var brewRepo: BreweryRepository = BreweryRepository()

    //TODO #9: Write functions to access the two brewery API calls from the repository
    fun getBreweriesByCity(city: String) {
        brewRepo.getBreweriesByCity(brewList, city)
    }

    fun getBreweriesByTerm(term: String) {
        brewRepo.getBreweriesByTerm(brewList, term)
    }
}