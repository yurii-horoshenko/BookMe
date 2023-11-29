package com.gorosoft.bookme.now.Interactors

import com.gorosoft.bookme.now.Entities.Location
import com.gorosoft.bookme.now.Entities.PLACETYPE
import com.gorosoft.bookme.now.NetworkManager.KtorManager
import com.gorosoft.bookme.now.NetworkManager.Remote.PlaceRemoteFlow
import com.gorosoft.bookme.now.Repositories.PlaceRepository
import io.ktor.client.HttpClient


interface DashboardInteractorContract {
    fun getPlaces()
}

interface DashboardPresenterContract {
    fun displayPlaces(data: List<String>)
}

class DashboardInteractor(
    private val presenter: DashboardPresenterContract
): DashboardInteractorContract {
//    private val client = KtorManager().client
    override fun getPlaces() {
        val client = KtorManager().client
//     val repository = PlaceRepository(PlaceRemoteFlow(HttpClient()))
        println()
        // https://goroshenko.azurewebsites.net/api/Place/Places?filter=barber&lat=50.465645&lon=30.5833821&radius=17
        //repository.getPlaces(PLACETYPE.BARBER, Location(30.5833821, 50.465645))
        //presenter.displayPlaces(listOf("Barber1"))
    }

}