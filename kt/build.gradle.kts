dependencies {
    testImplementation(kotlin("test"))

}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "no.fortedigital.MainKt"
    }
}