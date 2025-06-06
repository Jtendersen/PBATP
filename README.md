# TP Programación Básica (PBATP)

Este repositorio contiene el proyecto Java/NetBeans “PBATP” (Práctico de Programación Básica). A continuación vas a encontrar instrucciones paso a paso para **clonar** el repositorio y **abrirlo/ejecutarlo** en NetBeans, suponiendo que no tenemos mucha exp con Git y NetBeans.

---

## 📋 Pre-requisitos

Antes de empezar, asegurate de tener instalado y configurado lo siguiente:

1. **Java JDK 8 (o superior)**  
   - Verificá que esté instalado abriendo una terminal o consola y ejecutando:
     ```bash
     java -version
     ```
     Debería responder algo como `java version "1.8.0_xxx"` o similar.  
   - Si no lo tenés instalado, descargalo e instalalo desde [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) o [AdoptOpenJDK](https://adoptopenjdk.net/).

2. **Apache NetBeans (IDE) 12.x o superior**  
   - Descargalo desde https://netbeans.apache.org/download/index.html  
   - Instalalo siguiendo las instrucciones correspondiente a tu sistema operativo (Windows, Linux o macOS).

3. **Git**  
   - Permite clonar repositorios remotos (GitHub) a tu computadora local.  
   - En Windows podés instalar [Git for Windows](https://gitforwindows.org/).  
   - En Linux/Mac lo instalás con tu administrador de paquetes (`sudo apt install git`, `brew install git`, etc.).  
   - Verificá la instalación con:
     ```bash
     git --version
     ```
     Esto debería mostrar algo como `git version 2.x.x`.

---

## 📥 1. Clonar el repositorio desde GitHub

1. Abrí tu navegador web y andá a la URL del repositorio:
   https://github.com/Jtendersen/PBATP.git
2. Hacé clic en el botón **Code** → **HTTPS** → **Copy** (o copiate la URL):
   https://github.com/Jtendersen/PBATP.git
3. Abrí una terminal o consola en tu compu y navegá hasta la carpeta donde quieras clonar el proyecto. Por ejemplo:
```bash
cd C:\Users\TuUsuario\Documentos\Proyectos\
```
(En Linux/Mac sería algo como cd /home/tuusuario/Proyectos/.)

4. Ejecutá el comando para clonar:
```bash
git clone https://github.com/tu-usuario/PBATP.git
```
Con esto, se va a crear una carpeta llamada PBATP en tu ruta actual, que contendrá todos los archivos del proyecto.
5. Cuando termine el proceso de clonación, metete adentro de la carpeta creada:
```bash
cd PBATP
```
Ahí vas a ver subcarpetas como nbproject/, src/ y el archivo .gitignore.

---

## 📂 2. Estructura principal del proyecto
Dentro de PBATP/ vas a encontrar esta estructura:
```css
PBATP/
├─ nbproject/              ← Archivos de configuración internos de NetBeans
├─ src/
│   └─ PBATP/              ← Carpeta paquete “PBATP” (todas las clases .java acá)
│       ├─ Enemigo.java
│       ├─ Guardia.java
│       ├─ Juego.java
│       ├─ Main.java
│       ├─ MetalGear.java
│       ├─ Personaje.java
│       ├─ Posicion.java
│       └─ Snake.java
├─ .gitignore              ← Listado de archivos/carpetas que Git ignora
└─ README.md               ← Este archivo de instrucciones
```
- nbproject/: NetBeans guarda acá la configuración del proyecto (no lo modifiques a mano).

- src/PBATP/: Todas las clases Java pertenecen al paquete PBATP. Cada archivo .java arranca con package PBATP;.

- .gitignore: Contiene patrones de archivos y carpetas que no deben subirse a Git (carpetas de compilación, archivos .class, archivos de configuración privados, etc.).

- README.md: Este documento con todas las instrucciones.

---

## 🚀 3. Abrir el proyecto en NetBeans
1. Abrí Apache NetBeans.
2. En el menú principal, seleccioná:
   ```mathematica
   File → Open Project…
   ```
(O presioná Ctrl+Shift+O en Windows/Linux, o ⌘+Shift+O en macOS.)
3. En la ventana de diálogo, buscá y seleccioná la carpeta donde clonaste este repositorio. Por ejemplo:
```makefile
C:\Users\TuUsuario\Documentos\Proyectos\PBATP
```
NetBeans debería detectar automáticamente que es un proyecto Java. Vas a ver un iconito con el nombre “PBATP”. Seleccionalo y hacé clic en Open Project.
4. Ahora, en el panel izquierdo (Projects), vas a ver algo así:
```nginx
PBATP
├─ Source Packages
│   └─ PBATP
│       ├─ Enemigo.java
│       ├─ Guardia.java
│       ├─ Juego.java
│       ├─ Main.java
│       ├─ MetalGear.java
│       ├─ Personaje.java
│       ├─ Posicion.java
│       └─ Snake.java
├─ Test Packages   (vacío, no lo usamos por ahora)
└─ nbproject/
```

---

## ▶️ 4. Compilar y ejecutar el proyecto
1. Asegurate de que no haya errores de compilación (íconos rojos) en ninguna de las clases. Si el paquete PBATP y la carpeta src/PBATP/ coinciden, NetBeans va a compilar sin problemas.
2. Para ejecutar la aplicación, buscá Main.java en:
```css
PBATP → Source Packages → PBATP → Main.java
```
Hacé clic derecho sobre Main.java → Run File (o presioná Shift+F6).
- NetBeans va a compilar todo de nuevo (si hace falta) y después mostrará la salida en una ventana de consola.
- Tu clase Main tiene que tener un método public static void main(String[] args) para que arranque la aplicación.
3. Otra manera para ejecutar el proyecto completo es:
- Hacé clic derecho en el nodo raíz “PBATP” (en el panel Projects) → Run.
- NetBeans va a buscar la “Main Class” que esté configurada en:
  ```mathematica
  Right-click en PBATP → Properties → Run → Main Class
  ```
  Ahí debe aparecer ```PBATP.Main```.
  - Si no está definida, hacé clic en Browse…, elegí PBATP → Main y guardá la configuración.
4. Cada vez que guardes cambios en tus clases, NetBeans va a recompilar automáticamente al momento de ejecutar de nuevo.

---

## 📌 5. Resumen de comandos Git básicos (opcional)
Si querés manejar Git desde la terminal, estos son los comandos principales:

1. Ver status
```bash
git status
```
Te muestra los archivos modificados, sin trackear, commits pendientes, etc.
2. Agregar cambios al área de staging
```bash
git add <ruta/al/archivo>    # Ejemplo: git add src/PBATP/Main.java
git add .                    # Agrega todos los archivos modificados/no trackeados
```
3. Confirmar cambios (commit) ---> Sacás una "foto" de tu local
```bash
git commit -m "Mensaje breve y descriptivo de lo que hiciste"
```
4. Enviar (push) los commits al remoto
```bash
git push origin main
```
5. Actualizar tu copia local con cambios del repositorio remoto
```bash
git pull origin main
```

---

## 📝 6. Buenas prácticas para principiantes
- No modifiques la carpeta nbproject/ a mano. NetBeans la administra sola.
- Trabajá siempre dentro de src/PBATP/. Ahí van todas tus clases .java.
- Antes de empezar a programar, hacé un git pull para tener siempre la última versión del equipo.
- Si querés desarrollar una nueva funcionalidad o corregir un bug, creá una rama distinta:
```bash
git checkout -b mi-rama-nueva
```
Después, cuando terminás tu tarea, hacés un pull request en GH para integrarla a la rama principal (que podemos revisarlo el resto de los devs).
- Usá mensajes de commit claros y cortos, por ejemplo:
```sql
git commit -m "Agregada la lógica de detección en Guardia"
```

---

## 🎓 ¿Cómo seguimos?
- Cuando agregues nuevas clases, métodos o recursos (imágenes, archivos de texto, etc.), guardalos dentro de src/ (o sus subcarpetas) y hacé:
```bash
git add .
git commit -m "Breve descripción de lo que agregaste"
git push
```
- Si alguno de nosotros sube cambios nuevos al repositorio remoto, vos podés sincronizarte con:
```bash
git pull origin main
```
