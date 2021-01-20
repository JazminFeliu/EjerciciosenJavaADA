package com.company;

public class Main {

    public static void main(String[] args) {
	// felix es un Gato

        Gato felix = new Gato();

        // felix tiene 4 patas
        felix.setPatas(3);



        Gato gardfield = new Gato();
        gardfield.setPatas(4);

        //todos los gatos tienen 2 ojos
        System.out.println("Felix tiene "+felix.getPatas()+" patas");
        System.out.println("Gardfiel tiene" +gardfield.getPatas()+" patas");
        System.out.println("Cuantos ojos tiene un gato? "+Gato.getOjos());

        Gato.setOjos(3);
        System.out.println("Ojos "+Gato.getOjos());

        System.out.println("Felix, cuantos ojos tenes? "+Gato.getOjos());

        gardfield.setOjos(8);
        System.out.println("Garfield tiene "+gardfield.getOjos()+" ojos");
        System.out.println("Felix tiene "+felix.getOjos()+" ojos");

        Gato salem = new Gato();
        System.out.println("Salem, cuantos ojos tenes? "+salem.getOjos());

        if(salem.isConCola()){
            System.out.println("Salem tiene cola");
        }else{
            System.out.println("Salio mal");
        }
    }


}
