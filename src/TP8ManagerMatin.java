import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * NUMERO BINOME 1  8700:
 * NOM BINOME 1: JALABERT
 * PRENOM BINOME 1: TOM
 * NUMERO BINOME 2: 8627
 * NOM BINOME 2: POUSSOT
 * PRENOM BINOME 2: ANTOINE
 **/

public class TP8ManagerMatin {
    /**
     * QUESTION 2.1.1
     **/
    public static boolean [] filtre(float [] tab, float max) {
	boolean [] resultat = new boolean[tab.length];
	for(int i=0;i<tab.length;i++) {
	    if(tab[i] >= max)
		resultat[i] = true;
	    else
		resultat[i] = false;
	}
	return resultat;
    }

    /**
     * QUESTION 2.1.2
     * REPONSE: retourne le nombre de chiffres qui composent le nombre
     **/
    public static int myFunction(int y) {
    int z=0;
    while(y!=0) {

      y = y / 10;
      z++;
    }
    return z;
    }

    /** 
     * QUESTION 3.1.1:
     **/
    public static int diagDiff(int [][] matrice) {
		//hypothese : matrice carré
    	int taille = matrice.length, i;
    	int buffer = 0;
    	for (i = 0; i < taille; i++){
    		buffer = matrice[i][i] + buffer;
    	}

    	for (int j = taille-1; j>=0; j--){
    		buffer= buffer - matrice[taille-j-1][j];
		}

			return Math.abs(buffer);

    }

    /** 
     * QUESTION 3.2.1:
     **/
    public static boolean find(int [] tab, int nb)
    {
		int k=0;
		for(int i=0;i<tab.length;i++) {
			if(tab[i] == nb){
				k++;
			}
		}
		if (k!=0){
			return true;
		}
		else {
			return false;
		}
	}

    /**
     * QUESTION 3.3.1
     **/
    public static void trier(int [] tab) {
		boolean flag = true;
		int var;
		while (flag) {
			flag = false;
			for (int i = 0; i < tab.length - 1; i++) {
				if (tab[i] > tab[i + 1]) {
					var = tab[i];
					tab[i] = tab[i + 1];
					tab[i + 1] = var;
					flag = true;
				}
			}
		}
		System.out.println("Voici le tableau trié:");
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + "\t");
		}
		System.out.println("");
	}
       

    /**
     * QUESTION 3.4.1.1
     **/

   public static int[] inverse(int[] tab) {
	   int[] tab2 = new int[tab.length];

	   for (int i = 0; i > tab.length; i++) {
		   tab2[tab.length - i] = tab[i];
	   }
	   return tab2;
   }
	  /*ArrayList liste = new ArrayList<Integer>();
	  for(int i = 0; i<tab.length; i++){
	  	liste.add(tab[i]);
	  }
	  tab = inversebis(liste).toArray(tab);
   }

   public static ArrayList<Integer> inversebis(ArrayList<Integer> liste){
   	if (liste.isEmpty()) {
   		return liste;

	}
	int taille = liste.size();
	int next = liste.get(-1);
	ArrayList liste2 = new ArrayList<Integer>();
	liste2.add(next)
	   return liste.get(-1)

   } */



    /**
     * QUESTION 3.4.2.1
     **/

    private static class MaListe {
		String data;
		MaListe next;

		public MaListe(String data, MaListe next) {
			this.data = data;
			this.next = next;
		}
	}

    public static void affichage(MaListe l){
		if(l.next != null){  // Fixed
			System.out.println(l.data);
			affichage(l.next);
		}else System.out.println(l.data);
	}

    
    /**
     * QUESTION 3.4.2.2
     **/
    public static int recherche(MaListe l, String v) {
		int i =1;
		boolean k = true;
    	while(k){
			if (l.data.equals(v)){
				k = false;
			}else if (l.next != null){
				l=l.next;
				i++;
			}else {
				i=-1;
				k = false;
			}
		}
		return i;
	}

    /**
     * QUESTION 3.5.1
     **/
	public static int rechercheSomme(int [] t){
		ArrayList<Integer> p = new ArrayList();
		ArrayList<Integer> g = new ArrayList();
		int sp=0;
		int sg=0;
		int k=0;
		while(k!=t.length-1){
			for(int i=k; i<t.length-1; i++){
				if(t[i]+1 == t[i+1]){
					p.add(t[i]);
				}
				else{
					p.add(t[i]);
					k=i+1;
					break;
				}
			}
			for (int i =0; i<p.size(); i++){
				sp= sp + p.get(i); //somme de la liste
			}
			if (sp > sg){
				g.clear();
				g.addAll(p);
				p.clear();
				sp=0;
			}
			sg=0;
			for (int i =0; i<g.size(); i++){
				sg= sg + g.get(i); //somme de la liste
			}
			for (int i=0; i<p.size(); i++){
				System.out.print( p.get(i)+"\t");
			}
			//System.out.println(sp);

			for (int i=0; i<g.size(); i++){
				System.out.print(g.get(i)+"\t");
			}
			//System.out.println(sg);

		}
		System.out.println("La somme de la suite la plus grande est " + sg);
		return sg;
	}
	//Seen by Tom Jalabert at 11:59




	/**
     * APRES CE POINT, NE PAS MODIFIER LE CODE 
     */
    public static void main(String [] args)
    {
	System.out.println("==== MYFUNCTION ====");
	System.out.println("TEST myFunction(1) =" + myFunction(1));
	System.out.println("TEST myFunction(12) =" + myFunction(12));
	System.out.println("TEST myFunction(152) =" + myFunction(152));
	

	System.out.println("\n\n==== DiagDiff ====");
	System.out.println("TEST diagDiff(new int [][]{{11,2,4},{4,5,6},{10,8,-12}})");
	int  result = diagDiff(new int [][]{{11,2,4},{4,5,6},{10,8,-12}});
	test(result,15);
	System.out.println("TEST diagDiff(new int [][]{{1,2,3},{4,5,6},{7,8,9}})");
	result = diagDiff(new int [][]{{1,2,3},{4,5,6},{7,8,9}});
	test(result,0);

	System.out.println("\n\n==== Recherche ====");
	System.out.println("TEST : find({1,2,2,9,0}, 9)");
	test(find(new int[] {1,2,2,9,0},9), true);
	System.out.println("TEST : find({2,2,5,1}, 7)");
	test(find(new int[] {2,2,5,1},7), false);

	System.out.println("\n\n==== Tri ====");
	System.out.println("TEST : trier({1,2,2,9,0})");
	int [] tab = new int[] {1,2,2,9,0};
	trier(tab);
	System.out.println("TAB contient : " + Arrays.toString(tab) + " et devrait être:  [0,1,2,2,9]");

	System.out.println("TEST : trier({54,32,10})");
	tab = new int [] {54,32,10};
	trier(tab);
	System.out.println("TAB contient : " + Arrays.toString(tab) + " et devrait être: [10,32,54]");

	System.out.println("\n\n==== Inverse ====");
	System.out.println("TEST : inverse({1,2,2,9,0})");
	tab = new int[] {1,2,2,9,0};
	inverse(tab);
	System.out.println("TAB is : " + Arrays.toString(tab) + " et devrait être: [0,9,2,2,1]");

	System.out.println("TEST : inverse({54,32,10})");
	tab = new int [] {54,32,10};
	inverse(tab);
	System.out.println("TAB is : " + Arrays.toString(tab) + " et devrait être: [10,32,54]");

	System.out.println("\n\n==== Liste: affichage ====");

	MaListe tete = new MaListe("trois",null);
	tete = new MaListe("deux",tete);
	tete = new MaListe("un",tete);

	System.out.println("L'affichage est:");
	affichage(tete);
	System.out.println("L'affichage devrait etre:\nun\ndeux\ntrois");	

	System.out.println("\n\n==== Liste: recherche ====");
	System.out.println("Recherche de \"un\"");
	test(recherche(tete, "un"),1);
	System.out.println("Recherche de \"quatre\"");
	test(recherche(tete,"quatre"),-1);

	System.out.println("\n\n==== Recherche de somme ====");
	System.out.println("Recherche sur  {1,2,2,9,0}");
	test(rechercheSomme(new int []  {1,2,2,9,0}),9);
	System.out.println("Recherche sur  {6,3,4,5,1,2,2}");
	test(rechercheSomme(new int []  {6,3,4,5,1,2,2}),12);
    }

    public static <T> void test(T returned, T expected) {
	if(returned.equals(expected))
	    System.out.println("PASSED: a retourné " + returned);
	else
	    System.out.println("FAILED: retourne " + returned + " au lieu de " + expected);
    }
 
}
