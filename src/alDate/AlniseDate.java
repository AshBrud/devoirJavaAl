package alDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.ldap.StartTlsRequest;

public class AlniseDate {
    private String date;
    private String formatDate;
    private String[] lesMois = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Oût", "Septembre", "Octobre", "Novembre", "Décembre"};
    private int[] lesJours = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public AlniseDate(String userDate){
        this.date = userDate;
    }

    public void setValeur(String dateSaisie){
        this.date = dateSaisie;
    }
    
    public String getValeur(){
        return date;
    }
    
    public void setFormat(String formatDateSaisie){
        this.formatDate = formatDateSaisie;
    }

    public int[] nombreConformeCode(){
        // Cette methode fonction en considérant que la date respecte le format de fixé
        int codeErreur = -1, number, codesErreur[] = {-1, -1, -1};
		
        String[] nombreDateSaisie = getDateFormat().split("" + getDateFormat().charAt(2)); // Récupération des parties de la date.
		
        for (int i = 0; i < nombreDateSaisie.length; i++) {
			
            try {	
                number = Integer.parseInt(nombreDateSaisie[i]);
                
                switch(i){
                    case 0:
                        if(!(number >= 1 && number <= 15)) {
                            codeErreur = 0;
                            codesErreur[i] = codeErreur;
                            break;
                        }

                    break;

                    case 1:
                        if(!(number >= 1 && number <= 12)) {
                            codeErreur = 2;
                            codesErreur[i] = codeErreur;
                            break;
                        }

                    break;

                    case 2:
                        if(!(nombreDateSaisie[i].length() <= 4)) {
                            codeErreur = 4;
                            codesErreur[i] = codeErreur;
                            break;
                        }

                    break;
                }

            } catch(NumberFormatException e) {
                
                switch(i){
                    case 0: 
                        codeErreur = 1;
                        codesErreur[i] = codeErreur;
                    break;

                    case 1: 
                        codeErreur = 3;
                        codesErreur[i] = codeErreur;
                    break;

                    case 2: 
                        codeErreur = 5;
                        codesErreur[i] = codeErreur;
                    break;
                }
            }
        }
		
        return codesErreur;
    }

    public boolean nombresConformes(){
        boolean valeur = true;
        String dateConforme = (respectLeFormat())? getDateFormat():""; // Vérifie le format de la date puis affecter la valeur c'est c'est conforme.

        if(dateConforme.length() != 0){ // Si la daterespecte le format.
            int nombresAVerifier[] = nombreConformeCode();

            for(int i=0; i < nombresAVerifier.length;i++){

                if(nombresAVerifier[i] != -1){
                    valeur = false;
                    break;
                } 
            }
        } else {
            valeur = false;
        }

        return valeur;
    }

    public String[] erreurNombreTexte(){
        String[] text = {"Le jour est conforme.", "Le mois est conforme.", "L'année est conforme."};
        String dateConforme = (respectLeFormat())? date:""; 

        if(dateConforme.length() != 0){ 
            String ligne = "______________________________________________";
            int nombresAVerifier[] = nombreConformeCode();

            for(int i=0; i < nombresAVerifier.length; i++){

                switch(i){
                    case 0:
                        if(nombresAVerifier[i] != -1){
                            text[i] = (nombresAVerifier[i] == 0) ? ligne + "\nERREUR JOUR : \n\tLe jour ne respect pas les conditions.": ligne + "\nERREUR JOUR : \n\tLe jour n'est pas un nombre.";
                        }
                    break;
                        
                    case 1:
                        if(nombresAVerifier[i] != -1){
                            text[i] = (nombresAVerifier[i] == 2) ? ligne + "\nERREUR MOIS : \n\tLe mois ne respect pas les conditions.": ligne + "\nERREUR MOIS : \n\tLe mois n'est pas un nombre.";
                        }
                    break;

                    case 2:
                        if(nombresAVerifier[i] != -1){
                            text[i] = (nombresAVerifier[i] == 4) ? ligne + "\nERREUR ANNEE : \n\tL'année ne respect pas les conditions.": ligne + "\nERREUR ANNEE : \n\tL'année jour n'est pas un nombre.";
                        }
                    break;
                } 
            }
        }

        return text;
    }

    public String erreurFormatTexte(){
        return (respectLeFormat()) ? "ERREUR FORMAT : \n\tvotre date respecte bien le format de la date (" + formatDate + ").": "ERREUR FORMAT : \n\tvotre date ne respecte pas le format de la date (" + formatDate + ").";
    }

    public boolean respectLeFormat(){
        boolean formatCorrect = true;

        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat(formatDate);
            dateFormat.setLenient(false);
            
            try {
                Date date1 = dateFormat.parse(date);
            } catch (ParseException e) {
                formatCorrect = false;
            }

        }catch(NullPointerException e) {
            System.out.println("ERREUR : Le format de la date n'est pas défini. Merci de le définir en utilisant la methode 'setFormat()'. ");
            formatCorrect = false;
        }

        return formatCorrect;
    }

    public String getDateFormat() {
        String date2 = "";

        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat(formatDate);
            dateFormat.setLenient(false);
            
            try {
                Date date1 = dateFormat.parse(date);
                date2 = dateFormat.format(date1);
            } catch (ParseException e) {
                System.out.println("ERREUR : Le format de la date n'est pas défini.");
                date2 = date;
            }

        }catch(NullPointerException e) {
            System.out.println("ERREUR : Le format de la date n'est pas défini. Merci de le définir en utilisant la methode 'setFormat()'.");
            date2 = date;
        }

        return date2;
    }

    public boolean estCorrect() {
        return nombresConformes();
    }

    public int[] getNombreBy() {
        int[] nombresDate = {-1, -1, -1};
        
        String[] nombreDateSaisie = getDateFormat().split("" + getDateFormat().charAt(2));

        for (int i = 0; i < nombreDateSaisie.length; i++) {
        
            try {	
                nombresDate[i] = Integer.parseInt(nombreDateSaisie[i]);

            } catch(NumberFormatException e) {
                switch(i){
                    case 0:
                        System.out.println("ERREUR : \n\tLe jour n'est pas conforme.");
                    break;
                        
                    case 1:
                        System.out.println("ERREUR : \n\tLe mois n'est pas conforme.");
                    break;

                    case 2:
                        System.out.println("ERREUR : \n\tL'année n'est pas conforme.");
                    break;
                }
            }
        }

        return nombresDate;
    }

    public String moisTexte(){
        return (getNombreBy()[1] != -1) ? lesMois[getNombreBy()[1] - 1]:""; 
    }

    public String dateTexte(){
        return (nombresConformes()) ? getNombreBy()[0] + " " + lesMois[getNombreBy()[1] - 1] + " " + getNombreBy()[2] : "ERREUR : \n\tLes nombres ne sont pas conformes.";
    }

    public String getDateSuivant(){
        return getNombreBy()[0] + 1 + " " + lesMois[getNombreBy()[1] - 1] + " " + getNombreBy()[2];
    }

    public String getDatePrecedent(){
        int limitJour = 0;
        String dateRendue = "";

        if(getNombreBy()[1] == 2) {
            if(getNombreBy()[2] % 4 == 0 || getNombreBy()[2] % 400 == 0) {
                limitJour = 29;
            } else {
                limitJour = 28;
            }
        } else {
            limitJour = lesJours[(getNombreBy()[1] - 2 == -1) ? 11: getNombreBy()[1] - 1];
        }

        if(getNombreBy()[0] == 1) {
            dateRendue = limitJour + " " + lesMois[(getNombreBy()[1] - 2 == -1) ? lesMois.length - 1 : getNombreBy()[1] - 2] + " " + ((getNombreBy()[1] - 2 == -1) ? getNombreBy()[2] - 1 : getNombreBy()[2]);
        } else {
            dateRendue = getNombreBy()[0] - 1 + " " + lesMois[getNombreBy()[1] - 1] + " " + getNombreBy()[2];
        }

        return dateRendue;
    }
}