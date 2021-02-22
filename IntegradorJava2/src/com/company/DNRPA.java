package com.company;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

public class DNRPA {

    private List<RegistroSeccional> registrosSeccionales = new LinkedList<>();
    private Integer idRegistroNuevo = 1;
    private List<Vehiculo> todosLosAutos = new LinkedList<>();
    private List<Vehiculo> todosLosCamiones = new LinkedList<>();
    private List<Vehiculo> todosLosVehiculosDelPais = new LinkedList<>();
    private LocalDate fechaActual = LocalDate.now();

    public RegistroSeccional crearNuevoRegistroSeccional() {
        RegistroSeccional registro = new RegistroSeccional(idRegistroNuevo);
        idRegistroNuevo++;
        return registro;
    }

    public void agregarRegistroSeccional(RegistroSeccional registroSeccional) {
        registrosSeccionales.add(registroSeccional);
    }

    public Integer obtenerCantidadRegistrosSeccionales() {
        return registrosSeccionales.size();
    }

    public List<RegistroSeccional> getRegistrosSeccionales() {
        return registrosSeccionales;
    }

    public void agregarATodosLosAutos(Vehiculo v) {
        todosLosAutos.add(v);
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
        System.out.println("Cantidad de autos: " + todosLosAutos.size());
        System.out.println();
        for (Vehiculo auto : todosLosAutos) {
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
    }

    public void listarTodosLosCamiones() {
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