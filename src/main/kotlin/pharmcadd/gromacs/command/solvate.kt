package pharmcadd.gromacs.command

class Solvate : Command {

    override val command = "solvate"
    override val help = "http://manual.gromacs.org/current/onlinehelp/gmx-solvate.html"

    override fun options(): List<String> {
        TODO("Not yet implemented")
    }
}
