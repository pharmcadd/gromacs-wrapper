import org.junit.jupiter.api.Test
import pharmcadd.gromacs.combineProteinLigand

class GroTest {

    @Test
    fun combineProteinLigandTest() {
        val prot = GroTest::class.java.getResourceAsStream("/prot.gro").bufferedReader().readText()
        val lig = GroTest::class.java.getResourceAsStream("/lig.gro").bufferedReader().readText()
        val complex = combineProteinLigand(prot, lig)
        println(complex)
    }
}
