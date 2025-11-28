# Biblioteca Desafío

Este proyecto es una aplicación de consola en Java que permite buscar y analizar información sobre libros utilizando la API de Gutendex. La aplicación proporciona varias funcionalidades, como mostrar los primeros libros encontrados, listar los libros más descargados, buscar libros específicos por nombre y obtener estadísticas sobre las descargas de los libros.

## Funcionalidades

- **Mostrar los primeros 5 libros**: Muestra los primeros cinco libros obtenidos de la API.
- **Top 10 libros más descargados**: Muestra los diez libros con mayor número de descargas.
- **Buscar libros por nombre**: Permite buscar libros específicos por su título.
- **Estadísticas de descargas**: Proporciona estadísticas como la media, el número máximo y mínimo de descargas, y la cantidad total de libros.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes y clases:

- **Principal**: Contiene la clase principal que maneja la lógica de la aplicación.
- **Service**: Contiene las clases `ConsumoAPI` para realizar las llamadas a la API y `ConvierteDatos` para convertir los datos JSON a objetos Java.
- **Model**: Contiene las clases de datos `Datos` y `DatosLibros`.

## Requisitos

- Java 8 o superior


## Uso

1. Ejecuta la aplicación.
    

2. Sigue las instrucciones en la consola para utilizar las diferentes funcionalidades de la aplicación.

## Contribución

Las contribuciones son bienvenidas. Por favor, abre un issue para discutir cualquier cambio importante antes de realizarlo.


%% -----------------------------------------------------------
%%     CONFIGURACIÓN DE ESTILO INSTITUCIONAL
%% -----------------------------------------------------------
%% Colores: 
%%   Azul institucional (#003366)
%%   Gris suave (#F2F2F2 / #E6E6E6)
%%   Líneas sobrias y esquinas redondeadas
%% -----------------------------------------------------------

flowchart TD
    classDef titulo fill:#003366,color:#ffffff,font-weight:bold,stroke:#002244,stroke-width:2;
    classDef paso fill:#F2F2F2,stroke:#003366,stroke-width:1px,color:#000,rounded-corners;
    classDef decision fill:#E6E6E6,stroke:#003366,stroke-width:1.5px,color:#000,stroke-dasharray: 5 5;

    A[INICIO]:::titulo --> B[Ingresar a medellin.gov.co]:::paso

    B --> C[Buscar 'Secretaría de Hacienda'<br>Portal Tributario]:::paso

    C --> D[Buscar 'Actualiza tus Datos' y dar clic<br><b>Ruta alternativa:</b><br>Trámites y Servicios → Secretaría de Hacienda → REALIZAR]:::paso

    D --> E{¿Tiene credenciales de acceso?}:::decision

    E -->|No| F[Registrarse<br>(crear usuario)]:::paso
    E -->|Sí| G[Ingresar credenciales<br>(usuario y contraseña)]:::paso

    F --> H[Visualizar datos actuales]:::paso
    G --> H

    H --> I[Actualizar información:<br>• Dirección notificación ICA<br>• Celular<br>• Teléfono fijo<br>• Correo electrónico]:::paso

    I --> J[Activar autorizaciones:<br>• Factura por email<br>• Notificación por correo<br>• Aceptar Política de Datos]:::paso

    J --> K[Verificar datos ingresados]:::paso

    K --> L{¿Datos correctos?}:::decision

    L -->|No| M[Modificar información]:::paso
    L -->|Sí| N[Clic en 'ACTUALIZAR']:::paso

    M --> K
    N --> O[Sistema confirma actualización exitosa]:::paso

    O --> P[Revisar correo:<br>• Enlace de verificación<br>• Confirmar cambios<br>• Revisar spam]:::paso

    P --> Q[Recibir soporte por email<br>(Secretaría de Hacienda)]:::paso

    Q --> R[FIN]:::titulo


