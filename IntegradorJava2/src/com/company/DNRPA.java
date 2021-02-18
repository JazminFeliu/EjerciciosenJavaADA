package com.company;

import java.util.LinkedList;
import java.util.List;

public class DNRPA {

    private List<RegistroSeccional> registrosSeccionales = new LinkedList<>();
    private Integer idRegistroNuevo = 1;

    public RegistroSeccional crearNuevoRegistroSeccional(){
        RegistroSeccional registro = new RegistroSeccional(idRegistroNuevo);
        idRegistroNuevo++;
        return registro;
    }

    public void agregarRegistroSeccional(RegistroSeccional registroSeccional) {
        registrosSeccionales.add(registroSeccional);
    }

    public void removerRegistroSeccional(RegistroSeccional rs) {
        registrosSeccionales.remove(rs);
    }

    public Integer obtenerCantidadRegistrosSeccionales() {
        return registrosSeccionales.size();
    }

    public List<RegistroSeccional> getRegistrosSeccionales() {
        return registrosSeccionales;
    }
}
