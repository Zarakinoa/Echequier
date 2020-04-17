public class Plateau {
		
	//Tableau à 2 dimensions representant un plateau de 64 cases ✔
	private Case[][] cases;
	
	/**
	 * Initialisation du plateau de jeu avec 64 cases
	 */
	public Plateau()
	{		
		int i,j;
		String coul1 = "noir";
		String coul2 = "blanc";
		String temp;
		this.cases = new Case[8][8];
		
		for(i = 0; i < 8; i++)
		{
			for(j = 0; j < 8; j++)
			{
				if(j%2 == 0)
				{
					this.cases[i][j] = new Case(coul1,i,j);
				}
				
				else
				{
					this.cases[i][j] = new Case(coul2,i,j);
				}
			}
			
			temp = coul1;
			coul1 = coul2;
			coul2 = temp;	
		}
		
	}
	
		
	
	/**
	 * Affiche toutes les cases du plateau
	 */
	public void affichePlateau()
	{
		this.afficheColone();

		for(int i = 0; i < 8; i++)
		{
			System.out.print(" " + "\033[33m" + (8 - i) + "\033[0m");
			
			for(int j = 0; j < 8; j++)
			{	
				if(this.cases[i][j].getPiece()!= null)
				{
					System.out.print(this.cases[i][j].getPiece().nom);
				}
				
				else
				{
					System.out.print(".");
				}
			}
			
			System.out.print(" " + "\033[33m" + (8 - i) + "\033[0m");
			System.out.println();

		}
		
		this.afficheColone();
	}
	
	/**
	 * Met à jour le plateau avec une piece
	 * @param p Piece à modifier sur le plateau
	 * @param x Coordonées en x de la case à modifier
	 * @param y Coordonées en y de la case à modifier
	 */
	public void setPlateau(Piece p, int x, int y)
	{	
		String couleur;
		couleur = this.cases[x][y].getCouleur();
		this.cases[x][y] = new Case(p,couleur,x,y);
		this.cases[x][y].remplirContenu();		
	}
	
	/**
	 * Met une case à vide en retirant la piece
	 * @param pos Coordonées de la case à vider
	 */
	public void videPlateau(Position pos)
	{
		this.cases[pos.getX()][pos.getY()].videCase();	
	}
	
	
	
	/**
	 * //Retourne la case de position x,y 
	 * @param x Coordonées en x de la case
	 * @param y Coordonées en y de la case
	 * @return Retourne une case
	 */
	public Case getPlateau(int x,int y)
	{
		return this.cases[x][y];
	}
	
	/**
	 * Place toutes les pieces du jeu en fonction d'un joueur
	 * @param j Joueur possédant une liste de piece personelle
	 */
	public void initPiece(Joueur j)
	{
		if(j.getCmpt()==1)
		{
			this.cases[0][0] = new Case(j.getList().get(0),this.cases[0][0].getCouleur(),0,0);
			this.cases[0][1] = new Case(j.getList().get(1),this.cases[0][1].getCouleur(),0,1);
			this.cases[0][2] = new Case(j.getList().get(2),this.cases[0][2].getCouleur(),0,2);
			this.cases[0][3] = new Case(j.getList().get(3),this.cases[0][3].getCouleur(),0,3);
			this.cases[0][4] = new Case(j.getList().get(4),this.cases[0][4].getCouleur(),0,4);
			this.cases[0][5] = new Case(j.getList().get(5),this.cases[0][5].getCouleur(),0,5);
			this.cases[0][6] = new Case(j.getList().get(6),this.cases[0][6].getCouleur(),0,6);
			this.cases[0][7] = new Case(j.getList().get(7),this.cases[0][7].getCouleur(),0,7);
			this.cases[1][0] = new Case(j.getList().get(8),this.cases[1][0].getCouleur(),1,0);
			this.cases[1][1] = new Case(j.getList().get(9),this.cases[1][1].getCouleur(),1,1);
			this.cases[1][2] = new Case(j.getList().get(10),this.cases[1][2].getCouleur(),1,2);
			this.cases[1][3] = new Case(j.getList().get(11),this.cases[1][3].getCouleur(),1,3);
			this.cases[1][4] = new Case(j.getList().get(12),this.cases[1][4].getCouleur(),1,4);
			this.cases[1][5] = new Case(j.getList().get(13),this.cases[1][5].getCouleur(),1,5);
			this.cases[1][6] = new Case(j.getList().get(14),this.cases[1][6].getCouleur(),1,6);
			this.cases[1][7] = new Case(j.getList().get(15),this.cases[1][7].getCouleur(),1,7);


			
		}
		
		else
		{
			this.cases[7][0] = new Case(j.getList().get(0),this.cases[7][0].getCouleur(),7,0);
			this.cases[7][1] = new Case(j.getList().get(1),this.cases[7][1].getCouleur(),7,1);
			this.cases[7][2] = new Case(j.getList().get(2),this.cases[7][2].getCouleur(),7,2);
			this.cases[7][3] = new Case(j.getList().get(3),this.cases[7][3].getCouleur(),7,3);
			this.cases[7][4] = new Case(j.getList().get(4),this.cases[7][4].getCouleur(),7,4);
			this.cases[7][5] = new Case(j.getList().get(5),this.cases[7][5].getCouleur(),7,5);
			this.cases[7][6] = new Case(j.getList().get(6),this.cases[7][6].getCouleur(),7,6);
			this.cases[7][7] = new Case(j.getList().get(7),this.cases[7][7].getCouleur(),7,7);
			this.cases[6][0] = new Case(j.getList().get(8),this.cases[6][0].getCouleur(),6,0);
			this.cases[6][1] = new Case(j.getList().get(9),this.cases[6][1].getCouleur(),6,1);
			this.cases[6][2] = new Case(j.getList().get(10),this.cases[6][2].getCouleur(),6,2);
			this.cases[6][3] = new Case(j.getList().get(11),this.cases[6][3].getCouleur(),6,3);
			this.cases[6][4] = new Case(j.getList().get(12),this.cases[6][4].getCouleur(),6,4);
			this.cases[6][5] = new Case(j.getList().get(13),this.cases[6][5].getCouleur(),6,5);
			this.cases[6][6] = new Case(j.getList().get(14),this.cases[6][6].getCouleur(),6,6);
			this.cases[6][7] = new Case(j.getList().get(15),this.cases[6][7].getCouleur(),6,7);
		}
		
	
	}

	/**
	 * Affiche de A à H pour le plateau
	 */
	public void afficheColone()
	{
		System.out.print("  \033[33ma\033[0m");
		System.out.print("\033[33mb\033[0m");
		System.out.print("\033[33mc\033[0m");
		System.out.print("\033[33md\033[0m");
		System.out.print("\033[33me\033[0m");
		System.out.print("\033[33mf\033[0m");
		System.out.print("\033[33mg\033[0m");
		System.out.println("\033[33mh\033[0m");
	}
}
