package com.company;

import java.time.LocalDate;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

public class DNRPA {

    private List<RegistroSeccional> registrosSeccionales = new LinkedList<>();
    private Integer idRegistroNuevo = 1;
    private List<Vehiculo> todosLosCamiones = new LinkedList<>();
    private List<Vehiculo> todosLosVehiculosDelPais = new LinkedList<>();
    private LocalDate fechaActual = LocalDate.now();
    private Boolean isMenu = true;
    private Scanner scanner = new Scanner(System.in);
    private Integer opcion;
    private RegistroSeccional seccional;
    private Random aleatorio = new Random();
    private Vehiculo unVehiculo;

    public void iniciarMenu() {

        System.out.println();
        System.out.println("Bienvenido a la");
        System.out.println("DIRECCION NACIONAL DEL REGISTRO DE LA PROPIEDAD DEL AUTOMOTOR");
        System.out.println("de la Republica Argentina");
        System.out.println();

        do {
            System.out.println();
            System.out.println("Por favor, elija una opción: ");
            System.out.println("1 - Cargar datos de los registros seccionales ");
            System.out.println("2 - Listar todos los vehículos de la República Argentina");
            System.out.println("3 - Listar AUTOS de todos los Registros Seccionales");
            System.out.println("4 - Listar PROPIETARIOS DE CAMIONES en orden alfabético");
            System.out.println("5- Cambiar propietario de un vehículo registrado");
            System.out.println("6- Consultar la ANTIGÜEDAD de alta de los vehículos");
            System.out.println("7- Consultar FECHAS de cambio de propietario");
            System.out.println("8 - Dar de Alta un vehículo");
            System.out.println("0 - Salir");
            System.out.print("Opcion: ");


            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {

                case 1:
                    if (todosLosVehiculosDelPais.size() == 0)
                        cargarDatosIniciales();
                    else
                        System.out.println("Ya se han cargado los registros al sistema.");

                    break;

                case 2:
                    listarTodosLosVehiculosDelPais();
                    break;

                case 3:
                    listarTodosLosAutos();
                    break;

                case 4:
                    listarTodosLosCamiones();
                    break;

                case 5:
                    if (todosLosVehiculosDelPais.size() == 0)
                        System.out.println("El sistema no tiene registros cargados para realizar este cambio");
                    else
                        cambiarPropietario();
                    break;

                case 6:
                    if (todosLosVehiculosDelPais.size() == 0)
                        System.out.println("El sistema no tiene registros cargados para realizar esta consulta");
                    else
                        consultarAntiguedadAltaVehiculo();
                    break;

                case 7:
                    if (todosLosVehiculosDelPais.size() == 0)
                        System.out.println("El sistema no tiene registros cargados para realizar esta consulta");
                    else
                        consultarAntiguedadCambioPropietario();
                    break;

                case 8:
                    if (todosLosVehiculosDelPais.size() == 0) {
                        System.out.println("###### ATENCION!!! ######### ");
                        System.out.println(" Evite PATENTES duplicadas, cargar los datos de los registros existentes primero (opcion 1)");
                    } else
                        darDeAltaUnVehiculo();
                    break;

                case 0:
                    System.out.println("Gracias por utilizar el Sistema DNRPA");
                    isMenu = false;
                    break;

                default:
                    System.out.println("Ingrese una opcion correcta");
            }
        } while (isMenu);

    }

    private void darDeAltaUnVehiculo() {
        System.out.print("Ingrese el registro seccional donde registrará el ALTA del vehículo: ");
        Integer elRegistroSeccional = Integer.parseInt(scanner.nextLine());
        Boolean isNuevoRS = true;

        for (RegistroSeccional rs : registrosSeccionales) {
            if (rs.getIdRegistroSeccional().equals(elRegistroSeccional)) {
                isNuevoRS = false;
                seccional = rs;
                break;
            }
        }

        if (isNuevoRS) {
            seccional = new RegistroSeccional(elRegistroSeccional);
            agregarRegistroSeccional(seccional);
        }

        System.out.print("Ingrese el nombre del Propietario del vehículo: ");
        seccional.darAltaPropietario(new Persona(scanner.nextLine()));

        System.out.print("Si el vehiculo tiene autorizados, ingrese la cantidad: (0 = ninguno): ");
        Integer opcion = Integer.parseInt(scanner.nextLine());

        if (opcion != 0) {
            List<Persona> autorizados = new ArrayList<>();
            for (int i = 0; i < opcion; i++) {
                System.out.print("Ingrese el nombre del autorizado nro. " + (i + 1) + " :");
                autorizados.add(new Persona(scanner.nextLine()));
            }

            seccional.darAltaAutorizados(autorizados);

        } else {
            seccional.darAltaAutorizados(null);
        }

        System.out.println("Ingrese el tipo de vehiculo a dar de alta: ");
        System.out.println("1: auto");
        System.out.println("2: auto eléctrico");
        System.out.println(("3: camión"));
        System.out.println("4: colectivo");
        System.out.println("5: moto");
        System.out.println("6: moto eléctrica");
        System.out.println("7: utilitario");


        opcion = Integer.parseInt(scanner.nextLine());
        switch (opcion) {
            case 1:
                unVehiculo = new Auto(
                        seccional.getIdRegistroSeccional(),
                        seccional.getFechaDeAlta(),
                        seccional.getPatente(),
                        seccional.getUso(),
                        seccional.getPropietario(),
                        seccional.getAutorizados());
                break;

            case 2:
                unVehiculo = new AutoElectrico(
                        seccional.getIdRegistroSeccional(),
                        seccional.getFechaDeAlta(),
                        seccional.getPatente(),
                        seccional.getUso(),
                        seccional.getPropietario(),
                        seccional.getAutorizados());
                break;

            case 3:
                unVehiculo = new Camion(
                        seccional.getIdRegistroSeccional(),
                        seccional.getFechaDeAlta(),
                        seccional.getPatente(),
                        seccional.getUso(),
                        seccional.getPropietario(),
                        seccional.getAutorizados());
                break;

            case 4:
                unVehiculo = new Colectivo(
                        seccional.getIdRegistroSeccional(),
                        seccional.getFechaDeAlta(),
                        seccional.getPatente(),
                        seccional.getUso(),
                        seccional.getPropietario(),
                        seccional.getAutorizados());
                break;

            case 5:
                unVehiculo = new Moto(
                        seccional.getIdRegistroSeccional(),
                        seccional.getFechaDeAlta(),
                        seccional.getPatente(),
                        seccional.getUso(),
                        seccional.getPropietario(),
                        seccional.getAutorizados());
                break;

            case 6:
                unVehiculo = new MotoElectrica(
                        seccional.getIdRegistroSeccional(),
                        seccional.getFechaDeAlta(),
                        seccional.getPatente(),
                        seccional.getUso(),
                        seccional.getPropietario(),
                        seccional.getAutorizados());
                break;

            case 7:
                unVehiculo = new Utilitario(
                        seccional.getIdRegistroSeccional(),
                        seccional.getFechaDeAlta(),
                        seccional.getPatente(),
                        seccional.getUso(),
                        seccional.getPropietario(),
                        seccional.getAutorizados());
                break;

            default:
                System.out.println("No se ha seleccionado ningun vehiculo");
                break;
        }
        seccional.darAltaVehiculo(unVehiculo);
        todosLosVehiculosDelPais.add(unVehiculo);
        System.out.println("El vehiculo " + unVehiculo.getClass().getSimpleName() + " se ha dado de alta");
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
        auto1 = new Auto(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAltaAleatoria(),
                seccional.getPatenteAleatoria(),
                seccional.getUsoAleatorio(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculoAleatorio(auto1);

        seccional.darAltaPropietario(new Persona("Vivian"));
        autorizados = new ArrayList<>(Arrays.asList(
                new Persona("Nora"),
                new Persona("Pedro")
        ));
        seccional.darAltaAutorizados(autorizados);

        Auto auto2;
        auto2 = new Auto(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAltaAleatoria(),
                seccional.getPatenteAleatoria(),
                seccional.getUsoAleatorio(),
                seccional.getPropietario());
        seccional.darAltaVehiculoAleatorio(auto2);

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
                seccional.getFechaDeAltaAleatoria(),
                seccional.getPatenteAleatoria(),
                seccional.getUsoAleatorio(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculoAleatorio(camion1);

        seccional.darAltaPropietario(new Persona("Anastasia"));

        Moto moto1;
        moto1 = new Moto(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAltaAleatoria(),
                seccional.getPatenteAleatoria(),
                seccional.getUsoAleatorio(),
                seccional.getPropietario());
        seccional.darAltaVehiculoAleatorio(moto1);

        seccional.darAltaPropietario(new Persona("Tomas"));

        AutoElectrico autoElectrico1;
        autoElectrico1 = new AutoElectrico(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAltaAleatoria(),
                seccional.getPatenteAleatoria(),
                seccional.getUsoAleatorio(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculoAleatorio(autoElectrico1);

        seccional = crearNuevoRegistroSeccional();
        agregarRegistroSeccional(seccional);

        seccional.darAltaPropietario(new Persona("Maria"));
        autorizados = new ArrayList<>(Arrays.asList(
                new Persona("Tito"),
                new Persona("Ana")
        ));
        seccional.darAltaAutorizados(autorizados);

        Camion camion2;
        camion2 = new Camion(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAltaAleatoria(),
                seccional.getPatenteAleatoria(),
                seccional.getUsoAleatorio(),
                seccional.getPropietario());
        seccional.darAltaVehiculoAleatorio(camion2);

        AutoElectrico autoElectrico2;
        autoElectrico2 = new AutoElectrico(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAltaAleatoria(),
                seccional.getPatenteAleatoria(),
                seccional.getUsoAleatorio(),
                seccional.getPropietario(),
                seccional.getAutorizados());

        seccional.darAltaVehiculoAleatorio(autoElectrico2);

        seccional.darAltaPropietario(new Persona("Silvio"));

        Utilitario utilitario;
        utilitario = new Utilitario(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAltaAleatoria(),
                seccional.getPatenteAleatoria(),
                seccional.getUsoAleatorio(),
                seccional.getPropietario());
        seccional.darAltaVehiculoAleatorio(utilitario);

        armarListaVehiculosdeTodosLosRegistros();

        System.out.println();
        System.out.println("Los datos de los REGISTROS SECCIONALES EXISTENTES han sido cargados.");
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


    private void agregarATodosLosCamiones(Vehiculo v) {
        todosLosCamiones.add(v);
    }

    private void armarListaVehiculosdeTodosLosRegistros() {
        for (RegistroSeccional rs : getRegistrosSeccionales()) {
            for (Vehiculo vehiculo : rs.getVehiculos()) {
                todosLosVehiculosDelPais.add(vehiculo);
            }
        }
    }

    private void listarTodosLosVehiculosDelPais() {

        System.out.println();
        System.out.println("Listado de TODOS LOS VEHICULOS de todas las seccionales");
        System.out.println();
        System.out.println("Cantidad de registros: " + obtenerCantidadRegistrosSeccionales());
        System.out.println("-------------------------------------------------------------------------");

        for (RegistroSeccional r : getRegistrosSeccionales()) {

            System.out.println("Registro Seccional Nro.: " + r.getIdRegistroSeccional());
            for (Vehiculo v : r.getVehiculos()) {

                System.out.println();
                listarVehiculo(v);
                System.out.println();
            }
        }

        System.out.println("Cantidad de vehiculos listados: " + todosLosVehiculosDelPais.size());
        System.out.println("-------------------------------------------------------------------------");
    }

    private void listarTodosLosAutos() {
        System.out.println();
        System.out.println("Listado de AUTOS de todos los Registros Seccionales:");
        System.out.println("-------------------------------------------------------------------------");

        Integer contador = 0;
        System.out.println();
        Collections.sort(todosLosVehiculosDelPais, (o1, o2) -> o1.idRegistroSeccional.compareTo(o2.idRegistroSeccional));

        for (Vehiculo elVehiculo : todosLosVehiculosDelPais) {

            if (elVehiculo instanceof Auto) {
                System.out.println("Registro Secccional Nro. : "+elVehiculo.idRegistroSeccional);
                Auto auto = (Auto) elVehiculo;
                listarVehiculo(auto);
                contador++;

            } else if (elVehiculo instanceof AutoElectrico) {
                System.out.println("Registro Secccional Nro. : "+elVehiculo.idRegistroSeccional);
                AutoElectrico auto = (AutoElectrico) elVehiculo;
                listarVehiculo(auto);
                contador++;
            }
        }

        System.out.println();
        System.out.println("Cantidad de autos: " + contador);
        System.out.println("-------------------------------------------------------------------------");
    }

    private void listarVehiculo(Vehiculo v) {
        //System.out.println("Registro Seccional Nro.: " + v.idRegistroSeccional);
        System.out.println();
        System.out.println("Patente: " + v.patente);


        System.out.println("Tipo: " + v.getClass().getSimpleName());
        System.out.println("Uso: " + v.uso);
        System.out.println(v.uso.getDescripcion());

        System.out.println("Propietario: " + v.propietario.getNombre());
        System.out.println("Fecha de alta en el Registro: " + v.fechaDeAlta);
        listarAutorizados(v);
        System.out.println();

        if (v.fechaCambioPropietario != null) {
            System.out.println("Fecha de transferencia a otro propietario: " + v.fechaCambioPropietario);
        }

    }

    private void listarAutorizados(Vehiculo v) {
        if (v.autorizados != null) {
            System.out.print("Autorizados a manejar el vehículo: ");

            for (Persona p : v.autorizados) {
                System.out.print("/ " + p.getNombre());
            }

            System.out.println();
        } else {
            System.out.println("El vehiculo no tiene autorizados asignados");
        }
    }


    private void listarTodosLosCamiones() {

        for (Vehiculo elVehiculo : todosLosVehiculosDelPais) {

            if (elVehiculo instanceof Camion) {
                agregarATodosLosCamiones(elVehiculo);
            }
        }

        System.out.println();
        System.out.println("Listado de PROPIETARIOS de CAMIONES de todos los Registros Seccionales:");
        Collections.sort(todosLosCamiones, (o1, o2) -> o1.propietario.getNombre().compareTo(o2.propietario.getNombre()));

        for (Vehiculo camion : todosLosCamiones) {

            listarVehiculo(camion);

        }
        System.out.println();
        System.out.println("Cantidad de camiones: " + todosLosCamiones.size());
        System.out.println("-------------------------------------------------------------------------");
        todosLosCamiones.clear();
    }

    //Opcional 3: Los automotores pueden cambiar de propietario.
    //Opcional 4: Se debe registrar la fecha de cambio de propietario.

    private void cambiarPropietario() {

        Boolean isCambiado = false;
        Integer registro = 0;
        LocalDate fechaCambio = null;


        System.out.println("Ingrese el nombre del nuevo propietario: ");
        String nombre = scanner.nextLine();
        Persona nuevoPropietario = new Persona(nombre);

        System.out.println("Ingrese la patente del vehículo que cambia de propietario:");
        String patente = scanner.nextLine();


        for (Vehiculo elVehiculo : todosLosVehiculosDelPais) {
            if (elVehiculo.patente.equals(patente)) {
                try {
                    setCambioPropietario(nuevoPropietario, elVehiculo);

                } catch (PatenteDesactualizadaException e) {
                    e.printStackTrace();
                    break;
                }

                registro = elVehiculo.getIdRegistroSeccional();

                elVehiculo.fechaCambioPropietario = this.fechaActual;

                //TODO: borrar fechas de prueba
                //se prueba mostrar != fechas de cambio de propietario
                //elVehiculo. fechaCambioPropietario = LocalDate.of(2020,05,01);
                //elVehiculo.fechaCambioPropietario = LocalDate.of(2019,05,01);

                fechaCambio = elVehiculo.fechaCambioPropietario;

                elVehiculo.autorizados = null;

                isCambiado = true;
                break;
            }

        }
        System.out.println("-------------------------------------------------------------------------");

        if (isCambiado) {
            System.out.println("El propietario del vehiculo con patente: " + patente + " ha sido actualizado");
            System.out.println("Se encuentra en el Registro Seccional Nro.: " + registro);
            System.out.println("El nuevo propietario es: " + nuevoPropietario.getNombre());
            System.out.println("La fecha de cambio es: " + fechaCambio);

        } else {
            System.out.println("No se ha encontrado el vehiculo para cambiar el propietario.");
        }
    }

    private void setCambioPropietario(Persona nuevoPropietario, Vehiculo elVehiculo) throws PatenteDesactualizadaException {
        if (elVehiculo.patente.length() > 6) {
            elVehiculo.propietario = nuevoPropietario;
        } else {
            throw new PatenteDesactualizadaException("El vehículo debe actualizar su patente antes de cambiar de propietario, al formato XX123YY");
        }

    }

    //Opcional 5:Se puede consultar si pasó un año o mas desde el registro o cambio de titular para un auto y
    //la consulta se realiza por patente.

    private Long consultarDiasDesdeElAltaDelVehiculo(Vehiculo v) {

        Long diasDesdeAlta = null;

        for (Vehiculo elVehiculo : todosLosVehiculosDelPais) {

            if (elVehiculo.patente == v.patente)
                diasDesdeAlta = DAYS.between(elVehiculo.fechaDeAlta, fechaActual);

        }
        return diasDesdeAlta;
    }

    private Long consultarDiasDesdeCambioDePropietarioDelVehiculo(Vehiculo v) {

        Long diasDesdeCambio = null;

        for (Vehiculo elVehiculo : todosLosVehiculosDelPais) {

            if ((elVehiculo.patente == v.patente) && (elVehiculo.fechaCambioPropietario != null))
                diasDesdeCambio = DAYS.between(elVehiculo.fechaCambioPropietario, fechaActual);

            break;
        }
        return diasDesdeCambio;
    }

    private void consultarAntiguedadAltaVehiculo() {

        /*//TODO Borrar: opcion de carga aleatoria para consulta de antiguedad de Alta de Vehiculo
        Integer opcion = aleatorio.nextInt(7)+1;
        Vehiculo v = todosLosVehiculosDelPais.get(opcion);*/

        System.out.println("Ingrese la patente del vehículo que consulta antigüedad de ALTA DEL VEHICULO:");
        String patente = scanner.nextLine();

        for (Vehiculo elVehiculo : todosLosVehiculosDelPais) {
            if (elVehiculo.patente.equals(patente)) {
                listarVehiculo(elVehiculo);
            }

            Long diasDesdeAlta = consultarDiasDesdeElAltaDelVehiculo(elVehiculo);

            System.out.println("-------------------------------------------------------------------------");

            if (diasDesdeAlta == null) {
                System.out.println("El vehículo con patente " + elVehiculo.patente + " fue dado de alta hoy");

            } else {
                System.out.println("Patente Nro.: " + elVehiculo.patente);

                if (diasDesdeAlta > 360) {
                    System.out.println("Hace " + diasDesdeAlta + " dias se dio de alta y ya pasó el año.");

                } else {
                    System.out.println("Hace " + diasDesdeAlta + " dias se dio de alta y todavia no pasó el año.");
                }
            }
        }
    }


    private void consultarAntiguedadCambioPropietario() {

        /*/TODO Borrar: opcion de carga aleatoria para consulta de antiguedad de Cambio de Propietario
        Integer opcion = aleatorio.nextInt(7)+1;
        Vehiculo v = todosLosVehiculosDelPais.get(opcion);
        listarAuto(v);*/

        System.out.println("Ingrese la patente del vehículo que consulta antiguedad de CAMBIO DE PROPIETARIO:");
        String patente = scanner.nextLine();

        for (Vehiculo elVehiculo : todosLosVehiculosDelPais) {
            if (elVehiculo.patente.equals(patente)) {
                listarVehiculo(elVehiculo);
            }

            Long diasDesdeCambio = consultarDiasDesdeCambioDePropietarioDelVehiculo(elVehiculo);

            System.out.println("-------------------------------------------------------------------------");

            System.out.println("Patente Nro.: " + elVehiculo.patente);

            if (elVehiculo.fechaCambioPropietario == null) {
                System.out.println("El vehiculo no cambio de propietario nunca.");

            } else if (diasDesdeCambio == null) {
                System.out.println("El vehículo con patente " + elVehiculo.patente + " cambio hoy de propietario");

            } else {
                if (diasDesdeCambio > 360) {
                    System.out.println("Hace " + diasDesdeCambio + " días cambió de propietario, ya pasó el año.");

                } else {
                    System.out.println("Hace " + diasDesdeCambio + " dias cambio de propietario y todavia no pasó el año.");
                }
            }
        }
    }
}

