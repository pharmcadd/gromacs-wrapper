package pharmcadd.gromacs

fun combineProteinLigand(protein: String, ligand: String): String {
    val pro = protein.split("\n").map(String::trimEnd).filter(String::isNotBlank)
    val lig = ligand.split("\n").map(String::trimEnd).filter(String::isNotBlank)
    val total = pro[1].trim().toInt() + lig[1].trim().toInt()

    val complex = mutableListOf<String>()
    complex.add(pro[0])
    complex.add(String.format("%5d", total))
    for (s in pro.subList(2, pro.size - 1)) {
        complex.add(s)
    }
    for (s in lig.subList(2, lig.size - 1)) {
        complex.add(s)
    }
    complex.add(pro.last())
    return complex.joinToString("\n")
}