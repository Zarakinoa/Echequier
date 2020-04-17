import java.lang.String;

public class Case {
		
		//Piece : Piece que contient la case
		//couleur : couleur d'une case
		//pos : position en x,y d'une case sur le plateau
		//contenu : case vide ou non-vide	
	    private Piece piece;
		private String couleur;
		private Position pos;
		private boolean contenu;
		
		/**
		 * Initialise une case en mettant son contenu à vide 
		 * @param couleur Couleur de la case
		 * @param x	Coordonnées en x de la case
		 * @param y Coordonnées en y de la case
		 */
		public Case(String couleur,int x,int y)
		{
			this.couleur = couleur;
			this.pos = new Position(x,y);
			this.contenu = false;
		}
		
		
		/**
		 * Initialise une case contenant une piece
		 * @param piece Piece contenu dans la case
		 * @param couleur Couleur de la case
		 * @param x Coordonnées en x de la case
		 * @param y Coordonnées en y de la case
		 */
		public Case(Piece piece,String couleur,int x,int y)
		{
			this.piece = piece;
			this.couleur = couleur;
			this.pos = new Position(x,y);
			this.contenu = true;
		}
		
		
		/**
		 * Renvoi la piece associer à la case
		 * @return Retourne la piece
		 */
		public Piece getPiece()
		{
			return this.piece;
		}
		
		
		/**
		 * Vide le contenu d'une case 
		 * @return Retourne la case
		 */
		public Case videCase()
		{
			this.piece = null;
			this.contenu = false;
			return this;
		}
		//Met à jour le contenu d'une case à vide ✔
		
		
		/**
		 * Met le contenu de la case à vide
		 * @return Retourne le contenu 
		 */
		public boolean videContenu()
		{
			return this.contenu = false;
		}
		
		
		/**
		 * Met le contenu de la case à plein
		 * @return Retourne le contenu
		 */
		public boolean remplirContenu()
		{
			return this.contenu = true;
		}
		
		
		/**
		 * Renvoi la couleur de la case
		 * @return Retourne la couleur
		 */
					
		public String getCouleur()
		{
			return this.couleur;
		}
		
		
		/**
		 * Renvoi la position de la case
		 * @return Retourne la position
		 */
		public Position getPosition()
		{
			return this.pos;
		}
		
		
		/**
		 * Renvoi le contenu de la case
		 * @return Retourne le contenu
		 */
		public boolean getContenu()
		{
			return this.contenu;
		}
		
		
		/**
		 * Renvoi les données d'une case en String
		 * @return Retourne tous les attributs d'une case
		 */
		public String getCase()
		{
			return this.couleur +  " " + this.pos.toString() + this.contenu;
 		}
}
