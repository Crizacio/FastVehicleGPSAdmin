# FastVehicleGPSAdmin
Aplicación para la administración de GPS para vehículos  

## ¿Qué es?
En un alarde de originalidad, FastVehicleGPSAdmin es un administrador para sistemas GPS de vehículos. Con él puedes controlar ciertos comandos.  

 - **Escuchar On-Board**: Envía un mensaje (`listen<codigo>`) al dispositivo GPS para realizar una llamada y así poder escuchar el interior del vehículo a través del micrófono incorporado.  
 - **Cortacorriente Rápido**: Permite el comando `quickstop<codigo>` al dispositivo GPS para realizar el corte de suministro total para inmovilizar el vehículo.
 - **Cortacorriente Seguro**: Envía el comando `noquickstop<codigo>` para que el GPS realice la inmovilización cuando el vehículo se encuentre a una velocidad no más de 20Km/h.
 - **Activar Inmovilizar**: Envía el comando `stop<codigo>` al GPS para bloquear el vehículo hasta nuevo aviso.
 - **Desactivar Inmovilizar**: Envía el comando `resume<codigo>` al GPS para desbloquear el vehículo.
 - Obtener Ubicación: Envía el comando `position<codigo>` al GPS para que este responda con la ubicación precisa del vehículo.

### Configuración
Al iniciar por primera vez, deberás realizar la configuración inicial:  

 1. Ingresa el número telefónico del GPS en la casilla `Número`.
 2. Ingresa el código del GPS en la casilla `Código`.
 3. Sale de la aplicación. Deberías ver un mensaje diciendo `"Se ha guardado la configuracion"`. Vuelve a entrar y deberían estar los datos ingresados.
 4. Listo, ya puedes comenzar a usar la aplicación.


### Permisos requeridos
Esta aplicación móvil requiere de los siguientes permisos:

 1. Envió de mensajes SMS:
	```xml
	<uses-permission android:name="android.permission.SEND_SMS"/>
	```
 2. Recepción de mensajes SMS:
	```xml
	<uses-permission android:name="android.permission.SEND_SMS"/>
	```



## Vida útil
Soporte activo: seguimos tratando de mejorar esta aplicación. ¡Haz tus contribuciones!  

### Privacidad
Esta aplicación NO recopila NI envía información.
