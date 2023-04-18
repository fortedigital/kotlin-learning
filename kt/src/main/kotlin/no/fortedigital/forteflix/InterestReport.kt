package no.fortedigital.forteflix

class InterestReport(private val customerDatabase: CustomerDatabase, private val serieDatabase: SerieDatabase) {
    fun findInterestWeight(customerId: Int, serieId: Int): Int {
        val customer = customerDatabase.getById(customerId)
        val serie = serieDatabase.getById(serieId)
        requireNotNull(customer)
        requireNotNull(serie)
        return serie.interestWeight(customer)
    }

    fun highestSeries() = serieDatabase.getAll().maxByOrNull(::highestInterestWeight)

    private fun highestInterestWeight(serie: Serie): Int {
        return customerDatabase.getAll().sumOf(serie::interestWeight)
    }
}
