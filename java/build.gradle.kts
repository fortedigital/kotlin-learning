plugins {
    java
    application
}

application {
    mainClass.set("no.fortedigital.Hello")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "no.fortedigital.Hello"
    }
}