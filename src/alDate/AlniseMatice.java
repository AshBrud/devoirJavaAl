package alDate;

public class AlniseMatice {
    
    public void remplirParLigne(){
        int m = sc.nextInt();
    
        System.out.print("Saisir le nombre de colonnes dans la matrice: ");
        int n = sc.nextInt();
        //déclarer la matrice
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(String.format("Entrez a[%d][%d] : ", i, j));
            a[i][j] = sc.nextInt();
        }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
