import kotlin.random.Random

fun main() {
    try{
    val cabinas = mutableListOf<Cabina>()
    var empresa: Empresa? = null
    var continueCalls = true

    while (continueCalls) {
        println("¿Desea agregar una cabina? (si/no)")
        val respuestaAgregar = readLine()
        if (respuestaAgregar.equals("si", ignoreCase = true)) {
            val nuevaCabina = Cabina()
            cabinas.add(nuevaCabina)
            println("Cabina ${cabinas.size} agregada.")
            empresa = Empresa(cabinas.toTypedArray())
        } else if (cabinas.isEmpty()) {
            println("Debe agregar al menos una cabina para continuar.")
            continue
        }

        // Ciclo para registrar llamadas en cada cabina
        for (i in cabinas.indices) {
            var tipoLlamada: TipoLlamada? = null
            while (tipoLlamada == null && continueCalls) {
                println("Registrando llamada en cabina ${i + 1}")
                println("Seleccione el tipo de llamada \n1: Local\n2: Larga Distancia\n3: Celular\n4: Cerrar el chuzo\n5: Reiniciar cabina:")
                tipoLlamada = when (readLine()?.toIntOrNull()) {
                    1 -> TipoLlamada.local
                    2 -> TipoLlamada.largaDistancia
                    3 -> TipoLlamada.celular
                    4 -> {
                        continueCalls = false
                        null
                    }
                    5 -> {
                        empresa?.reiniciarCabina(i + 1) // Reiniciar la cabina seleccionada
                        null
                    }
                    else -> {
                        println("Seleccione una opción válida.")
                        null
                    }
                }
            }

            if (!continueCalls) break

            // Duración de la llamada
            val duracionLlamada = Random.nextInt(1, 100)
            println("La llamada duró $duracionLlamada minutos")

            /* Registrar la llamada si el tipo es válido */
            tipoLlamada?.let { empresa?.registrarLlamada(i + 1, it, duracionLlamada) }
        }
    }

    /* Mostrar el consolidado total de la empresa antes de reiniciar cabinas */
    println("Consolidado total de la empresa antes de reiniciar cabinas:")
    empresa?.mostrarConsolidado()

    // Mostrar la información detallada de todas las cabinas
    for (i in cabinas.indices) {
        println("Información detallada de la cabina ${i + 1}:")
        empresa?.mostrarInfoCabina(i + 1)
    }
    }catch (e: Exception){
        println("Error: ${e.message}")
    }
}