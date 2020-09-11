package pharmcadd.gromacs.command

class Genrestr(
    val f: String,
    val o: String,
    val fc: Triple<Int, Int, Int>? = null
) : Command {

    override val command = "genrestr"
    override val help: String = "http://manual.gromacs.org/documentation/current/onlinehelp/gmx-genrestr.html"

    override fun options(): List<String> {
        val options = mutableListOf<String>()
        options += "-f $f"
        options += "-o $o"
        if (fc != null) options += "-fc ${fc.first} ${fc.second} ${fc.third}"
        return options
    }
}
