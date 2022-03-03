package com.caresoft.clinicapp.models;
import com.caresoft.clinicapp.interfaces.UsuarioCompatibleConHIPAA;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class Physician extends Usuario implements UsuarioCompatibleConHIPAA {
    // Dentro de la clase:
    private ArrayList<String> patientNotes;

    // PARA HACER: Constructor que tome un ID
    public Physician(Integer id){
        super(id);
        this.patientNotes = new ArrayList<>();
    }


    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
                "Fecha y hora de envío: %s \n", date);
        report += String.format("Reportado por ID: %s\n", this.id);
        report += String.format("Nombre del paciente: %s\n", patientName);
        report += String.format("Notas: %s \n", notes);
        this.patientNotes.add(report);
    }

    // PARA HACER: Setters y Getters
    public ArrayList<String> getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(ArrayList<String> patientNotes) {
        this.patientNotes = patientNotes;
    }

    // PARA HACER: ¡Implementar UsuarioCompatibleConHIPAA!
    @Override
    public boolean assignPin(int pin) {
        //l pin debe tener exactamente 4 dígitos, de lo contrario devuelve false. Se espera que asigne el pin al usuario (como una variable miembro)
        if (pin < 1000 || pin > 9999) {
            return false;
        } else {
            this.pin = pin;
            return true;
        }
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        //Verifica la identificación del médico versus la identificación dada; devuelve true si coinciden, de lo contrario, devuelve false.
        return Objects.equals(this.id, confirmedAuthID);
    }
}
