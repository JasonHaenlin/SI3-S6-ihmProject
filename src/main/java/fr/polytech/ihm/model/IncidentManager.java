package fr.polytech.ihm.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IncidentManager {

    private static ArrayList<Incident> incidentList = new ArrayList<>();
    private static Incident tmpIncident = null; //Incident entré dans le formulaire mais pas validé

    public static void addIncident(Incident incident) {
        tmpIncident = incident;
    }

    public static void saveTmpIncident(){
        incidentList.add(tmpIncident);
        tmpIncident = null;
    }

    public static Incident getTmpIncident() {
        return tmpIncident;
    }

    public static List<Incident> getIncidentList() {
        return incidentList;
    }

    public static void removeLastIncident() {
        incidentList.remove(incidentList.size() - 1);
    }

    public static void saveIncidentList() throws IOException {
        FileOutputStream fos = new FileOutputStream("incidentList.freyja");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(incidentList);
        os.close();
        fos.close();

    }

    public static void loadIncidentList() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("incidentList.freyja");
        ObjectInputStream is = new ObjectInputStream(fis);
        incidentList = (ArrayList<Incident>) is.readObject();
        is.close();
        fis.close();

    }

    public static void deleteIncident(Incident incidentObject) {
        incidentList.remove(incidentObject);
    }
}
