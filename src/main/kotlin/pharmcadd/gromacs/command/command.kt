package pharmcadd.gromacs.command

interface Command {
    val command: String
    val help: String

    fun build(): String = listOf(command, *options().toTypedArray()).joinToString(" ")

    fun options(): List<String>
}
