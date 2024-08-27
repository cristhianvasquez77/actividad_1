data class Cabina(
    var numeroLlamadas: Int = 0,
    var duracionTotal: Int = 0,
    var costoTotal: Int = 0
) {
    fun registrarLlamada(tipoLlamada: TipoLlamada, duracion: Int) {
        numeroLlamadas++
        duracionTotal += duracion
        costoTotal += when (tipoLlamada) {
            TipoLlamada.local -> duracion * 50
            TipoLlamada.largaDistancia -> duracion * 350
            TipoLlamada.celular -> duracion * 150
        }
    }

    fun reiniciar() {
        numeroLlamadas = 0
        duracionTotal = 0
        costoTotal = 0
    }
}
