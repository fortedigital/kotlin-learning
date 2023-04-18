package no.fortedigital.forteflix

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SeriesDatabaseTest {
    private val database = SerieDatabase()

    @BeforeEach
    fun setUp() {
        database.clear()
    }

    @Test
    fun getById() {
        val serie = Serie(title = "Min serie", types = setOf(SerieType.Drama))
        database.add(serie)
        assertEquals(serie.title, database.getById(serie.id)?.title)
    }
}