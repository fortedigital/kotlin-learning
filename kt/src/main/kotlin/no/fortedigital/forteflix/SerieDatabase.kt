package no.fortedigital.forteflix

class SerieDatabase {
    private val series = mutableMapOf<Int, Serie>()

    fun clear() = series.clear()

    fun add(serie: Serie) {
        series[serie.id] = serie
    }

    fun getById(id: Int) = series[id]

    fun getBySerieType(serieType: SerieType) =
        series.values
            .filter { serie -> serie.typesOfInterest.contains(serieType) }
            .sortedBy(Serie::title)

    fun getAll() = series.values.toList()
}
