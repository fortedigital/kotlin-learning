package no.fortedigital.forteflix

import java.time.LocalDate

class CustomerDatabase(private val serieDatabase: SerieDatabase) {
    private val customers = mutableMapOf<Int, Customer>()

    fun clear() {
        customers.clear()
    }

    fun add(customer: Customer) {
        customers[customer.id] = customer
    }

    fun getById(id: Int) = customers[id]

    fun getAll() = customers.values.toList()

    fun getBySerieId(id: Int) = serieDatabase.getById(id)?.let { serie ->
        customers.values.filter { customer -> customer.isInterestedIn(serie.typesOfInterest) }
    } ?: emptyList()

    fun getCustomersBetweenDates(start: LocalDate, end: LocalDate) =
        customers.values.filter { customer ->
            (customer.registrationDate.isAfter(start) || customer.registrationDate.isEqual(start)) && (customer.registrationDate.isBefore(end) || customer.registrationDate.isEqual(end))
        }
}
