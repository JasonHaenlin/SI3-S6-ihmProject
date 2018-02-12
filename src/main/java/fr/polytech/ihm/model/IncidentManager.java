package fr.polytech.ihm.model;

import java.io.*;
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

	public static void saveIncidentList(){
		try {
			FileOutputStream fos = new FileOutputStream("incidentList.incident");
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(incidentList);
			os.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void loadIncidentList(){
		try {
			FileInputStream fis = new FileInputStream("incidentList.incident");
			ObjectInputStream is = new ObjectInputStream(fis);
			incidentList = (List<Incident>) is.readObject();
			is.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
