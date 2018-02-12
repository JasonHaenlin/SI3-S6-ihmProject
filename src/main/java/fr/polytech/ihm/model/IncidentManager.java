package fr.polytech.ihm.model;

import java.util.ArrayList;
import java.util.List;

public class IncidentManager {

    private static List<Incident> incidentList = new ArrayList<>();

    public static void addIncident(Incident incident) {
        incidentList.add(incident);
        System.out.println(incidentList);
    }

    public static List<Incident> getIncidentList() {
        return incidentList;
    }

}
