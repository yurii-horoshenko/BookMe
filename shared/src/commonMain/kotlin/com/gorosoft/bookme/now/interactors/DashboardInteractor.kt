package com.gorosoft.bookme.now.interactors

import com.gorosoft.bookme.now.entities.responses.Location
import com.gorosoft.bookme.now.entities.responses.PLACETYPE
import com.gorosoft.bookme.now.network.KtorManager
import com.gorosoft.bookme.now.network.remote.PlaceRemoteFlow
import com.gorosoft.bookme.now.network.repositories.PlaceRepository
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
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