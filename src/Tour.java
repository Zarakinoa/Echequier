
public class Tour extends Piece{
	
	/**
	 * Initialise une Tour
	 * @param nom Nom de la piece
	 * @param couleur Couleur de la piece
	 * @param x Coordonnées en x de la piece
	 * @param y Coordonnées en y de la piece
	 */
	public Tour(String nom,String couleur,int x, int y)
	{
		super(nom,couleur,x,y);
	}
	
	/**
	 * Renvoi les données de la Tour
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	/**
	 * Deplace la Tour si le mouvement est possible
	 * @param p Plateau de jeu
	 * @param arrive Position d'arrive de la piece
	 * @param joueur Joueur qui deplace la Tour
	 * @param undo Pile enregistrant les deplacement
	 * @return Retourne vrai si la Tour c'est déplacé sinon faux
	 */
	@Override
	public boolean deplacer(Plateau p, Position arrive,Joueur joueur,Deplacement undo)
	{
		int i = 0; 
		//Deplacement avec piece alliée à l'arrive
		if(((this.pos.getX() != arrive.getX()) || (this.pos.getY() != arrive.getY())) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur == this.couleur))
		{
		}
		
		//Deplacement vers le bas avec piece adverse à l'arrive ou pas
		else if((this.pos.getX() < arrive.getX() && this.pos.getY() == arrive.getY()) && (((p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur != this.couleur)) || (p.getPlateau(arrive.getX(),arrive.getY()).getPiece() == null)))
		{

			for(i = this.pos.getX() + 1; i < arrive.getX();i ++)
			{
				if((p.getPlateau(i, this.pos.getY()).getPiece() != null))
				{
					break;
				}
			}
				
			if(i == arrive.getX()) 
			{
				gereUndo(p,arrive,undo);
				metAJourPlateau(p,arrive,joueur);								
				return true;
			}

		}
		
		//Deplacement vers le haut avec piece adverse à l'arrive ou pas
		else if((this.pos.getX() > arrive.getX()) && (this.pos.getY() == arrive.getY()) && (((p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur != this.couleur))  || (p.getPlateau(arrive.getX(),arrive.getY()).getPiece() == null)))
		{

			for(i = this.pos.getX() - 1; i > arrive.getX();i --)
			{
				if((p.getPlateau(i, this.pos.getY()).getPiece() != null))
				{
					break;
				}
			}
					
			if(i == arrive.getX()) 
			{
				gereUndo(p,arrive,undo);
				metAJourPlateau(p,arrive,joueur);								
				return true;
			}
		}
		
		
		//Deplacement vers la gauche avec piece adverse à l'arrive ou pas
		else if((this.pos.getX() == arrive.getX()) && (this.pos.getY() > arrive.getY()) && (((p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur != this.couleur))  || (p.getPlateau(arrive.getX(),arrive.getY()).getPiece() == null)))
		{

			for(i = this.pos.getY() - 1; i > arrive.getY();i --)
			{
				if((p.getPlateau(this.pos.getX(), i).getPiece() != null))
				{
					break;
				}
			}
					
			if(i == arrive.getY()) 
			{
				gereUndo(p,arrive,undo);
				metAJourPlateau(p,arrive,joueur);								
				return true;
			}
		}
		
		//Deplacement vers la droite avec piece adverse à l'arrive ou pas
		else if((this.pos.getX() == arrive.getX() && this.pos.getY() < arrive.getY()) && (((p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur != this.couleur))  || (p.getPlateau(arrive.getX(),arrive.getY()).getPiece() == null)))
		{
		
			for(i = this.pos.getY() + 1; i < arrive.getY();i ++)
			{
				if((p.getPlateau(this.pos.getX(), i).getPiece() != null))
				{
					break;
				}
			}
			 System.out.println(i);
			if(i == arrive.getY()) 
			{
				gereUndo(p,arrive,undo);
				metAJourPlateau(p,arrive,joueur);								
				return true;
			}
		}
		
		return false;
	}
}
