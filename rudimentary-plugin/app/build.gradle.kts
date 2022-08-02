val build by tasks.registering

build {
    doLast {
        val sourceDir = File(projectDir, "src/main/java")
        val packageName = "com.example"
        val packageDirectory = packageName.replace(".", "/")
        val command = "javac -d ${project.buildDir} -cp $packageName $packageDirectory/*.java"
        println(command)
    }
}

val executeCommandLine by tasks.registering(Exec::class){
    commandLine()
}

// https://docs.gradle.org/current/userguide/more_about_tasks.html#sec:passing_arguments_to_a_task_constructor
// https://docs.oracle.com/en/java/javase/17/docs/specs/man/javac.html#arrangement-of-source-code