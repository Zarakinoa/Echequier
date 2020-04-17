
public class Cavalier extends Piece{
	
	/**
	 * Initialise un Cavalier
	 * @param nom Nom de la piece
	 * @param couleur Couleur de la piece
	 * @param x Coordonnées en x de la piece
	 * @param y Coordonnées en y de la piece
	 */
	public Cavalier(String nom,String couleur,int x, int y)
	{
		super(nom,couleur,x,y);
	}
	
	/**
	 * Renvoi les données du Cavalier
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	/**
	 * Deplace le Cavalier si le mouvement est possible
	 * @param p Plateau de jeu
	 * @param arrive Position d'arrive de la piece
	 * @param joueur Joueur qui deplace le Cavalier
	 * @param undo Pile enregistrant les deplacement
	 * @return Retourne vrai si le Cavalier c'est déplacé sinon faux
	 */
	@Override
	public boolean deplacer(Plateau p,Position arrive,Joueur joueur,Deplacement undo) 
	{
		//Attaque d'un cavalier sur piece adverse ou deplacement sur case vide
		if(((p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur != this.couleur)) || (p.getPlateau(arrive.getX(), arrive.getY()).getPiece() == null))
		{
			if((this.pos.getX() == arrive.getX() - 1 && this.pos.getY() == arrive.getY() - 2))
			{
				gereUndo(p,arrive,undo);
				metAJourPlateau(p,arrive,joueur);
				return true;
			}
		
			else if((this.pos.getX() == arrive.getX() - 2 && this.pos.getY() == arrive.getY() - 1))
			{
				gereUndo(p,arrive,undo);
				metAJourPlateau(p,arrive,joueur);
				return true;
			}
			
			else if((this.pos.getX() == arrive.getX() + 2 && this.pos.getY() == arrive.getY() - 1))
			{
				gereUndo(p,arrive,undo);
				metAJourPlateau(p,arrive,joueur);				
				return true;
			}
			
			else if((this.pos.getX() == arrive.getX() - 1 && this.pos.getY() == arrive.getY() + 2))
			{
				gereUndo(p,arrive,undo);
				metAJourPlateau(p,arrive,joueur);				
				return true;
			}
			
			else if((this.pos.getX() == arrive.getX() + 1 && this.pos.getY() == arrive.getY() + 2))
			{
				gereUndo(p,arrive,undo);
				metAJourPlateau(p,arrive,joueur);				
				return true;
			}
			
			else if((this.pos.getX() == arrive.getX() + 2 && this.pos.getY() == arrive.getY() + 1))
			{
				gereUndo(p,arrive,undo);
				metAJourPlateau(p,arrive,joueur);				
				return true;
			}
			
			else if((this.pos.getX() == arrive.getX() + 1 && this.pos.getY() == arrive.getY() - 2))
			{
				gereUndo(p,arrive,undo);
				metAJourPlateau(p,arrive,joueur);				
				return true;
			}	
			
			else if((this.pos.getX() == arrive.getX() - 2 && this.pos.getY() == arrive.getY() + 1))
			{
				gereUndo(p,arrive,undo);
				metAJourPlateau(p,arrive,joueur);				
				return true;
			}
			
			return false;
			
		}
		
		return false;

	}
		
}
