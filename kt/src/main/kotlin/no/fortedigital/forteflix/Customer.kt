package no.fortedigital.forteflix

import java.time.LocalDate

class Customer(val name: String, val registrationDate: LocalDate = LocalDate.now()) {
    val id = IdGen.getId()
    private val serieTypesOfInterest: MutableSet<SerieType> = mutableSetOf()

    init {
        require(name.isNotEmpty())
    }

    fun totalSerieTypesOfInterest() = serieTypesOfInterest.size

    fun addSerieTypesOfInterest(vararg serieTypes: SerieType) = serieTypesOfInterest.addAll(serieTypes)
    fun removeSerieTypeOfInterest(serieType: SerieType) = serieTypesOfInterest.remove(serieType)
    fun isInterestedIn(types: Set<SerieType>) = serieTypesOfInterest.any { it in types }
}