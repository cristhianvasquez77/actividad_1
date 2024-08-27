class Empresa(private val cabinas: Array<Cabina>) {

    fun registrarLlamada(numeroCabina: Int, tipoLlamada: TipoLlamada, duracion: Int) {
        if (numeroCabina in 1..cabinas.size) {
            cabinas[numeroCabina - 1].registrarLlamada(tipoLlamada, duracion)
        } else {
            println("Número de cabina inválido.")
        }
    }

    fun mostrarInfoCabina(numeroCabina: Int) {
        if (numeroCabina in 1..cabinas.size) {
            val cabina = cabinas[numeroCabina - 1]
            println("Cabina $numeroCabina:")
            println("Número de llamadas: ${cabina.numeroLlamadas}")
            println("Duración total de llamadas: ${cabina.duracionTotal} minutos")
            println("Costo total: \$${cabina.costoTotal}")
        } else {
            println("Número de cabina inválido.")
        }
    }

    fun mostrarConsolidado() {
        var totalLlamadas = 0
        var totalDuracion = 0
        var totalCosto = 0

        cabinas.forEach { cabina ->
            totalLlamadas += cabina.numeroLlamadas
            totalDuracion += cabina.duracionTotal
            totalCosto += cabina.costoTotal
        }

        val costoPromedioPorMinuto = if (totalDuracion > 0) totalCosto / totalDuracion else 0

        println("Consolidado Total:")
        println("Número total de llamadas: $totalLlamadas")
        println("Duración total de llamadas: $totalDuracion minutos")
        println("Costo total: \$${totalCosto}")
        println("Costo promedio por minuto: \$${costoPromedioPorMinuto}")
    }

    fun reiniciarCabina(numeroCabina: Int) {
        try {
            if (numeroCabina in 1..cabinas.size) {
                cabinas[numeroCabina - 1].reiniciar()
                println("Cabina $numeroCabina reiniciada.")
            } else {
                println("Número de cabina inválido.")
            }
        }catch (e: Exception){
            println("Error: ${e.message}")
        }
    }
}