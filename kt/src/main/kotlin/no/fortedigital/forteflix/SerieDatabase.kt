package no.fortedigital.forteflix

class SerieDatabase {
    private val series = mutableMapOf<Int, Serie>()
    fun clear() = series.clear()

    fun add(serie: Serie) {
        series[serie.id] = serie
    }

    fun getById(id: Int) = series[id]
}
