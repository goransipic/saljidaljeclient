package hr.goodapp.saljidaljeclient

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


class SearchFormViewModel(
    private val repository: SearchRepository,
    dropdowns: List<DropdownProps>
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    data class UiState(
        val activeTab: String = "New",
        val seoName: String? = null,
        val bodyTypeSelection: Int? = null,
        val locationTypeSelection: Int? = null,
        val productCount: Int? = null,
        val makeId: Int? = null,
        val modelId: Int? = null,
        val make: DropdownProps,
        val model: DropdownProps,
        val bodyType: DropdownProps,
        val location: DropdownProps
    )

    private val _uiState = MutableStateFlow(
        UiState(
            make = dropdowns[0],
            model = dropdowns[1],
            bodyType = dropdowns[2],
            location = dropdowns[3]
        )
    )
    val uiState: StateFlow<UiState> = _uiState

    fun setActiveTab(tab: String) {
        _uiState.update { it.copy(activeTab = tab) }
    }

    fun selectMake(option: Option) {
        _uiState.update { it.copy(seoName = option.seoName, makeId = option.id) }
        loadChildren(option.id)
    }

    fun selectModel(option: Option) {
        _uiState.update {
            it.copy(
                seoName = option.seoName,
                modelId = option.id,
                model = it.model.copy(name = option.name)
            )
        }
        loadBodyType(option.id)
    }

    fun selectBodyType(option: Option) {
        _uiState.update {
            it.copy(
                bodyTypeSelection = option.id,
                bodyType = it.bodyType.copy(name = option.name)
            )
        }
    }

    fun selectLocation(option: Option) {
        _uiState.update {
            it.copy(
                locationTypeSelection = option.id,
                location = it.location.copy(name = option.name)
            )
        }
    }

    private fun loadChildren(makeId: Int) {
        scope.launch {
            try {
                val result = repository.getModels(makeId)
                val bodyTypes = repository.getSpecifications(makeId, "BODY_TYPE")
                val locations = repository.getSpecifications(makeId, "LOCATIONS")

                _uiState.update {
                    it.copy(
                        productCount = result.productsCount,
                        model = it.model.copy(
                            name = "Model",
                            options = result.properties.map { p ->
                                Option(p.text, p.seoName, p.value.toInt())
                            }
                        ),
                        bodyType = it.bodyType.copy(
                            name = "Body type",
                            options = bodyTypes.properties.map { p -> Option(p.name, id = p.id) }
                        ),
                        location = it.location.copy(
                            name = "Location",
                            options = locations.properties.map { p -> Option(p.name, id = p.id) }
                        )
                    )
                }
            } catch (e: Throwable) {
                println("Error: $e")
            }
        }
    }

    private fun loadBodyType(modelId: Int) {
        scope.launch {
            try {
                val bodyTypes = repository.getSpecifications(modelId, "BODY_TYPE")

                _uiState.update {
                    it.copy(
                        productCount = bodyTypes.productsCount,
                        bodyType = it.bodyType.copy(
                            name = "Body type",
                            options = bodyTypes.properties.map { p -> Option(p.name, id = p.id) }
                        )
                    )
                }
            } catch (e: Throwable) {
                println("Error: $e")
            }
        }
    }
}
