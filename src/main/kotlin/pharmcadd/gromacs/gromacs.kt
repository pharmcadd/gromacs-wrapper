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

    // 멤브레인인 경우에는 벡터 좌표가 따로 들어 가기 때문에 아무 값이나 들어 가도 상관없다고 한다. by 이상백 박사님
    // 솔루션인 경우에는......? 솔루션 빌더 붙일 때 확인
    complex.add(lig.last())
    return complex.joinToString("\n")
}