package com.company;

import java.time.LocalDate;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

public class DNRPA {

    private List<RegistroSeccional> registrosSeccionales = new LinkedList<>();
    private Integer idRegistroNuevo = 1;
    private List<Vehiculo> todosLosCamiones = new LinkedList<>();
    private List<Vehiculo>todosLosVehiculosDelPais = new LinkedList<>();
    private LocalDate fechaActual = LocalDate.now();
    private Boolean isMenu = true;
    Scanner scanner = new Scanner(System.in);
    Integer opcion;
    RegistroSeccional seccional;

    public void iniciarMenu() {
        System.out.println();
        System.out.println("Bienvenido a la");
        System.out.println("DIRECCION NACIONAL REGISTRO DE LA PROPIEDAD DEL AUTOMOTOR");
        System.out.println("de la Republica Argentina");
        System.out.println();

        do{
        System.out.println("Por favor, elija una opción: ");
        System.out.println("1 - Cargar datos de los registros seccionales ");
        System.out.println("2 - Listar todos los vehículos de la República Argentina");
        System.out.println("3 - Listar AUTOS de todos los Registros Seccionales");
        System.out.println("4 - Listar PROPIETARIOS DE CAMIONES en orden alfabético");
        System.out.println("5- Cambiar propietario de un vehículo registrado");
        System.out.println("6- Consultar la ANTIGÜEDAD de alta de los vehículos");
        System.out.println("7- Consultar FECHAS de cambio de propietario");
        System.out.println("0 - Salir");

            opcion = scanner.nextInt();

            switch (opcion){
                //TODO prueba:
                case 1 : cargarDatosIniciales();
                    break;
                case 2: listarTodosLosVehiculosDelPais();
                break;
                case 3: listarTodosLosAutos();
                break;
                case 4: listarTodosLosCamiones();
                break;
                case 5: //cambiarPropietario();
                break;
                case 6: //consultarAntiguedad();
                break;
                case 7: //consultarFechaCambioPropietario();
                break;
                case 0:
                    System.out.println("Gracias por haber utilizado el Sistema DNRPA");
                    isMenu = false;
                break;
                default:
                    System.out.println("Ingrese una opcion correcta");
            }
        }while (isMenu);

    }

    //TODO Borrar: método de prueba
    private void cargarDatosIniciales() {
        seccional = crearNuevoRegistroSeccional();
        agregarRegistroSeccional(seccional);
        seccional.darAltaPropietario(new Persona("Seba"));
        List<Persona> autorizados = new ArrayList<>(Arrays.asList(
                new Persona("Juan"),
                new Persona("Jazmin"),
                new Persona("Lucia")
        ));
        seccional.darAltaAutorizados(autorizados);

        Auto auto1;
        auto1 = new Auto (
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculo(auto1);

        seccional.darAltaPropietario(new Persona("Vivian"));
        autorizados = new ArrayList<>(Arrays.asList(
                new Persona("Nora"),
                new Persona("Pedro")
        ));
        seccional.darAltaAutorizados(autorizados);

        Auto auto2;
        auto2 = new Auto (
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario());
        seccional.darAltaVehiculo(auto2);

        seccional = crearNuevoRegistroSeccional();
        agregarRegistroSeccional(seccional);

        seccional.darAltaPropietario(new Persona("Wilfredo"));
        autorizados = new ArrayList<>(Arrays.asList(
                new Persona("Rosa"),
                new Persona("Vilma"),
                new Persona("Roberto")
        ));
        seccional.darAltaAutorizados(autorizados);

        Camion camion1;
        camion1 = new Camion(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculo(camion1);

        seccional.darAltaPropietario(new Persona("Anastasia"));

        Moto moto1;
        moto1 = new Moto(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario());
        seccional.darAltaVehiculo(moto1);

        seccional.darAltaPropietario(new Persona("Tomas"));

        AutoElectrico autoElectrico1;
        autoElectrico1 = new AutoElectrico(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculo(autoElectrico1);

        seccional = crearNuevoRegistroSeccional();
        agregarRegistroSeccional(seccional);

        seccional.darAltaPropietario(new Persona ("Maria"));
        autorizados = new ArrayList<>(Arrays.asList(
                new Persona("Tito"),
                new Persona("Ana")
        ));
        seccional.darAltaAutorizados(autorizados);

        Camion camion2;
        camion2 = new Camion(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario());
        seccional.darAltaVehiculo(camion2);

        AutoElectrico autoElectrico2;
        autoElectrico2 = new AutoElectrico(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario(),
                seccional.getAutorizados());

        seccional.darAltaVehiculo(autoElectrico2);

        seccional.darAltaPropietario(new Persona("Silvio"));

        Utilitario utilitario;
        utilitario = new Utilitario(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario());
        seccional.darAltaVehiculo(utilitario);

        System.out.println("Los datos han sido cargados.");
        System.out.println();
    }

    private RegistroSeccional crearNuevoRegistroSeccional() {
        seccional = new RegistroSeccional(idRegistroNuevo);
        idRegistroNuevo++;
        return seccional;
    }

    private void agregarRegistroSeccional(RegistroSeccional registroSeccional) {
        registrosSeccionales.add(registroSeccional);
    }


    private Integer obtenerCantidadRegistrosSeccionales() {
        return registrosSeccionales.size();
    }

    private List<RegistroSeccional> getRegistrosSeccionales() {
        return registrosSeccionales;
    }


    public void agregarATodosLosCamiones(Vehiculo v) {
        todosLosCamiones.add(v);
    }

    private void agregarATodosLosVehiculosDelPais() {
        for (RegistroSeccional rs : getRegistrosSeccionales()) {
            for (Vehiculo vehiculo : rs.getVehiculos()) {
                todosLosVehiculosDelPais.add(vehiculo);
            }
        }
    }

    public void listarTodosLosVehiculosDelPais() {
        agregarATodosLosVehiculosDelPais();
        System.out.println();
        System.out.println("Listado de TODOS LOS VEHICULOS de todas las seccionales");
        System.out.println("Cantidad de registros: " + obtenerCantidadRegistrosSeccionales());
        System.out.println("-------------------------------------------------------------------------");
        for (RegistroSeccional r : getRegistrosSeccionales()) {
            System.out.println("Registro Seccional Nro.: " + r.getIdRegistroSeccional());
            for (Vehiculo v : r.getVehiculos()) {
                System.out.println("Patente: " + v.patente);
                System.out.println("Tipo de Vehiculo: " + v.getClass().getSimpleName());
                System.out.println("Fecha de Alta: "+ v.fechaDeAlta);
                System.out.println();
            }
        }
    }

    public void listarTodosLosAutos() {
        System.out.println("Listado de AUTOS de todos los Registros Seccionales:");
        System.out.println("-------------------------------------------------------------------------");

        Integer contador = 0;
        System.out.println();

        for (Vehiculo elVehiculo : todosLosVehiculosDelPais) {

            if (elVehiculo instanceof Auto) {
                Auto auto = (Auto) elVehiculo;
                listarauto(auto);
                contador ++;
            } else if (elVehiculo instanceof AutoElectrico) {
                AutoElectrico auto = (AutoElectrico) elVehiculo;
                listarauto(auto);
                contador ++;
            }
        }
        System.out.println();
        System.out.println("Cantidad de autos: " + contador);
    }

    private void listarauto(Vehiculo auto) {
        System.out.println("Registro Seccional Nro.: " + auto.idRegistroSeccional);
        System.out.println("Patente: " + auto.patente);
        System.out.println("Tipo de auto: " + auto.getClass().getSimpleName());
        System.out.println("Uso: " + auto.uso);
        System.out.println("Fecha de alta en el Registro: " + auto.fechaDeAlta);
        System.out.println("Propietario: " + auto.propietario.getNombre());
        if (auto.autorizados != null) {
            System.out.print("Autorizados a manejar el auto: ");
            for (Persona p : auto.autorizados) {
                System.out.print("/ " + p.getNombre());
            }
            System.out.println();
        } else {
            System.out.println("El auto no tiene autorizados asignados");
        }
        if (auto.fechaCambioPropietario != null) {
            System.out.println("Fecha de transferencia a otro propietario: " + auto.fechaCambioPropietario);
        }
        System.out.println();
    }

    public void listarTodosLosCamiones() {

        System.out.println("Listado de PROPIETARIOS de CAMIONES de todos los Registros Seccionales:");
        Collections.sort(todosLosCamiones, (o1, o2) -> o1.propietario.getNombre().compareTo(o2.propietario.getNombre()));
        System.out.println("Cantidad de camiones: " + todosLosCamiones.size());
        for (Vehiculo camion : todosLosCamiones) {
            System.out.println();
            System.out.println("Propietario: " + camion.propietario.getNombre());
            System.out.println("Patente: " + camion.patente);
            System.out.println("Registro Seccional Nro.: " + camion.getIdRegistroSeccional());
            if (camion.autorizados != null) {
                System.out.print("Autorizados a manejar el camion: ");
                for (Persona p : camion.autorizados) {
                    System.out.print("/ " + p.getNombre());
                }
                System.out.println();
            } else {
                System.out.println("El camion no tiene autorizados asignados");
            }
            System.out.println("Tipo de Vehiculo: " + camion.getClass().getSimpleName());
            System.out.println("Uso: " + camion.uso);
            System.out.println("Fecha de alta en el Registro: " + camion.fechaDeAlta);
            if (camion.fechaCambioPropietario != null) {
                System.out.println("Fecha de transferencia a otro propietario: " + camion.fechaCambioPropietario);
            }
            System.out.println();
        }
    }

    //Opcional 3: Los automotores pueden cambiar de propietario.
    //Opcional 4: Se debe registrar la fecha de cambio de propietario.

    public void cambiarPropietario(Vehiculo v, Persona nuevoPropietario) {
        Boolean isCambiado = false;
        for (Vehiculo elVehiculo : todosLosVehiculosDelPais
        ) {
            if (elVehiculo.patente == v.patente) {
                v.propietario = nuevoPropietario;
                //v.fechaCambioPropietario = this.fechaActual;
                //se prueba mostrar != fechas de cambio de propietario
                //v.fechaCambioPropietario = LocalDate.of(2020,05,01);
                v.fechaCambioPropietario = LocalDate.of(2019,05,01);

                isCambiado = true;
                break;
            }
        }
        System.out.println("-------------------------------------------------------------------------");
        if (isCambiado) {
            System.out.println("El propietario del vehiculo con patente: " + v.patente + " ha sido actualizado");
            System.out.println("Se encuentra en el Registro Seccional Nro.: " + v.getIdRegistroSeccional());
            System.out.println("El nuevo propietario es: " + v.propietario.getNombre());
            System.out.println("La fecha de cambio es: " + v.fechaCambioPropietario);
        } else {
            System.out.println("No se ha encontrado el vehiculo para cambiar el propietario.");
        }
    }

    //Opcional 5:Se puede consultar si pasó un año o mas desde el registro o cambio de titular para un auto y
    //la consulta se realiza por patente.

    private Long consultarDiasDesdeElAltaDelVehiculo(Vehiculo v) {
        Long diasDesdeAlta = null;
        for (Vehiculo elVehiculo : todosLosVehiculosDelPais) {
            if (elVehiculo.patente == v.patente)
                diasDesdeAlta = DAYS.between(elVehiculo.fechaDeAlta, fechaActual);
        }return diasDesdeAlta;
    }

    private Long consultarDiasDesdeCambioDePropietarioDelVehiculo(Vehiculo v) {
        Long diasDesdeCambio = null;
        for (Vehiculo elVehiculo : todosLosVehiculosDelPais) {
            if (elVehiculo.patente == v.patente)
                if (elVehiculo.fechaCambioPropietario != null)
                    diasDesdeCambio = DAYS.between(elVehiculo.fechaCambioPropietario, fechaActual);
            break;
        }return diasDesdeCambio;
    }

    public void consultarAntiguedadAltaVehiculo(Vehiculo v) {
        Long diasDesdeAlta = consultarDiasDesdeElAltaDelVehiculo(v);
        System.out.println("-------------------------------------------------------------------------");
        if (diasDesdeAlta == null) {
            System.out.println("El vehículo con patente " + v.patente + " fue dado de alta hoy");
        } else {
            System.out.println("Patente Nro.: "+v.patente);
            if (diasDesdeAlta > 360) {
                System.out.println("Hace " + diasDesdeAlta + " dias se dio de alta y ya pasó el año.");
            } else {
                System.out.println("Hace " + diasDesdeAlta + " dias se dio de alta y todavia no pasó el año.");
            }
        }
    }

    public void consultarAntiguedadCambioPropietario(Vehiculo v) {
        Long diasDesdeCambio = consultarDiasDesdeCambioDePropietarioDelVehiculo(v);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Patente Nro.: "+v.patente);
        if(v.fechaCambioPropietario == null) {
            System.out.println("El vehiculo no cambio de propietario nunca.");
        }else if(diasDesdeCambio == null){
            System.out.println("El vehículo con patente "+v.patente+" cambio hoy de propietario");
        } else {
            if (diasDesdeCambio > 360) {
                System.out.println("Hace " + diasDesdeCambio + " días cambió de propietario, ya pasó el año.");
            } else {
                System.out.println("Hace " + diasDesdeCambio + " dias cambio de propietario y todavia no pasó el año.");
            }
        }
    }
}
