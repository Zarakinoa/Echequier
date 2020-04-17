
public abstract class Piece {
	
	//nom : nom de la piece
	//couleur : couleur de la piece
	//pos : position en x,y de la piece sur le plateau
	protected String nom;
	protected String couleur;
	protected Position pos;
			
	/**
	 * Initialise une piece
	 * @param nom Nom de la piece
	 * @param couleur Couleur de la piece
	 * @param x Coordonées en x de la piece
	 * @param y Coordonées en y de la piece
	 */
	public Piece(String nom,String couleur,int x, int y)
	{
		this.nom = nom;
		this.couleur = couleur;
		this.pos = new Position(x,y);
	}
	
	/**
	 * Renvoie les données d'une piece
	 */
	public String toString()
	{
		return this.nom;
	}
	
	/**
	 * Permet de deplacer une piece quelconque
	 * @param p Plateau de jeu
	 * @param arrive Position d'arrive de la piece
	 * @param j Joueur qui effectue le déplacement
	 * @param undo Pile enregistrant les déplacement
	 * @return Retourne un boolean
	 */
	public abstract boolean deplacer(Plateau p,Position arrive,Joueur j,Deplacement undo);
	
	/**
	 * Permet de revenir en arriere en cour de jeu
	 * @param p Plateau de jeu
	 * @param arrive Position d'arrive de la piece
	 * @param undo Pile enregistrant les déplacement
	 */
	public void gereUndo(Plateau p,Position arrive,Deplacement undo)
	{
		undo.setPiece(this);
		undo.setPosition(this.pos);
		undo.setPosition(arrive);
		undo.setPieceManger(p.getPlateau(arrive.getX(), arrive.getY()).getPiece());
	}
	
	/**
	 * 
	 * @param p Plateau de jeu
	 * @param arrive Position d'arrive de la piece
	 * @param joueurPromotion Joueur actuel pour promotion de pion
	 */
	public void metAJourPlateau(Plateau p, Position arrive,Joueur joueurPromotion)
	{
		p.videPlateau(this.pos);
		this.pos = arrive;
		p.setPlateau(this, pos.getX(), pos.getY());
	}
	
	/*public void mangePiece(Plateau p, Position arrive,Joueur joueurAdverse)
	{
		int index = 9;
		
		if(p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null)
		{
			for(Piece pieceAdverse : joueurAdverse.getList())
			{
				if(pieceAdverse.pos.getX() == arrive.getX() && pieceAdverse.pos.getY() == arrive.getY())
				{
					index = joueurAdverse.getList().indexOf(pieceAdverse);
				}
			}
		}
		
		if(index != 9)
		{
			joueurAdverse.getList().remove(index);
		}
	}*/
}
