package alDate;

public class AlniseMatice {
    int taille;
    int[][] matrice = {};

    public AlniseMatice() {
        taille = 0;
    }

    public void taille(int tailleSaisie) {
        taille = tailleSaisie;
    }

    public void remplir(int[][] matriceSaisie){
        matrice = matriceSaisie;
    }
    
    public void afficher(){
        System.out.println("Voici le contenu de la matrice : ");
        for(int i = 0; i < matrice.length; i++) {
            for(int j = 0; j < matrice.length; j++) {
                System.out.print("\t" + matrice[i][j]);
            }
            System.out.println();
        }
    }

    public void afficherDiagonale(){
        System.out.print("Voici la diagonale : ");
        for(int i = 0; i < matrice.length; i++) {
            for(int j = 0; j < matrice.length; j++) {
                if(i == j) System.out.print("\t" + matrice[i][j]);
            }
        }
    }

    public void sommeLigne(int ligne){
        int somme = 0;
        if(ligne < matrice.length) {
            for(int j = 0; j < matrice.length; j++) {
                somme = somme + matrice[ligne - 1][j];
            }
            System.out.println("\nSomme ligne " + ligne + " : " + somme);
        } else {
            System.out.println("Somme ligne " + ligne + " n'existe pas.");
        }
    }

    public void sommeColonne(int colonne){
        int somme = 0;
        if(colonne > 0 && colonne < matrice.length) {
            for(int i = 0; i < matrice.length; i++) {
                somme = somme + matrice[i][colonne - 1];
            }
            System.out.println("\nSomme colonne " + colonne + " : " + somme);
        } else {
            System.out.println("Somme colonne " + colonne + " n'existe pas.");
        }
    }

    public boolean testEstMagique() {
        // Somme des lignes
        int[] sommeLigne = new int[matrice.length];

        for(int i = 0; i < matrice.length; i++) {
            sommeLigne[i] = 0;
            for(int j = 0; j < matrice.length; j++) {
                sommeLigne[i] = sommeLigne[i] + matrice[i][j];
            }
        }

        // Somme des colonnes
        int[] sommeColonne = new int[matrice.length];

        for(int j = 0; j < matrice.length; j++) {
            sommeColonne[j] = 0;
            for(int i = 0; i < matrice.length; i++) {
                sommeColonne[j] = sommeColonne[j] + matrice[i][j];
            }
        }

        // Somme des diagonales
        int sommeDiagonale1 = 0;
        int sommeDiagonale2 = 0;

        for(int i = 0; i < matrice.length; i++) {
            for(int j = 0; j < matrice.length; j++) {
                if(i == j) sommeDiagonale1 = sommeDiagonale1 + matrice[i][j];
                if(i + j == matrice.length - 1) sommeDiagonale2 = sommeDiagonale2 + matrice[i][j];
            }
        }

        boolean magique[] = {false, false, false};

        if(sommeDiagonale1 == sommeDiagonale2) {
            magique[0] = true;
            for(int i = 0; i < sommeLigne.length; i++) {
                if(sommeLigne[i] == sommeDiagonale1) {
                    magique[1] = true;
                } else {
                    magique[1] = false;
                }
            }

            for(int i = 0; i < sommeColonne.length; i++) {
                if(sommeColonne[i] == sommeDiagonale1) {
                    magique[2] = true;
                } else {
                    magique[2] = false;
                }
            }
        }

        boolean estMagique = false;

        if(magique[0] == magique[1]) {
            if(magique[1] == magique[2]){
                estMagique = true;
            }
        }
        
        return estMagique;
    }

    public void estMagique(){
        if(testEstMagique()) {
            System.out.println("La matrice est magique.");
        } else {
            System.out.println("La matrice n'est pas magique.");
        }
    }
}
