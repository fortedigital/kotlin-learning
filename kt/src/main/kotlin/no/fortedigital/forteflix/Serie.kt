package no.fortedigital.forteflix

class Serie(val title: String, types: Set<SerieType>) {
    val id = IdGen.getId()
    private val types: MutableSet<SerieType> = types.toMutableSet()
    val typesOfInterest
        get() = types.toSet()

    fun totalSerieTypes() = types.size

    init {
        require(types.isNotEmpty())
        require(title.isNotEmpty())
    }

    fun addSerieType(serieType: SerieType) = types.add(serieType)
    fun removeSerieType(serieType: SerieType) {
        require(!types.none { it != serieType })
        types.remove(serieType)
    }

    fun interestWeight(customer: Customer) = types.count {
        customer.isInterestedIn(setOf(it))
    }
}