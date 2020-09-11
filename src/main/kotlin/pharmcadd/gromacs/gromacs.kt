package pharmcadd.gromacs

import pharmcadd.gromacs.Pdb2gmx.*

private fun String.extension(): String {
    return this.substringAfterLast(".", "")
}

private fun Boolean.option(): String {
    return if (this) "yes" else "no"
}

enum class StructureInputFile {
    gro, g96, pdb, brk, ent, esp, tpr
}

enum class StructureOutputFile {
    gro, g96, pdb, brk, ent, esp
}

interface Command {
    fun command(): String

    fun url(): String

    fun validate(): Boolean = true

    fun build(): String
}

class Pdb2gmx(
    val f: String,
    val o: String,
    val ff: ForceField = ForceField.select,
    val ignh: Boolean = false,
    val ss: Boolean = false,
    val ter: Boolean = false,
    val lys: Boolean = false,
    val arg: Boolean = false,
    val asp: Boolean = false,
    val glu: Boolean = false,
    val gln: Boolean = false,
    val his: Boolean = false,
    val water: Water = Water.select,
    val merge: Merge = Merge.no
) : Command {

    override fun command(): String = "pdb2gmx"

    override fun url(): String = "http://manual.gromacs.org/documentation/current/onlinehelp/gmx-pdb2gmx.html"

    enum class ForceField {
        select,
        amber03, amber94, amber96, amber99, amber99sb_ildn, amber99sb, amberGS,
        charmm27,
        gromos43a1, gromos43a2, gromos45a3,
        gromos53a5, gromos53a6, gromos54a7,
        oplsaa
    }

    enum class Merge {
        no, all, interactive
    }

    enum class Water {
        select, none, spc, spce, tip3p, tip4p, tip5p, tips3p
    }

    override fun validate(): Boolean {
        if (StructureInputFile.values().filter { it.name == f.extension().toLowerCase() }.any().not()) {
            return false
        }
        if (StructureOutputFile.values().filter { it.name == o.extension().toLowerCase() }.any().not()) {
            return false
        }
        return super.validate()
    }

    override fun build(): String {
        return listOf(
            command(),
            "-f $f",
            "-o $o",
            "-ff ${ff.name.replace("_", "-")}",
            "-ss ${ss.option()}",
            "-ter ${ter.option()}",
            "-lys ${lys.option()}",
            "-arg ${arg.option()}",
            "-asp ${asp.option()}",
            "-glu ${glu.option()}",
            "-gln ${gln.option()}",
            "-his ${his.option()}",
            "-ignh ${ignh.option()}",
            "-water $water",
            "-merge $merge"
        ).joinToString(" ")
    }
}

fun main() {
    val build = Pdb2gmx(
        f = "5TNT_ALL.pdb",
        o = "5TNT.gro",
        ff = ForceField.gromos53a6,
        ignh = true,
        ter = true,
        ss = true,
        water = Water.spc,
        merge = Merge.all
    ).build()
    println(build)
}