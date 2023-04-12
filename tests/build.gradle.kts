dependencies {
    testImplementation(kotlin("test"))
    implementation(project(":java"))
    implementation(project(":kt"))
}

tasks.test {
    useJUnitPlatform()
}