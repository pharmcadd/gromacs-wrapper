package pharmcadd.gromacs.command

import pharmcadd.gromacs.extension.option

class Editconf(
    val f: String,
    val o: String,
    val c: Boolean? = null,
    val box: Triple<Double, Double, Double>? = null,
    val princ: Boolean? = null,
    val rotate: Triple<Double, Double, Double>? = null
) : Command {

    override val command = "editconf"
    override val help = "http://manual.gromacs.org/current/onlinehelp/gmx-editconf.html"

    override fun options(): List<String> {
        val options = mutableListOf<String>()
        options += "-f $f"
        options += "-o $o"
        if (c != null) options += "-${c.option()}c"
        if (box != null) options += "-box ${box.first} ${box.second} ${box.third}"
        if (princ != null) options += "-${princ.option()}princ"
        if (rotate != null) options += "-rotate ${rotate.first} ${rotate.second} ${rotate.third}"
        return options
    }
}
