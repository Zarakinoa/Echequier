import java.util.ArrayList;

public class Roi extends Piece{

	/**
	 * Initialise une Roi
	 * @param nom Nom de la piece
	 * @param couleur Couleur de la piece
	 * @param x Coordonnées en x de la piece
	 * @param y Coordonnées en y de la piece
	 */
	public Roi(String nom,String couleur,int x, int y)
	{
		super(nom,couleur,x,y);
	}
	
	/**
	 * Renvoi les données du Roi
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	/**
	 * Deplace la Roi si le mouvement est possible
	 * @param p Plateau de jeu
	 * @param arrive Position d'arrive de la piece
	 * @param joueur Joueur qui deplace le Roi
	 * @param undo Pile enregistrant les deplacement
	 * @return Retourne vrai si la Roi c'est déplacé sinon faux
	 */
	@Override
	public boolean deplacer(Plateau p, Position arrive,Joueur joueur,Deplacement undo)
	{
		if(((this.pos.getX() != arrive.getX()) || (this.pos.getY() != arrive.getY())) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur == this.couleur))
		{
			return false;
		}
		else if((this.pos.getX() + 1 == arrive.getX()) && this.pos.getY() == arrive.getY())
		{
			gereUndo(p,arrive,undo);
			metAJourPlateau(p,arrive,joueur);							
			return true;
		}
		
		else if((this.pos.getX() + 1 == arrive.getX()) && this.pos.getY() + 1 == arrive.getY())
		{
			gereUndo(p,arrive,undo);
			metAJourPlateau(p,arrive,joueur);							
			return true;

		}
		
		else if((this.pos.getX() == arrive.getX()) && this.pos.getY() + 1 == arrive.getY())
		{
			gereUndo(p,arrive,undo);
			metAJourPlateau(p,arrive,joueur);							
			return true;

		}
		
		else if((this.pos.getX() - 1 == arrive.getX()) && this.pos.getY() == arrive.getY())
		{
			gereUndo(p,arrive,undo);
			metAJourPlateau(p,arrive,joueur);							
			return true;

		}
		
		else if((this.pos.getX() - 1 == arrive.getX()) && this.pos.getY() - 1 == arrive.getY())
		{
			gereUndo(p,arrive,undo);
			metAJourPlateau(p,arrive,joueur);							
			return true;

		}
		
		else if((this.pos.getX() == arrive.getX()) && this.pos.getY() - 1 == arrive.getY())
		{
			gereUndo(p,arrive,undo);
			metAJourPlateau(p,arrive,joueur);							
			return true;

		}
		
		else if((this.pos.getX() - 1 == arrive.getX()) && this.pos.getY() + 1 == arrive.getY())
		{
			gereUndo(p,arrive,undo);
			metAJourPlateau(p,arrive,joueur);							
			return true;

		}
		
		else if((this.pos.getX() + 1 == arrive.getX()) && this.pos.getY() - 1 == arrive.getY())
		{
			gereUndo(p,arrive,undo);
			metAJourPlateau(p,arrive,joueur);							
			return true;

		}
		
		return false;
	}
	
	
	/**
	 * Test si le Roi est en echec
	 * @param p Plateau de jeu
	 * @param adverse Joueur ennemi
	 * @param undo Pile enregistrant les deplacement
	 * @return Retourne une piece si echec sinon null
	 */
	public Piece echec(Plateau p, Joueur adverse,Deplacement undo)
	{

		for(Piece piece : adverse.getList())
		{
			Position posTmp = new Position(piece.pos.getX(),piece.pos.getY());

			if(piece.deplacer(p, this.pos, adverse, undo))
			{	
				piece.deplacer(p, posTmp, adverse, undo);
				return piece;
			}
		}
		
		return null;
	}
	
	/**
	 * Test si le roi peut se defendre pour sortir de l'echec
	 * @param p Plateau de jeu
	 * @param depart Position de depart saisir par l'utilisateur
	 * @param arrive Position d'arrive saisir par l'utilisateur
	 * @param posPieceAdverse Position de la piece mettant en echec le Roi
	 * @param joueurAllie joueur actuel
	 * @param undo Pile enregistrant les deplacement
	 * @return Retourne vrai si Roi peut se defendre, faux sinon
	 */
	public boolean defenseDuRoi(Plateau p,Position depart,Position arrive, Position posPieceAdverse, Joueur joueurAllie, Deplacement undo)
	{
		System.out.println("defenseRoi");
		
		if(depart.getX() == this.pos.getX() && depart.getY() == this.pos.getY() && arrive.getX() == posPieceAdverse.getX() && arrive.getY() == posPieceAdverse.getY())
		{
			if(this.deplacer(p,posPieceAdverse,joueurAllie,undo))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Test si le roi peut fuir pour sortir de l'echec
	 * @param p Plateau de jeu
	 * @param posSecurise Position où le Roi sort de l'echec
	 * @param joueurAllie joueur actuel
	 * @param joueurAdverse joueur ennemi
	 * @param undo Pile enregistrant les deplacement
	 * @return Retourne vrai si Roi peut fuir, faux sinon
	 */
	public boolean fuiteDuRoi(Plateau p, Position posSecurise, Joueur joueurAllie,Joueur joueurAdverse, Deplacement undo)
	{
		System.out.println("FuiteRoi");

		if(this.deplacer(p,posSecurise,joueurAllie,undo) == true && this.echec(p, joueurAdverse, undo) == null)
		{
			return true;
		}
		
		return false;
	}

	/**
	 * Test attaque d'une piece allie pur sortir de l'echec
	 * @param p Plateau de jeu
	 * @param depart Position de depart saisir par l'utilisateur
	 * @param arrive Position d'arrive saisir par l'utilisateur
	 * @param posPieceAdverse Position de la piece mettant en echec le Roi
	 * @param joueurAllie joueur actuel
	 * @param undo Pile enregistrant les deplacement
	 * @return Retourne vrai si piece allier peut defendre le Roi, faux sinon
	 */
	public boolean attaqueAllie(Plateau p,Position depart, Position arrive, Position posPieceAdverse, Joueur joueurAllie, Deplacement undo)
	{
		System.out.println("AttaqueAllie");

		/*ArrayList<Piece> tmp = new ArrayList<Piece>();
		
		for(Piece pieceAllie1 : joueurAllie.getList())
		{
			Position posTmp = new Position(pieceAllie1.pos.getX(),pieceAllie1.pos.getY());

			if(arrive.getX() == posPieceAdverse.getX() && arrive.getY() == posPieceAdverse.getY() && pieceAllie1.deplacer(p, posPieceAdverse, joueurAllie, undo))
			{
				pieceAllie1.deplacer(p,posTmp, joueurAllie, undo);
				tmp.add(pieceAllie1);
				
			}
		}
		
		for(Piece pieceAllie2 : tmp)
		{
			if(pieceAllie2.pos.getX() == depart.getX() && pieceAllie2.pos.getY() == depart.getY()) 
			{
				pieceAllie2.deplacer(p, posPieceAdverse, joueurAllie, undo);
				tmp.clear();
				return true;
			}
		}
			
		return false;*/
				
		System.out.println(posPieceAdverse);

		for(Piece pieceAllie1 : joueurAllie.getList())
		{

			if(pieceAllie1.pos.getX() == depart.getX() && pieceAllie1.pos.getY() == depart.getY() && arrive.getX() == posPieceAdverse.getX() && arrive.getY() == posPieceAdverse.getY())
			{
				if(pieceAllie1.deplacer(p, posPieceAdverse, joueurAllie, undo))
				{
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	/**
	 * Test si une piece allie peut se sacrifier
	 * @param p Plateau de jeu
	 * @param depart Position de depart saisir par l'utilisateur
	 * @param posSacrifice Position on la piece allie se sacrifie pour le Roi
	 * @param joueurAllie joueur actuel
	 * @param jAdverse joueur ennemi
	 * @param undo Pile enregistrant les deplacement
	 * @return Retourne vrai si piece allier peut se sacrifier pour le Roi, faux sinon
	 */
	public boolean sacrificeAllie(Plateau p,Position depart, Position posSacrifice, Joueur joueurAllie,Joueur jAdverse, Deplacement undo)
	{
		/*ArrayList<Piece> tmp = new ArrayList<Piece>();
		
		for(Piece pieceAllie1 : joueurAllie.getList())
		{
			Position posTmp = new Position(pieceAllie1.pos.getX(),pieceAllie1.pos.getY());
			
			pieceAllie1.deplacer(p, posSacrifice, joueurAllie, undo);
			
			if(this.echec(p, jAdverse, undo) == null)
			{
				pieceAllie1.deplacer(p, posTmp, joueurAllie, undo);
				tmp.add(pieceAllie1);
			}
		}
		
		for(Piece pieceAllie2 : tmp)
		{
			if(pieceAllie2.pos.getX() == depart.getX() && pieceAllie2.pos.getY() == depart.getY())
			{
				pieceAllie2.deplacer(p, posSacrifice, joueurAllie, undo);
				tmp.clear();
				return true;
			}
		}
		
		return false;*/
		
		System.out.println("SacrificeAllie");

		for(Piece pieceAllie1 : joueurAllie.getList())
		{
			Position posTmp = new Position(pieceAllie1.pos.getX(),pieceAllie1.pos.getY());

			if(pieceAllie1.pos.getX() == depart.getX() && pieceAllie1.pos.getY() == depart.getY())
			{
				if(pieceAllie1.deplacer(p, posSacrifice, joueurAllie, undo) )
				{
					System.out.println(pieceAllie1.pos);

					if(this.echec(p, jAdverse, undo) == null)
					{
						return true;
					}
				}
			}
			
		}
		
		return false;
	}

}
