package no.fortedigital

data class Customer(private val name: String) {
    fun uppercased() = name.uppercase()
    internal fun myNameTho() = name
}
