# 💱 Conversor de Monedas

Aplicación en Java que permite convertir entre diferentes monedas usando la API de ExchangeRate-API.

## 📋 Requisitos

- Java 11 o superior
- Cuenta en [ExchangeRate-API](https://www.exchangerate-api.com/) (gratuita)
- Biblioteca Gson 2.10.1

## 🚀 Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/conversor-monedas.git
cd conversor-monedas
```

### 2. Configurar la API Key

**IMPORTANTE**: Nunca compartas tu API Key públicamente.

#### En Windows:
```cmd
set EXCHANGE_RATE_API_KEY=tu_api_key_aqui
```

#### En Linux/Mac:
```bash
export EXCHANGE_RATE_API_KEY=tu_api_key_aqui
```

#### Forma permanente (Linux/Mac):
Agrega al archivo `~/.bashrc` o `~/.zshrc`:
```bash
export EXCHANGE_RATE_API_KEY=tu_api_key_aqui
```

#### Forma permanente (Windows):
1. Abre "Variables de entorno del sistema"
2. Crea una nueva variable de usuario
3. Nombre: `EXCHANGE_RATE_API_KEY`
4. Valor: tu API key

### 3. Descargar Gson

Descarga Gson desde [Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1) y colócalo en la carpeta `lib/`

### 4. Compilar

```bash
javac -cp lib/gson-2.10.1.jar src/**/*.java src/*.java
```

### 5. Ejecutar

```bash
# Linux/Mac
java -cp .:lib/gson-2.10.1.jar Main

# Windows
java -cp .;lib/gson-2.10.1.jar Main
```

## 🎯 Funcionalidades

- Conversión entre USD, COP, ARS, BRL
- Conversión personalizada entre cualquier par de monedas
- Muestra la tasa de cambio actual
- Interfaz de consola interactiva

## 📁 Estructura del Proyecto

```
ConversorMonedas/
├── src/
│   ├── modelos/
│   │   ├── Moneda.java
│   │   └── RespuestaAPI.java
│   ├── servicios/
│   │   └── ServicioAPI.java
│   └── Main.java
├── lib/
│   └── gson-2.10.1.jar
├── .gitignore
└── README.md
```

## 🔒 Seguridad

- ✅ La API Key se maneja mediante variables de entorno
- ✅ El archivo `.gitignore` protege información sensible
- ❌ Nunca subas tu API Key al repositorio

## 📝 Monedas Soportadas

El conversor soporta todas las monedas disponibles en ExchangeRate-API, incluyendo:
- USD (Dólar estadounidense)
- EUR (Euro)
- COP (Peso colombiano)
- ARS (Peso argentino)
- BRL (Real brasileño)
- Y muchas más...

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:
1. Haz fork del proyecto
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -m 'Agrega nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request
