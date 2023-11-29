package com.gorosoft.bookme.now.interactors

import com.gorosoft.bookme.now.entities.Location
import com.gorosoft.bookme.now.entities.PLACETYPE
import com.gorosoft.bookme.now.network_manager.KtorManager
import com.gorosoft.bookme.now.network_manager.Remote.PlaceRemoteFlow
import com.gorosoft.bookme.now.network_manager.Repositories.PlaceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

interface DashboardInteractorContract {
    fun getPlaces()
}

interface DashboardPresenterContract {
    fun displayPlaces(data: List<String>)
}

class DashboardInteractor(
    private val presenter: DashboardPresenterContract
) : DashboardInteractorContract {
    private val client = KtorManager()
    private val repository = PlaceRepository(PlaceRemoteFlow(client.client))
    private val vmScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    // https://goroshenko.azurewebsites.net/api/Place/Places?filter=barber&lat=50.465645&lon=30.5833821&radius=17
    override fun getPlaces() {
        vmScope.launch {
            val result = repository.getPlaces(
                type = PLACETYPE.BARBER,
                location = Location(30.5833821, 50.465645),
                radius = 17
            )

            result.onSuccess {
                presenter.displayPlaces(listOf(it.data?.nextPageToken.orEmpty()))
            }
            result.onFailure {
                println("33")
            }

        }
    }

    fun disappear() {
        vmScope.cancel()
    }
}