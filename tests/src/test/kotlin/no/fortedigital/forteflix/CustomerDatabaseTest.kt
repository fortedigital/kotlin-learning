package no.fortedigital.forteflix

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CustomerDatabaseTest {
    private val serieDatabase = SerieDatabase()
    private val customerDatabase = CustomerDatabase(serieDatabase)

    @BeforeEach
    fun setUp() {
        customerDatabase.clear()
    }

    @Test
    fun getById() {
        val customer = Customer(name = "OddMagne").apply {
            addSerieTypesOfInterest(SerieType.Talkshow, SerieType.Humor)
        }
        customerDatabase.add(customer)
        assertEquals(customer.name, customerDatabase.getById(customer.id)?.name)
    }

    @Test
    fun getBySerieId() {
        val customer = Customer(name = "OddMagne").apply {
            addSerieTypesOfInterest(SerieType.Talkshow, SerieType.Humor)
        }
        val serie = Serie(title = "Min serie", types = setOf(SerieType.Humor))
        val serie2 = Serie(title = "Min serie 2", types = setOf(SerieType.Animasjon))

        customerDatabase.add(customer)
        serieDatabase.add(serie)

        assertEquals(1, customerDatabase.getBySerieId(serie.id).size)
        assertEquals(0, customerDatabase.getBySerieId(serie2.id).size)
    }
}