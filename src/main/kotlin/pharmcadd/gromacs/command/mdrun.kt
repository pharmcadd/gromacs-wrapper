package pharmcadd.gromacs.command

class Mdrun : Command {

    override val command = "mdrun"
    override val help = "http://manual.gromacs.org/current/onlinehelp/gmx-mdrun.html"

    override fun options(): List<String> {
        TODO("Not yet implemented")
    }
}
