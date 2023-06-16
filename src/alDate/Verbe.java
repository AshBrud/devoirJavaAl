package alDate;

public class Verbe {
    private String verbe;

    private boolean estPornominal(){
        int espace = verbe.charAt(2);
        return (verbe.substring(0, 2).toLowerCase().equals("se") && espace == 32) ;
    }

    public Verbe(String verbeSaisie){
        verbe = verbeSaisie;
    }

    public boolean estDuPremierGroupe(){
        return (verbe.substring(verbe.length() - 2).equals("er")) ? true: false;
    }

    public String groupeCommentaire(){
        String commentaire = (estDuPremierGroupe())? "\nLe verbe '" + verbe + "' est du premier groupe, car il se termine par 'er'."
            : "\nLe verbe '" + verbe + "' n'est pas du premier groupe, car il ne se termine pas par 'er'.";

        return commentaire + ((estPornominal())? "\nEn plus il est pronominal.": "");
    }

    public boolean estCorrect(){

        boolean valeur = true;

        for(int i = 0; i < verbe.length(); i++) {
            int car = verbe.charAt(i);

            if(!((car >= 97 && car <= 122) || (car >= 65 && car <= 90) || car == 32)) {
                valeur = false;
                break;
            }
        }

        return valeur;
    }

    public String estInvalideCommentaire(){
        return (estCorrect())? "Le mot "+ verbe + " est conforme.": "Le mot " + verbe + " n'est pas conforme.";
    }
}
