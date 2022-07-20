import org.apache.commons.codec.binary.Base64

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our samples at https://docs.gradle.org/7.5/samples
 */

tasks.register("hello") {
    doLast {
        println("Hello World!")
    }
}

tasks.register("upper") {
    doLast {
        val someString = "mY_nAmE"
        println("Original: $someString")
        println("Upper Case: ${someString.toUpperCase()}")
    }
}

tasks.register("count") {
    doLast {
        repeat(4) {
            print("$it")
        }
    }
}

tasks.register("intro") {
    dependsOn("hello")
    doLast {
        println("I'm Gradle")
    }
}

tasks.register("taskX") {
    dependsOn("taskY")
    doLast {
        println("taskX")
    }
}

tasks.register("taskY") {
    doLast {
        println("taskY")
    }
}

repeat(4) { counter ->
    tasks.register("task$counter") {
        doLast {
            println("I'm task numbered $counter")
        }
    }
}

tasks.named("task0") {
    dependsOn("task2", "task3")
}

tasks.named("hello") {
    doLast {
        println("Hello Earth")
    }
}

tasks.named("hello") {
    doLast {
        println("Hello Venus")
    }
}

tasks.named("hello") {
    doLast {
        println("Hello Mars")
    }
}

tasks.named("hello") {
    doLast {
        println("Hello Jupiter")
    }
}

// The calls doFirst and doLast can be executed multiple times.
// They add an action to the beginning or the end of the task’s actions list.
// When the task executes, the actions in the action list are executed in order.

defaultTasks("clean", "run")

tasks.register("clean") {
    doLast {
        println("Default Cleaning!")
    }
}

tasks.register("run") {
    doLast {
        println("Default Running!")
    }
}

tasks.register("other") {
    doLast {
        println("I'm not a default task!")
    }
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        "classpath"(group = "commons-codec", name = "commons-codec", version = "1.2")
    }
}

tasks.register("encode") {
    doLast {
        val encodedString = Base64().encode("hello World\n".toByteArray())
        println(String(encodedString))
    }
}
// Build script dependencies may be Gradle plugins.
// Please consult Using Gradle Plugins for more information on Gradle plugins.

// Every project automatically has a buildEnvironment task of type BuildEnvironmentReportTask that can be invoked
// to report on the resolution of the build script dependencies.