import java.util.Scanner;

public class Pion extends Piece{

	/**
	 * Initialise un Pion
	 * @param nom Nom de la piece
	 * @param couleur Couleur de la piece
	 * @param x Coordonnées en x de la piece
	 * @param y Coordonnées en y de la piece
	 */
	public Pion(String nom,String couleur,int x, int y)
	{
		super(nom,couleur,x,y);
	}
	
	/**
	 * Renvoi les données du Pion
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	/**
	 * Deplace le Pion si le mouvement est possible
	 * @param p Plateau de jeu
	 * @param arrive Position d'arrive de la piece
	 * @param joueur Joueur qui deplace le Pion
	 * @param undo Pile enregistrant les deplacement
	 * @return Retourne vrai si le Pion c'est déplacé sinon faux
	 */
	@Override
	public boolean deplacer(Plateau p, Position arrive,Joueur joueur,Deplacement undo)
	{
	  if(joueur.getidJoueur() == 1)
	  {
			
		//Deplacement avec piece alliée à l'arrive
		if(((this.pos.getX() != arrive.getX()) || (this.pos.getY() != arrive.getY())) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur == this.couleur))
		{
			return false;
		}
		
		//Pion bord gauche et Piece devant et aucune en diagonale
		else if(this.pos.getY() == 0 && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() != null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() + 1).getPiece() == null))
		{
			return false;
		}
		
		//Pion bord droit et Piece devant et aucune en diagonale
		else if(this.pos.getY() == 7 && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() != null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() - 1).getPiece() == null))
		{
			return false;
		
		}
		
		//Pion bord gauche et aucune piece devant et aucune en diagonale
		else if(this.pos.getY() == 0 && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() == null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() + 1).getPiece() == null))
		{
			//1er déplacement d'un pion, aucun piece devant
			if((this.pos.getX() == 1) && ((this.pos.getX() + 1 == arrive.getX() || this.pos.getX() + 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() == null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);
				return true;

			}
			
			//1er déplacement d'un pion, piece devant
			else if((this.pos.getX() == 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY())
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() != null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
			//déplacement d'un pion au cour du jeu sans piece devant
			else if((this.pos.getX() != 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}		
		}
		
		//Pion bord droit et aucune piece devant et aucune en diagonale
		else if(this.pos.getY() == 7 && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() == null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() -1 ).getPiece() == null))
		{
			//1er déplacement d'un pion, aucun piece devant
			if((this.pos.getX() == 1) && ((this.pos.getX() + 1 == arrive.getX() || this.pos.getX() + 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() == null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
			//1er déplacement d'un pion, piece devant
			else if((this.pos.getX() == 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY())
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() != null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
			//déplacement d'un pion au cour du jeu sans piece devant
			else if((this.pos.getX() != 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}		
		}
		
		//Pion bord gauche, aucune piece devant et piece diagonale droite
		else if(this.pos.getY() == 0 && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() + 1).getPiece() != null)  && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() == null))
		{
			if((p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur == this.couleur))
			{
				return false;
			}
			//1er déplacement d'un pion, aucun piece devant
			else if((this.pos.getX() == 1) && ((this.pos.getX() + 1 == arrive.getX() || this.pos.getX() + 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
					&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() == null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;
				
			}
					
			//1er déplacement d'un pion, piece devant
			else if((this.pos.getX() == 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY())
					&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() != null))
			{
				gereUndo(p,arrive,undo);				
				this.metAJourPlateau(p, arrive, joueur);
				return true;
				
			}
			
			//déplacement d'un pion au cour du jeu sans piece devant
			else if((this.pos.getX() != 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;
				
			}	
			
				
			//Attaque du pion sur une piece en diagonale sans piece devant
			else if((this.pos.getX() + 1 == arrive.getX()) && (this.pos.getY() + 1 == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;
				
			}
					
		}
				
		//Pion bord droit, aucune piece devant et piece diagonale gauche
		else if(this.pos.getY() == 7 && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() - 1).getPiece() != null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() == null))
		{
			if((p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur == this.couleur))
			{
				return false;
			}
			//1er déplacement d'un pion, aucun piece devant
			else if((this.pos.getX() == 1) && ((this.pos.getX() + 1 == arrive.getX() || this.pos.getX() + 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() == null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
			//1er déplacement d'un pion, piece devant
			else if((this.pos.getX() == 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY())
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() != null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
			//déplacement d'un pion au cour du jeu sans piece devant
			else if((this.pos.getX() != 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}	
			
			
			//Attaque du pion sur une piece en diagonale sans piece devant
			else if((this.pos.getX() + 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
		}
		
		//Pion bord gauche, piece devant et en diagonale
		else if(this.pos.getY() == 0 && ((p.getPlateau(this.pos.getX() + 1,this.pos.getY() + 1).getPiece() != null)  && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() != null)))
		{
		
			//Attaque du pion sur une piece en diagonale 
			if((this.pos.getX() + 1 == arrive.getX()) && (this.pos.getY() + 1 == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
		}
		//Pion bord droit, piece devant et en diagonale
		else if(this.pos.getY() == 7 && ((p.getPlateau(this.pos.getX() + 1,this.pos.getY() - 1).getPiece() != null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() != null)))
		{
		
			//Attaque du pion sur une piece en diagonale 
			if((this.pos.getX() + 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
		}
		
		

		//Piece devant et aucune en diagonale
		else if((p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() != null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() + 1).getPiece() == null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() - 1).getPiece() == null))
		{
			return false;
		}
		
			
		//Aucune piece devant et aucune en diagonale
		else if((p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() == null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() + 1).getPiece() == null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() - 1).getPiece() == null))
		{
			//1er déplacement d'un pion, aucun piece devant
			if((this.pos.getX() == 1) && ((this.pos.getX() + 1 == arrive.getX() || this.pos.getX() + 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() == null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
			//1er déplacement d'un pion, piece devant
			else if((this.pos.getX() == 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY())
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() != null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
			//déplacement d'un pion au cour du jeu sans piece devant
			else if((this.pos.getX() != 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}		
		}
			
		
		//Piece en diagonale droite avec aucune piece devant
		else if(((p.getPlateau(this.pos.getX() + 1,this.pos.getY() + 1).getPiece() != null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() - 1).getPiece() == null)) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() == null))
		{
			if((p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur == this.couleur))
			{
				return false;
			}
			//1er déplacement d'un pion, aucun piece devant
			else if((this.pos.getX() == 1) && ((this.pos.getX() + 1 == arrive.getX() || this.pos.getX() + 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() == null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
			//1er déplacement d'un pion, piece devant
			else if((this.pos.getX() == 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY())
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() != null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
			//déplacement d'un pion au cour du jeu sans piece devant
			else if((this.pos.getX() != 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}	
			
			
			//Attaque du pion sur une piece en diagonale sans piece devant
			else if((this.pos.getX() + 1 == arrive.getX()) && (this.pos.getY() + 1 == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
		}
		

		
		//Piece en diagonale gauche avec aucune piece devant
		else if(((p.getPlateau(this.pos.getX() + 1,this.pos.getY() + 1).getPiece() == null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() - 1).getPiece() != null)) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() == null))
		{
			if((p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur == this.couleur))
			{
				return false;
			}
			//1er déplacement d'un pion, aucun piece devant
			else if((this.pos.getX() == 1) && ((this.pos.getX() + 1 == arrive.getX() || this.pos.getX() + 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() == null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
			//1er déplacement d'un pion, piece devant
			else if((this.pos.getX() == 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY())
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() != null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
			//déplacement d'un pion au cour du jeu sans piece devant
			else if((this.pos.getX() != 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}	
			
			
			//Attaque du pion sur une piece en diagonale sans piece devant
			else if((this.pos.getX() + 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
		}
		
		//Piece en diagonale droite et gauche avec aucune piece devant
		else if(((p.getPlateau(this.pos.getX() + 1,this.pos.getY() + 1).getPiece() != null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() - 1).getPiece() != null)) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() == null))
		{
			if((p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur == this.couleur))
			{
				return false;
			}
			//1er déplacement d'un pion, aucun piece devant
			else if((this.pos.getX() == 1) && ((this.pos.getX() + 1 == arrive.getX() || this.pos.getX() + 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() == null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
			//1er déplacement d'un pion, piece devant
			else if((this.pos.getX() == 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY())
				&& (p.getPlateau(this.pos.getX() + 2,this.pos.getY()).getPiece() != null))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
			//déplacement d'un pion au cour du jeu sans piece devant
			else if((this.pos.getX() != 1) && (this.pos.getX() + 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}	
			
			
			//Attaque du pion sur une piece en diagonale sans piece devant
			else if((this.pos.getX() + 1 == arrive.getX()) && (this.pos.getY() + 1 == arrive.getY()) || (this.pos.getX() + 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
		}
		
		//Piece en diagonale gauche avec piece devant
		else if(((p.getPlateau(this.pos.getX() + 1,this.pos.getY() + 1).getPiece() == null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() - 1).getPiece() != null)) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() != null))
		{
			//Attaque du pion sur une piece en diagonale gauche avec piece devant
			if((this.pos.getX() + 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
			
		}
		
		//Piece en diagonale droite avec piece devant
		else if(((p.getPlateau(this.pos.getX() + 1,this.pos.getY() + 1).getPiece() != null) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY() - 1).getPiece() == null)) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() != null))
		{
			//Attaque du pion sur une piece en diagonale gauche avec piece devant
			if((this.pos.getX() + 1 == arrive.getX()) && (this.pos.getY() + 1 == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;
				
			}
			
		}
	
		
		//Piece en diagonale avec une piece devant
		else if(((((p.getPlateau(this.pos.getX() + 1,this.pos.getY() + 1).getPiece() != null) && p.getPlateau(this.pos.getX() + 1,this.pos.getY() - 1).getPiece() != null)) && (p.getPlateau(this.pos.getX() + 1,this.pos.getY()).getPiece() != null)))
		{
		
			//Attaque du pion sur une piece en diagonale 
			if((this.pos.getX() + 1 == arrive.getX()) && (this.pos.getY() + 1 == arrive.getY()) || (this.pos.getX() + 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
		}
		
		return false;
	  }
	  
	  
	  
	  else
	  {
		//Deplacement avec piece alliée à l'arrive
		if(((this.pos.getX() != arrive.getX()) || (this.pos.getY() != arrive.getY())) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur == this.couleur))
		{
			return false;
		}
			
		//Pion bord gauche et Piece devant et aucune en diagonale
		else if(this.pos.getY() == 0 && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() != null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() + 1).getPiece() == null))
		{
			return false;
		}
			
		//Pion bord droit et Piece devant et aucune en diagonale
		else if(this.pos.getY() == 7 && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() != null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() - 1).getPiece() == null))
		{
			return false;
				
		}	
			
		//Pion bord gauche et aucune piece devant et aucune en diagonale
		else if(this.pos.getY() == 0 && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() == null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() + 1).getPiece() == null))
		{
			//1er déplacement d'un pion, aucun piece devant
			if((this.pos.getX() == 1) && ((this.pos.getX() - 1 == arrive.getX() || this.pos.getX() - 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() == null))
			{	
			
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;
				
			}
				
				//1er déplacement d'un pion, piece devant
				else if((this.pos.getX() == 1) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY())
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() != null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
				//déplacement d'un pion au cour du jeu sans piece devant
				else if((this.pos.getX() != 1) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}		
			}
			
			//Pion bord droit et aucune piece devant et aucune en diagonale
			else if(this.pos.getY() == 7 && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() == null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() -1 ).getPiece() == null))
			{
				//1er déplacement d'un pion, aucun piece devant
				if((this.pos.getX() == 1) && ((this.pos.getX() - 1 == arrive.getX() || this.pos.getX() - 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() == null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
				//1er déplacement d'un pion, piece devant
				else if((this.pos.getX() == 1) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY())
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() != null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
				//déplacement d'un pion au cour du jeu sans piece devant
				else if((this.pos.getX() != 1) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}		
			}
			
			//Pion bord gauche, aucune piece devant et piece diagonale droite
			else if(this.pos.getY() == 0 && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() + 1).getPiece() != null)  && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() == null))
			{
				if((p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur == this.couleur))
				{
					return false;
				}
				//1er déplacement d'un pion, aucun piece devant
				else if((this.pos.getX() == 1) && ((this.pos.getX() - 1 == arrive.getX() || this.pos.getX() - 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
						&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() == null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;
					
				}
						
				//1er déplacement d'un pion, piece devant
				else if((this.pos.getX() == 1) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY())
						&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() != null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;
					
				}
				
				//déplacement d'un pion au cour du jeu sans piece devant
				else if((this.pos.getX() != 1) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;
					
				}	
				
					
				//Attaque du pion sur une piece en diagonale sans piece devant
				else if((this.pos.getX() - 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;
					
				}
						
			}
					
			//Pion bord droit, aucune piece devant et piece diagonale gauche
			else if(this.pos.getY() == 7 && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() - 1).getPiece() != null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() == null))
			{
				if((p.getPlateau(arrive.getX(), arrive.getY()).getPiece() != null) && (p.getPlateau(arrive.getX(), arrive.getY()).getPiece().couleur == this.couleur))
				{
					return false;
				}
				//1er déplacement d'un pion, aucun piece devant
				else if((this.pos.getX() == 1) && ((this.pos.getX() - 1 == arrive.getX() || this.pos.getX() - 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() == null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
				//1er déplacement d'un pion, piece devant
				else if((this.pos.getX() == 1) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY())
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() != null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
				//déplacement d'un pion au cour du jeu sans piece devant
				else if((this.pos.getX() != 1) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}	
				
				
				//Attaque du pion sur une piece en diagonale sans piece devant
				else if((this.pos.getX() - 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
			}
		
		//Pion bord gauche, piece devant et en diagonale
		else if(this.pos.getY() == 0 && ((p.getPlateau(this.pos.getX() - 1,this.pos.getY() + 1).getPiece() != null)  && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() != null)))
		{
		
			//Attaque du pion sur une piece en diagonale 
			if((this.pos.getX() - 1 == arrive.getX()) && (this.pos.getY() + 1 == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
		}
		//Pion bord droit, piece devant et en diagonale
		else if(this.pos.getY() == 0 && ((p.getPlateau(this.pos.getX() - 1,this.pos.getY() - 1).getPiece() != null)  && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() != null)))
		{
		
			//Attaque du pion sur une piece en diagonale 
			if((this.pos.getX() - 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;

			}
		}
			
			//Piece devant et aucune en diagonale
			else if((p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() != null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() + 1).getPiece() == null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() - 1).getPiece() == null))
			{
				return false;
			}
			
				
			//Aucune piece devant et aucune en diagonale
			else if((p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() == null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() + 1).getPiece() == null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() - 1).getPiece() == null))
			{
				//1er déplacement d'un pion, aucun piece devant
				if((this.pos.getX() == 6) && ((this.pos.getX() - 1 == arrive.getX() || this.pos.getX() - 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() == null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
				//1er déplacement d'un pion, piece devant
				else if((this.pos.getX() == 6) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY())
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() != null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
				//déplacement d'un pion au cour du jeu sans piece devant
				else if((this.pos.getX() != 6) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}		
			}
				
			
			//Piece en diagonale droite avec aucune piece devant
			else if(((p.getPlateau(this.pos.getX() - 1,this.pos.getY() + 1).getPiece() != null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() - 1).getPiece() == null)) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() == null))
			{
				
				//1er déplacement d'un pion, aucun piece devant
				if((this.pos.getX() == 6) && ((this.pos.getX() - 1 == arrive.getX() || this.pos.getX() - 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() == null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
				//1er déplacement d'un pion, piece devant
				else if((this.pos.getX() == 6) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY())
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() != null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
				//déplacement d'un pion au cour du jeu sans piece devant
				else if((this.pos.getX() != 6) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}	
				
				
				//Attaque du pion sur une piece en diagonale sans piece devant
				else if((this.pos.getX() - 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
			}
			

			
			//Piece en diagonale gauche avec aucune piece devant
			else if(((p.getPlateau(this.pos.getX() - 1,this.pos.getY() + 1).getPiece() == null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() - 1).getPiece() != null)) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() == null))
			{
				
				//1er déplacement d'un pion, aucun piece devant
				if((this.pos.getX() == 6) && ((this.pos.getX() - 1 == arrive.getX() || this.pos.getX() - 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() == null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
				//1er déplacement d'un pion, piece devant
				else if((this.pos.getX() == 6) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY())
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() != null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);
					return true;
				}
				
				//déplacement d'un pion au cour du jeu sans piece devant
				else if((this.pos.getX() != 6) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}	
				
				
				//Attaque du pion sur une piece en diagonale sans piece devant
				else if((this.pos.getX() - 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
			}
			
			//Piece en diagonale droite et gauche avec aucune piece devant
			else if(((p.getPlateau(this.pos.getX() - 1,this.pos.getY() + 1).getPiece() != null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() - 1).getPiece() != null)) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() == null))
			{
				
				//1er déplacement d'un pion, aucun piece devant
				if((this.pos.getX() == 6) && ((this.pos.getX() - 1 == arrive.getX() || this.pos.getX() - 2 == arrive.getX()) && this.pos.getY() == arrive.getY()) 
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() == null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
				//1er déplacement d'un pion, piece devant
				else if((this.pos.getX() == 6) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY())
					&& (p.getPlateau(this.pos.getX() - 2,this.pos.getY()).getPiece() != null))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
				//déplacement d'un pion au cour du jeu sans piece devant
				else if((this.pos.getX() != 6) && (this.pos.getX() - 1 == arrive.getX() && this.pos.getY() == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}	
				
				
				//Attaque du pion sur une piece en diagonale sans piece devant
				else if((this.pos.getX() - 1 == arrive.getX()) && (this.pos.getY() + 1 == arrive.getY()) || (this.pos.getX() - 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
				
			}
			
		
		
		//Piece en diagonale gauche avec piece devant
		else if(((p.getPlateau(this.pos.getX() - 1,this.pos.getY() + 1).getPiece() == null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() - 1).getPiece() != null)) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() != null))
		{
			//Attaque du pion sur une piece en diagonale gauche avec piece devant
			if((this.pos.getX() - 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
			{
				gereUndo(p,arrive,undo);
				this.metAJourPlateau(p, arrive, joueur);				
				return true;
				
			}
					
		}	
			
			//Piece en diagonale droite avec piece devant
			else if(((p.getPlateau(this.pos.getX() - 1,this.pos.getY() + 1).getPiece() != null) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY() - 1).getPiece() == null)) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() != null))
			{
				//Attaque du pion sur une piece en diagonale gauche avec piece devant
				if((this.pos.getX() - 1 == arrive.getX()) && (this.pos.getY() + 1 == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;
					
				}
				
			}
		
			
			//Piece en diagonale avec une piece devant
			else if(((((p.getPlateau(this.pos.getX() - 1,this.pos.getY() + 1).getPiece() != null) && p.getPlateau(this.pos.getX() - 1,this.pos.getY() - 1).getPiece() != null)) && (p.getPlateau(this.pos.getX() - 1,this.pos.getY()).getPiece() != null)))
			{
			
				//Attaque du pion sur une piece en diagonale 
				if((this.pos.getX() - 1 == arrive.getX()) && (this.pos.getY() + 1 == arrive.getY()) || (this.pos.getX() - 1 == arrive.getX()) && (this.pos.getY() - 1 == arrive.getY()))
				{
					gereUndo(p,arrive,undo);
					this.metAJourPlateau(p, arrive, joueur);					
					return true;

				}
			}
			
			return false;
		  }
	  
		//return false;
	  
	  }
	
	/**
	* Transforme un pion en Reine,Tour,Fou ou Cavalier
	 * @param p Plateau de jeu
	 * @param j Joueur fesant la promotion d'un pion
	 */
	 public void promotion(Plateau p,Joueur j)
	  {
		if(this.pos.getX() == 0 || this.pos.getX() == 7)
		{
			System.out.println("Saisir la promotion : Reine, Cavalier, Tour, Fou");
			Scanner sc = new Scanner(System.in);
			String choix = sc.nextLine();
			
			
			
			if(choix.equals("Reine"))
			{
				if(j.getidJoueur() == 1)
				{
					Reine r = new Reine("♕",this.couleur,this.pos.getX(),this.pos.getY());
					p.setPlateau(r, this.pos.getX(), this.pos.getY());
					j.getList().set(j.getList().indexOf(this), r);
				}
				
				else
				{
					Reine r = new Reine("♛",this.couleur,this.pos.getX(),this.pos.getY());
					p.setPlateau(r, this.pos.getX(), this.pos.getY());
					j.getList().set(j.getList().indexOf(this), r);
				}		
			}
			
			
			
			
			else if(choix.equals("Cavalier"))
			{
				if(j.getidJoueur() == 1)
				{
					Cavalier c = new Cavalier("♘",this.couleur,this.pos.getX(),this.pos.getY());
					p.setPlateau(c, this.pos.getX(), this.pos.getY());
					j.getList().set(j.getList().indexOf(this), c);
				}
				
				else
				{
					Cavalier c = new Cavalier("♞",this.couleur,this.pos.getX(),this.pos.getY());
					p.setPlateau(c, this.pos.getX(), this.pos.getY());
					j.getList().set(j.getList().indexOf(this), c);
				}
			}
			
			
			
			else if(choix.equals("Tour"))
			{
				if(j.getidJoueur() == 1)
				{
					Tour t = new Tour("♖",this.couleur,this.pos.getX(),this.pos.getY());
					p.setPlateau(t, this.pos.getX(), this.pos.getY());
					j.getList().set(j.getList().indexOf(this), t);
				}
				
				else
				{
					Tour t = new Tour("♜",this.couleur,this.pos.getX(),this.pos.getY());
					p.setPlateau(t, this.pos.getX(), this.pos.getY());
					j.getList().set(j.getList().indexOf(this), t);
				}
			}
			
			
			
			
			else if(choix.equals("Fou"))
			{
				if(j.getidJoueur() == 1)
				{
					Fou f = new Fou("♗",this.couleur,this.pos.getX(),this.pos.getY());
					p.setPlateau(f, this.pos.getX(), this.pos.getY());
					j.getList().set(j.getList().indexOf(this), f);
				}
				
				else
				{
					Fou f = new Fou("♝",this.couleur,this.pos.getX(),this.pos.getY());
					p.setPlateau(f, this.pos.getX(), this.pos.getY());
					j.getList().set(j.getList().indexOf(this), f);
				}
			}		
		}
	}
	
	/**
	 * Permet au joueur de deplacer un pion et de faire une promotion si besoin
	 * @param p Plateau de jeu
	 * @param arrive Position d'arrive du pion
	 * @param joueurPromotion joueur effectuant la promotion d'un pion
	 */
	 @Override
	public void metAJourPlateau(Plateau p,Position arrive,Joueur joueurPromotion)
	{
		super.metAJourPlateau(p, arrive, joueurPromotion);
		this.promotion(p,joueurPromotion);
	}
}
