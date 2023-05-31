package no.fortedigital.coroutines

fun a(): String {
    Thread.sleep(2000L)
    return "The quick brown"
}

fun b(): String {
    Thread.sleep(2000L)
    return " fox jumps"
}

fun c(): String {
    Thread.sleep(2000L)
    return " over the lazy dog"
}

fun runTasks(): String {
    return "${a()}${b()}${c()}"
}