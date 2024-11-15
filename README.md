# Descripción del Proyecto

Este proyecto es una aplicación Android que gestiona una lista de novelas. Incluye características para marcar novelas como favoritas y mostrarlas en un widget dentro de un fragmento. El proyecto utiliza Kotlin, Firebase Firestore para el almacenamiento de datos y Firebase Authentication para la gestión de usuarios.

---

## Clases y sus Funciones

### **MainActivity.kt**

- **Propósito**: Punto de entrada principal de la aplicación.
- **Funciones Clave**:
  - `onCreate`: Inicializa la actividad, configura la barra de herramientas y maneja la autenticación de Firebase con credenciales fijas.

### **NovelListFragment.kt**

- **Propósito**: Muestra una lista de novelas y una lista de novelas favoritas.
- **Funciones Clave**:
  - `onCreateView`: Infla el diseño del fragmento e inicializa SharedPreferences.
  - `onViewCreated`: Configura los RecyclerViews y carga las novelas y las novelas favoritas.
  - `setupRecyclerView`: Configura los RecyclerViews para las novelas y las novelas favoritas.
  - `loadNovelas`: Obtiene la lista de novelas desde Firestore.
  - `loadFavoriteNovelas`: Obtiene la lista de novelas favoritas desde SharedPreferences.
  - `toggleFavorite`: Alterna el estado de favorito de una novela y actualiza SharedPreferences.

### **FirestoreRepository.kt**

- **Propósito**: Gestiona las interacciones con Firebase Firestore.
- **Funciones Clave**:
  - `agregarNovela`: Añade una nueva novela a Firestore.
  - `obtenerNovelas`: Recupera la lista de novelas desde Firestore.
  - `actualizarNovela`: Actualiza una novela en Firestore.
  - `agregarResena`: Añade una reseña a una novela.
  - `eliminarResena`: Elimina una reseña de una novela.
  - `obtenerResenas`: Recupera la lista de reseñas desde Firestore.
  - `getUserId`: Recupera el ID del usuario actual desde Firebase Authentication.

### **SharedPreferences.kt**

- **Propósito**: Gestiona las preferencias del usuario, específicamente la lista de novelas favoritas.
- **Funciones Clave**:
  - `saveUserFavoriteNovels`: Guarda la lista de novelas favoritas para un usuario.
  - `getUserFavoriteNovels`: Recupera la lista de novelas favoritas para un usuario.

### **NovelasAdapter.kt**

- **Propósito**: Adaptador para mostrar la lista de novelas en un RecyclerView.
- **Funciones Clave**:
  - `submitList`: Actualiza la lista de novelas.
  - `NovelaViewHolder`: Vincula los datos de la novela a la vista del elemento del RecyclerView y maneja el clic del botón de favorito.

### **FavoriteNovelasAdapter.kt**

- **Propósito**: Adaptador para mostrar la lista de novelas favoritas en un RecyclerView.
- **Funciones Clave**:
  - `FavoriteNovelaViewHolder`: Vincula los datos de la novela favorita a la vista del elemento del RecyclerView y maneja el clic del botón de favorito.

### **FirebaseAuthHelper.kt**

- **Propósito**: Gestiona la autenticación de Firebase.
- **Funciones Clave**:
  - `signIn`: Inicia sesión con credenciales fijas.

### **Novela.kt**

- **Propósito**: Clase de datos que representa una novela.
- **Propiedades Clave**:
  - `id`, `nombre`, `autor`, `anio_publicacion`, `descripcion`, `resenas`, `isFavorita`.

### **Resenas.kt**

- **Propósito**: Clase de datos que representa una reseña.
- **Propiedades Clave**:
  - `novelaId`, `nombre`, `contenido`, `userId`.

---

## Funcionalidad del Widget y Fragmento

### **Widget**

- **Propósito**: Muestra la lista de novelas favoritas.
- **Implementación**: El widget es un RecyclerView dentro del diseño de `NovelListFragment`.
- **Componentes Clave**:
  - `recyclerViewFavoriteNovelas`: El RecyclerView que muestra las novelas favoritas.
  - `FavoriteNovelasAdapter`: El adaptador que vincula los datos de las novelas favoritas al RecyclerView.

### **Fragmento**

- **Propósito**: Muestra la lista principal de novelas y la lista de novelas favoritas.
- **Implementación**: El fragmento está definido en `NovelListFragment.kt` y su diseño está en `fragment_novel_list.xml`.
- **Componentes Clave**:
  - `recyclerViewNovelas`: El RecyclerView que muestra la lista principal de novelas.
  - `recyclerViewFavoriteNovelas`: El RecyclerView que muestra la lista de novelas favoritas.
  - `NovelasAdapter`: El adaptador que vincula los datos de las novelas al RecyclerView.
  - `FavoriteNovelasAdapter`: El adaptador que vincula los datos de las novelas favoritas al RecyclerView.

---

## Nota sobre la Funcionalidad de los Botones

Los botones para marcar novelas como favoritas están incluidos en el diseño pero no funcionan como se espera. Esto es intencional, ya que el enfoque de la práctica está en la implementación del fragmento y el widget en lugar de la funcionalidad de los botones.

link al repositorio: https://github.com/cosmxr/FragmentFinal.git
