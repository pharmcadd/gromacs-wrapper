package pharmcadd.gromacs.command

import pharmcadd.gromacs.extension.option

class Pdb2gmx(
    val f: String,
    val o: String,
    val ff: String? = null,
    val inter: Boolean? = null,
    val ss: Boolean? = null,
    val ter: Boolean? = null,
    val lys: Boolean? = null,
    val arg: Boolean? = null,
    val asp: Boolean? = null,
    val glu: Boolean? = null,
    val gln: Boolean? = null,
    val his: Boolean? = null,
    val ignh: Boolean? = null,
    val water: Water? = null,
    val merge: Merge? = null,
) : Command {

    override val command = "pdb2gmx"
    override val help = "http://manual.gromacs.org/documentation/current/onlinehelp/gmx-pdb2gmx.html"

    enum class ForceField {
        amber03, amber94, amber96, amber99, `amber99sb-ildn`, amber99sb, amberGS,
        charmm27,
        gromos43a1, gromos43a2, gromos45a3,
        gromos53a5, gromos53a6, gromos54a7,
        oplsaa
    }

    enum class Merge {
        no, all, interactive
    }

    enum class Water {
        none, spc, spce, tip3p, tip4p, tip5p, tips3p
    }

    override fun options(): List<String> {
        val options = mutableListOf<String>()
        options += "-f $f"
        options += "-o $o"
        if (ff != null) options += "-ff $ff"
        if (inter != null) options += "-${inter.option()}inter"
        if (ss != null) options += "-${ss.option()}ss"
        if (ter != null) options += "-${ter.option()}ter"
        if (lys != null) options += "-${lys.option()}lys"
        if (arg != null) options += "-${arg.option()}arg"
        if (asp != null) options += "-${asp.option()}asp"
        if (glu != null) options += "-${glu.option()}glu"
        if (gln != null) options += "-${gln.option()}gln"
        if (his != null) options += "-${his.option()}his"
        if (ignh != null) options += "-${ignh.option()}ignh"
        if (water != null) options += "-water $water"
        if (merge != null) options += "-merge $merge"
        return options
    }
}

fun main() {
    val line = Pdb2gmx(
        f = "5TNT_ALL.pdb",
        o = "5TNT.gro",
        ff = Pdb2gmx.ForceField.gromos53a6.name,
        inter = false,
        ignh = true,
        water = Pdb2gmx.Water.spc,
        merge = Pdb2gmx.Merge.all
    ).build()
    println(line)
}
