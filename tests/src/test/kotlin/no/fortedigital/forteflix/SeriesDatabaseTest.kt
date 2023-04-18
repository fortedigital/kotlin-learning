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

    @Test
    fun getByType() {
        database.add(Serie(title = "C", types = setOf(SerieType.Drama)))
        database.add(Serie(title = "B", types = setOf(SerieType.Drama)))
        database.add(Serie(title = "A", types = setOf(SerieType.Drama)))

        assertEquals(3, database.getBySerieType(SerieType.Drama).size)
        assertEquals(0, database.getBySerieType(SerieType.Humor).size)

        assertEquals("A", database.getBySerieType(SerieType.Drama).first().title)
    }
}