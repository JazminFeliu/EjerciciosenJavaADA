package com.company;

public class Gato {

    private int patas;

    //atributo de la clase, se escribe con el static
    private static int ojos = 2;
    // si quiero que sea constante y no cambie nunca, uso private static final int ojos = 0;
    private static final boolean conCola = true ;

    public static boolean isConCola(){
        return conCola;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    public static int getOjos() {
        return ojos;
    }

    public static void setOjos(int ojos) {
        Gato.ojos = ojos;
    }

    public int getPatas(){
        return patas;
    }
}
