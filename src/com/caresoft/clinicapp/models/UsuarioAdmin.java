package com.caresoft.clinicapp.models;
import com.caresoft.clinicapp.interfaces.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class UsuarioAdmin extends Usuario implements UsuarioCompatibleConHIPAA, AdminCompatibleConHIPAA {

    private Integer employeeID;
    private String role;
    private  ArrayList<String> securityIncidents;

    public UsuarioAdmin(Integer employeeID, String role){
        this.employeeID = employeeID;
        this.role = role;
        this.securityIncidents = new ArrayList<String>();
    }


    public void newIncident(String notes) {
        String report = String.format(
                "Fecha y hora de envío: %s \n, Reportado por ID: %s\n Notas: %s \n",
                new Date(), this.employeeID, notes
        );
        securityIncidents.add(report);
    }

    public void authIncident() {
        String report = String.format(
                "Fecha y hora de envío: %s \n, ID: %s\n Notas: %s \n",
                new Date(), this.employeeID, "FALLÓ EL INTENTO DE AUTORIZACIÓN PARA ESTE USUARIO"
        );
        securityIncidents.add(report);
    }

    //El pin debe tener 6 dígitos o más; devuelve false de lo contrario. Se espera que asigne el pin al usuario (como una variable miembro)
    @Override
    public boolean assignPin(int pin) {
        if (pin < 100000 || pin > 999999) {
            return false;
        }else{
            this.pin = pin;
            return true;
        }
    }


    //Compara los id y, si no coinciden, crea un reporte de incidente utilizando el método authIncident. Devuelve true si las identificaciones coinciden, false en caso contrario.
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (Objects.equals(this.employeeID, confirmedAuthID)) {
            return true;
        } else {
            authIncident();
            return false;
        }
    }

    //Devuelve una lista de cadenas (incidentes reportados)
    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return securityIncidents;
    }
}
