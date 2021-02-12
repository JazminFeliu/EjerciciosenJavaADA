package com.company;
        /* AdaPlus
                1.Plataforma (main)
                2.Peliculas, series
                3. Series -> Episodios
                4. Peliculas y Episodios tienen duracion y subtítulos.
                5. Subtitulos tienen una lista de idiomas.
                6.Usuarios
                7.Los usuarios tienen una lista de peliculas y series favoritas. Una lista de recomendaciones.
                Una lista llamada "continuar viendo".
                8. Un usuario puede reproducir, pausar, detener, una película o episodio.
                9.Reproducir adelanta 5 minutos el tiempo.

               TIP: un archivo de vide se suele llamar "Medio".
         */

/*
Main Plataforma
    lista de usuarios

clase abstracta Medio implements
    Objeto Serie
    Objeto Pelicula

clase Serie extends Medio
    clase Episodio extends Serie
         Lista de episodios

clase Pelicula
clase Usuario
    lista de peliculas favoritas
    lista de series favoritas
    lista de recomendaciones(series y peliculas mezcladas)
    lista continuar viendo



Interface Idioma
Interface Subtitulo
    lista de idiomas
Interface Reproduccion
metodos reproducir, pausar, detener, elegir (pelicula o serie o episodio)

 */
public class Main {
    public static void main(String[] args) {

        ADAPlus adaplus = new ADAPlus();

    }
}
