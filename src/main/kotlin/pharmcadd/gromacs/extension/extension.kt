package pharmcadd.gromacs.extension

internal fun String.extension(): String {
    return this.substringAfterLast(".", "")
}

internal fun Boolean.option(): String {
    return if (this) "" else "no"
}