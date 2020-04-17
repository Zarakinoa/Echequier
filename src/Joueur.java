import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Joueur {
	
	private ArrayList<Piece> listesPiece = new ArrayList<Piece>();
	private static int cmpt = 1;
	private int idJoueur;
	private String typeJoueur;

	
	/**
	 * Initialise un joueur en lui attribuant une liste de piece personelle
	 * @param p Plateau de jeu
	 * @param typeJoueur Type de jouer : Humain ou IA
	 */
	public Joueur(Plateau p,String typeJoueur)
	{	
		this.typeJoueur = typeJoueur;
		
		Piece Tb1 = new Tour("♖","blanc",0,0);
		Piece Cb1 = new Cavalier("♘","blanc",0,1);
		Piece Fb1= new Fou("♗","blanc",0,2);		
		Piece rb = new Reine("♕","blanc",0,3);
		Piece Rb = new Roi("♔","blanc",0,4);
		Piece Fb2 = new Fou("♗","blanc",0,5);
		Piece Cb2 = new Cavalier("♘","blanc",0,6);
		Piece Tb2 = new Tour("♖","blanc",0,7);
		Piece Pb1 = new Pion("♙","blanc",1,0);
		Piece Pb2 = new Pion("♙","blanc",1,1);
		Piece Pb3 = new Pion("♙","blanc",1,2);
		Piece Pb4 = new Pion("♙","blanc",1,3);
		Piece Pb5 = new Pion("♙","blanc",1,4);
		Piece Pb6 = new Pion("♙","blanc",1,5);
		Piece Pb7 = new Pion("♙","blanc",1,6);
		Piece Pb8 = new Pion("♙","blanc",1,7);


		
		Piece Tn1 = new Tour("♜","noir",7,0);
		Piece Cn1 = new Cavalier("♞","noir",7,1);
		Piece Fn1= new Fou("♝","noir",7,2);		
		Piece rn = new Reine("♛","noir",7,3);
		Piece Rn = new Roi("♚","noir",7,4);
		Piece Fn2 = new Fou("♝","noir",7,5);
		Piece Cn2 = new Cavalier("♞","noir",7,6);
		Piece Tn2 = new Tour("♜","noir",7,7);
		Piece Pn1 = new Pion("♟","noir",6,0);
		Piece Pn2 = new Pion("♟","noir",6,1);
		Piece Pn3 = new Pion("♟","noir",6,2);
		Piece Pn4 = new Pion("♟","noir",6,3);
		Piece Pn5 = new Pion("♟","noir",6,4);
		Piece Pn6 = new Pion("♟","noir",6,5);
		Piece Pn7 = new Pion("♟","noir",6,6);
		Piece Pn8 = new Pion("♟","noir",6,7);

		
		
		
		if(cmpt == 1)
		{
			this.listesPiece.add(Tb1);
			this.listesPiece.add(Cb1);
			this.listesPiece.add(Fb1); 			
			this.listesPiece.add(rb);
			this.listesPiece.add(Rb); 			
			this.listesPiece.add(Fb2); 
			this.listesPiece.add(Cb2);
			this.listesPiece.add(Tb2); 	
			this.listesPiece.add(Pb1);
			this.listesPiece.add(Pb2);
			this.listesPiece.add(Pb3);
			this.listesPiece.add(Pb4);
			this.listesPiece.add(Pb5);
			this.listesPiece.add(Pb6);
			this.listesPiece.add(Pb7);
			this.listesPiece.add(Pb8);


			p.initPiece(this);
			this.idJoueur = 1;
		}
		
		else
		{
			this.listesPiece.add(Tn1);
			this.listesPiece.add(Cn1);
			this.listesPiece.add(Fn1); 			
			this.listesPiece.add(rn);
			this.listesPiece.add(Rn); 			
			this.listesPiece.add(Fn2); 
			this.listesPiece.add(Cn2);
			this.listesPiece.add(Tn2);
			this.listesPiece.add(Pn1);
			this.listesPiece.add(Pn2);
			this.listesPiece.add(Pn3);
			this.listesPiece.add(Pn4);
			this.listesPiece.add(Pn5);
			this.listesPiece.add(Pn6);
			this.listesPiece.add(Pn7);
			this.listesPiece.add(Pn8);
			
			p.initPiece(this);
			this.idJoueur = 2;


		}
		
		cmpt++;
	}
	
	/**
	 * Permet de faire jouer un Humain ou une IA
	 * @param plateau Plateau de jeu
	 * @param undo Pile enregistrant les deplacement
	 * @param joueurAdverse Joueur ennemi
	 * @throws InterruptedException Temp d'attente avant que l'IA joue
	 */
	public void jouer(Plateau plateau,Deplacement undo,Joueur joueurAdverse) throws InterruptedException
	{
		if(this.typeJoueur.equals("Humain"))
		{
			converte(plateau,undo,joueurAdverse);
			clearScreen();
			plateau.affichePlateau();
		}
		
		else
		{
			Thread.sleep(200);
			IA(plateau,joueurAdverse,undo);
			clearScreen();
			plateau.affichePlateau();
		}
		
	}
	
	/**
	 * Renvoi la liste de piece du joueur
	 * @return Retourne une liste
	 */
	public ArrayList<Piece> getList()
	{
		return this.listesPiece;
	}
	
	/**
	 * Renvoi la valeur du compteur du nombre de joueurs
	 * @return Retourne un int
	 */
	public int getCmpt()
	{
		return Joueur.cmpt;
	}
	
	/**
	 * Renvoi l'identifiant du joueur
	 * @return Retourne un int
	 */
	public int getidJoueur()
	{
		return this.idJoueur;
	}
	
	/**
	 * Permet au joueur de jouer et de verifier si le Roi est en echec
	 * @param p Plateau de jeu
	 * @param undo Pile enregistrant les deplacement
	 * @param joueurAdverse Joueur ennemi
	 * @return Retourne vrai ou faux
	 */
	public boolean converte(Plateau p,Deplacement undo,Joueur joueurAdverse)
	{
		String entreConsole = this.lireEntreeClavier();
	    int index = 0;

		
        if(entreConsole.equals("u"))
        {     	
        	this.undo(p, undo);
        	return true;
        }
        
        else
        {   		
        	
        	while(this.searchKing(this).echec(p,joueurAdverse,undo) != null)
        	{
        		
        		if(this.searchKing(this).defenseDuRoi(p, this.converteDepart(entreConsole),this.convertArrive(entreConsole),this.searchKing(this).echec(p,joueurAdverse,undo).pos, this, undo))
    			{
    				return true;
    			}
    			
        		else if(this.searchKing(this).fuiteDuRoi(p, this.convertArrive(entreConsole), this, joueurAdverse,undo))
    			{
    				return true;
    			}
    			
    			else if(this.searchKing(this).attaqueAllie(p,this.converteDepart(entreConsole), this.convertArrive(entreConsole),this.searchKing(this).echec(p,joueurAdverse,undo).pos, this, undo))
				{
    				return true;
				}
				
				/*else if(this.searchKing(this).sacrificeAllie(p,this.converteDepart(entreConsole), this.convertArrive(entreConsole), this, joueurAdverse, undo))
				{
					return true;
				}*/
    			 
        	
    			System.out.println("Votre roi est en Echec");
     			entreConsole = this.lireEntreeClavier();
     			
        	}
        		
        	    
        		for(Piece piece : this.listesPiece)
        		{
        			if(piece.pos.getX() ==  this.converteDepart(entreConsole).getX() && piece.pos.getY() == this.converteDepart(entreConsole).getY())
        			{
        				if(piece.deplacer(p,this.convertArrive(entreConsole),this,undo) )
        				{        						
        					for(Piece pieceAdverse : joueurAdverse.getList())
        					{
        						if(pieceAdverse.pos.getX() == this.convertArrive(entreConsole).getX() &&  pieceAdverse.pos.getY() == this.convertArrive(entreConsole).getY())
        						{
        							index = joueurAdverse.getList().indexOf(pieceAdverse);
        						}
        					}
        					
        					joueurAdverse.getList().remove(index);
            				return true;
        				}
        			}
        		}
        			
        }
        
        return false;
	}
	
	/**
	 * Permet à l'utilisateur de renseigner un deplacement
	 * @return Retourne un String
	 */
	public String lireEntreeClavier()
	{
		Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un deplacement Joueur" + this.idJoueur);
        String entreConsole = sc.nextLine();
        
        return entreConsole;
        
	}
	
	/**
	 * Permet de revenir en arriere au cour du jeu
	 * @param p Plateau de jeu
	 * @param undo Pile enregistrant les deplacement
	 */
	public void undo(Plateau p, Deplacement undo)
	{
		p.videPlateau(undo.getPosition().lastElement());
    	
    	if(!undo.getPieceManger().empty() && undo.getPieceManger().lastElement() !=null)
		{
			if(undo.getPosition().lastElement().getX() == undo.getPieceManger().lastElement().pos.getX() && undo.getPosition().lastElement().getY() == undo.getPieceManger().lastElement().pos.getY())
        	{
        		p.setPlateau(undo.getPieceManger().lastElement(),undo.getPieceManger().lastElement().pos.getX(),undo.getPieceManger().lastElement().pos.getY());
            	
      			undo.videPieceManger();      		
        	}
		}
    	
    	else 
    	{ 
    		if(!undo.getPieceManger().empty())
    		{
    			undo.videPieceManger();
    		}
    	}

    	 
    	undo.videPosition();
    	p.setPlateau(undo.getPiece().lastElement(), undo.getPosition().lastElement().getX(), undo.getPosition().lastElement().getY());
    	
    	undo.getPiece().lastElement().pos.setX(undo.getPosition().lastElement().getX()); 
    	undo.getPiece().lastElement().pos.setY(undo.getPosition().lastElement().getY());  

    	
    	
    	undo.videPiece();
    	undo.videPosition();
	}
	
	/**
	 * Converti le String de l'utilisateur en position de depart
	 * @param entreConsole String renseigner par l'utilisateur
	 * @return Retourne une Position
	 */
	public Position converteDepart(String entreConsole)
	{
		String str[] = entreConsole.split("");
        
        int posX = 0;
        int posY = 0;
        
		   switch (str[0])
           {
             case "a":
            	posY = 0;
           	break; 
             case "b":
                 posY=1;
                 break; 
             case "c":
                 posY = 2;
                 break; 
             case "d":
           	  posY = 3;
                 break; 
             case "e":
           	  posY = 4;
                 break; 
             case "f":
           	  posY = 5;
                 break; 
             case "g":
           	  posY = 6;
                 break; 
             case "h":
           	  posY = 7;
                 break; 
             default:  
           	  break;
           }
           
           switch (str[1])
           {
             case "1":
             	  posX = 7;
             	  break; 
             case "2":
                 posX = 6;
                 break; 
             case "3":
                 posX = 5;
                 break; 
             case "4":
           	  posX = 4;
                 break; 
             case "5":
           	  posX = 3;
                 break; 
             case "6":
           	  posX = 2;
                 break; 
             case "7":
           	  posX = 1;
                 break; 
             case "8":
           	  posX = 0;
                 break; 
             default:  
           	  break;
           }
           
   		Position pos = new Position(posX,posY);
   		
   		return pos;

	}
	
	/**
	 * Converti le String de l'utilisateur en position d'arrive
	 * @param entreConsole String renseigner par l'utilisateur
	 * @return Retourne une Position
	 */
	public Position convertArrive(String entreConsole)
	{
		  String str[] = entreConsole.split("");
                 
          int arriveX = 0;
          int arriveY = 0;
          
       
          
          switch (str[2])
          {
            case "a":
          	  arriveY = 0;
          	  break; 
            case "b":
                arriveY=1;
                break; 
            case "c":
                arriveY = 2;
                break; 
            case "d":
          	  arriveY = 3;
                break; 
            case "e":
          	  arriveY = 4;
                break; 
            case "f":
          	  arriveY = 5;
                break; 
            case "g":
          	  arriveY = 6;
                break; 
            case "h":
          	  arriveY = 7;
                break; 
            default:  
          	  break;
          }
          
          switch (str[3])
          {
            case "1":
          	  arriveX = 7;
                break; 
            case "2":
          	  arriveX = 6;
                break; 
            case "3":
          	  arriveX = 5;
                break; 
            case "4":
          	  arriveX = 4;
                break; 
            case "5":
          	  arriveX = 3;
                break; 
            case "6":
          	  arriveX = 2;
                break; 
            case "7":
          	  arriveX = 1;
                break; 
            case "8":
          	  arriveX = 0;
          	  break; 
            default:  
          	  break;
          }
          
  		Position deplacement = new Position(arriveX,arriveY);
  		
  		return deplacement;
	}
	
	/**
	 * Cherche le roi dans la liste du joueur
	 * @param joueur joueur actuel
	 * @return Retourne le Roi ou null
	 */
	public Roi searchKing(Joueur joueur)
	{
		for(Piece piece : joueur.getList())
		{
			if(piece instanceof Roi)
			{
				return (Roi)piece;
			}
		}
		
		return null;
		
	}
	
	/**
	 * Efface la console
	 */
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  

	/**
	 * Permet à l'IA de jouer
	 * @param p Plateau de jeu
	 * @param joueurAdverse joueur ennemi
	 * @param undo Pile enregistrant les deplacement
	 * @return Retourne un boolean
	 */
	public boolean IA(Plateau p,Joueur joueurAdverse,Deplacement undo)
	{
		int index = 0;
		
		int valeurMin = 0;
		int valeurMax = 7;
		boolean bool = false;
		
		Random r = new Random();
	
		while(bool == false)
		{
	
			int arriveX = valeurMin + r.nextInt(valeurMax - valeurMin);
			int arriveY = valeurMin + r.nextInt(valeurMax - valeurMin);
			
			Position arrive = new Position(arriveX,arriveY);
			
			for(Piece pieceIA : this.listesPiece)
			{			
				Position depart = new Position(pieceIA.pos.getX(),pieceIA.pos.getY());
				
					if(pieceIA.deplacer(p, arrive, this, undo))
					{
						for(Piece pieceAdverse : joueurAdverse.getList())
    					{
    						if(pieceAdverse.pos.getX() == arrive.getX() &&  pieceAdverse.pos.getY() == arrive.getY())
    						{
    							index = joueurAdverse.getList().indexOf(pieceAdverse);
    						}
    					}
    					
    					joueurAdverse.getList().remove(index);
        				return true;
					}
					
					pieceIA.deplacer(p, depart, this, undo);		
			}
    		
		}
	
		return false;
	}

}

