import java.util.Scanner;

import alDate.AlniseDate;
import alDate.Verbe;

public class AlniseDevoir {

    static Scanner sc = new Scanner(System.in);

    static void devoirVerbe(){
        System.out.print("Quel est le verbe à analyser : ");
        Verbe monVerbe = new Verbe("");

        if(monVerbe.estCorrect()){
            System.out.println(monVerbe.groupeCommentaire());
        } else {
            System.out.println(monVerbe.estInvalideCommentaire());
        }
    }
	
    static void devoirDate() {
        String format = "dd/mm/yyyy";

		System.out.print("Entrer une date (jj/mm/aaaa) : ");
        AlniseDate date = new AlniseDate(sc.nextLine());
        date.setFormat(format);

        if(date.estCorrect()){
            System.out.println("Votre date -> " + date.getDateFormat()); 
            System.out.println("Date précédente -> " + date.getDatePrecedent()); 
            System.out.println("Date suivante -> " + date.getDateSuivant());
        } else {
            System.out.println("\r");
            
            if(date.respectLeFormat()) {
                if(!date.nombresConformes()){
                    String[] erreurNombre = date.erreurNombreTexte();
                    
                    for(int i = 0; i < erreurNombre.length; i++){
                        System.out.println(erreurNombre[i]);
                    }
                }
            } else {
                System.out.println(date.erreurFormatTexte());
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int reponse;

        // devoirDate();

        do{
            System.out.println("\n\t1. Devoir des verbes.\n\t2. Devoir des dates.\n\t3. Quitter");
            System.out.print("\nVotre choix : ");

            reponse = sc.nextInt();

            if(reponse == 1) {
                devoirVerbe();
            }else if (reponse == 2) {
                devoirDate();
            } else if (reponse == 3) {
                // Quitte le programme
            } else {
                reponse = 0;
                System.out.println("Votre choix n'est pas correct.\nVeillez choisir selon les options affichées.\n\n");
            }
        }while(reponse == 0);
        sc.close();
    }
}
