import java.util.Scanner;

import alDate.AlniseDate;
import alDate.Verbe;
import alDate.AlniseMatice;

public class AlniseDevoir {

    static Scanner sc = new Scanner(System.in);

    static void devoirVerbe(){
        System.out.print("Quel est le verbe à analyser : ");
        Verbe monVerbe = new Verbe(sc.nextLine());

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

    static int[][] matriceSaisir(){
        System.out.print("La taille de la matrice : ");
        int n = sc.nextInt();
        int[][] matrice = new int[n][n];
        System.out.println("\nLa taille de la matrice est : " + n);

        for(int i = 0; i < matrice.length; i++) {
            for(int j = 0; j < matrice.length; j++) {
                Boolean erreur = false;
                do{
                    try {
                        System.out.print("> ");
                        matrice[i][j] = sc.nextInt();
                        erreur = false;
                    } catch(Exception e) {
                        System.out.println("Cette matrice ne recoit que des entiers.\n");
                        erreur = true;
                    }
                }while(erreur);
            }
        }

        return matrice;
    }

    static void devoirMatrice(){
        
        int[][] matrice = matriceSaisir();
        AlniseMatice maMatrice = new AlniseMatice();

        // System.out.println(matrice.length);

        maMatrice.taille(matrice.length);
        maMatrice.remplir(matrice);
        maMatrice.estMagique();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // int reponse;

        // devoirDate();
        // devoirVerbe();
        devoirMatrice();
    }
}
