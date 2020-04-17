import java.util.Scanner;

public class Launcher {
	
	/**
	 * Initialise une partie d'echec 
	 * @throws InterruptedException Stop le thread
	 */
	public Launcher() throws InterruptedException
	{
		System.out.println("Choix : PvsP , PvsIA , IAvsIA");
		Scanner typeGame = new Scanner(System.in);
		String str = typeGame.nextLine();
		
		Plateau p = new Plateau();
		Deplacement undo = new Deplacement();
		
		if(str.equals("PvsP"))
		{
			Joueur j1 = new Joueur(p,"Humain");
			Joueur j2 = new Joueur(p,"Humain");
			
			p.affichePlateau();	
			for(int i = 0;i <100;i++)
			{
				j1.jouer(p,undo,j2);
				j2.jouer(p,undo,j1);
			}
		}
		
		else if(str.equals("PvsIA"))
		{
			Joueur j1 = new Joueur(p,"Humain");
			Joueur j2 = new Joueur(p,"IA");
			
			p.affichePlateau();	
			for(int i = 0;i <100;i++)
			{
				j1.jouer(p,undo,j2);
				j2.jouer(p,undo,j1);
			}
		}
		
		else if(str.equals("IAvsIA"))
		{
			Joueur j1 = new Joueur(p,"IA");
			Joueur j2 = new Joueur(p,"IA");
			
			p.affichePlateau();	
			for(int i = 0;i <100;i++)
			{
				j1.jouer(p,undo,j2);
				j2.jouer(p,undo,j1);
			}
		}
		
			
	}
	
	
}
