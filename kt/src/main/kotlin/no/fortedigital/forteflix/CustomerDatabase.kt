package no.fortedigital.forteflix

class CustomerDatabase(private val serieDatabase: SerieDatabase) {
    private val customers = mutableMapOf<Int, Customer>()

    fun clear() {
        customers.clear()
    }

    fun add(customer: Customer) {
        customers[customer.id] = customer
    }

    fun getById(id: Int) = customers[id]
    fun getBySerieId(id: Int) = serieDatabase.getById(id)?.let { serie ->
        customers.values.filter { customer -> customer.isInterestedIn(serie.typesOfInterest) }
    } ?: emptyList()
}
