﻿# actividad_1
CabinasTelefonicas: esta clase representa una cabina telefónica dentro de una empresa que lleva un registro de llamadas.
numeroLlamadas: almacena el número total de llamadas registradas en la cabina.
duracionTotal: almacena la duración total de todas las llamadas registradas en la cabina.
costoTotal:  almacena el costo total acumulado de todas las llamadas registradas en la cabina. 
Método registrarLlamada: Este método permite registrar una llamada realizada desde la cabina. 
Método reiniciar: Este método se utiliza para reiniciar los valores de la cabina.
-----------------------
TipoLlamada: Un enum class tiene tres posibles valores para indicar el tipo de llamada que se está registrando.
------------------------
Empresa: Administra un conjunto de cabinas telefónicas representadas por instancias de la clase Cabina.
registrarLlamada: Este método permite registrar una llamada en una cabina específica.
mostrarInfoCabina: Este método muestra la información de una cabina específica.
mostrarConsolidado: Este método muestra un resumen total de todas las cabinas en la empresa.
reiniciarCabina: Este método reinicia los valores de una cabina específica.
---------------------------------
Posibles mejoras al codigo 
Podria agregarse que cada cabina muestre cuantas llamadas se realizaron locales, a larga distancia y a celular, para asi generar un promedio estadistico de cuanto puede durar una persona en una llamada.
