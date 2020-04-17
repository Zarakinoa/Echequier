import java.util.Stack;

public class Deplacement {
	private Stack <Piece> stackPiece;
	private Stack <Position> stackPosition;
	private Stack <Piece> stackPieceManger;
	
	/**
	 * Initialise un deplacement 
	 */
	public Deplacement()
	{

		this.stackPiece = new Stack<Piece>();
		this.stackPosition = new Stack<Position>();
		this.stackPieceManger = new Stack<Piece>();
	}
	
	/**
	 * Renvoi le stock des pieces déplacée
	 * @return Retourne une pile
	 */
	public Stack<Piece> getPiece()
	{
		return this.stackPiece;
	}
	
	/**
	 * Met à jour le stock de piece déplacée
	 * @param p Piece deplacer à stocker
	 */
	public void setPiece(Piece p)
	{
		this.stackPiece.push(p);
	}
	
	/**
	 * Supprime la derniere piece déplacée stocker
	 */
	public void videPiece()
	{
		this.stackPiece.pop();
	}
	
	/**
	 * 	Renvoi le stock de position des pieces enregistree
	 * @return Retourne une pile
	 */
	public Stack<Position> getPosition()
	{
		return this.stackPosition;
	}
	
	/**
	 * Met à jour le stock de position des pieces enregistree
	 * @param pos Position de la dernere piece stocker
	 */
	public void setPosition(Position pos)
	{
		this.stackPosition.push(pos);
	}
	
	/**
	 * Supprime la derniere position stocker
	 */
	public void videPosition()
	{
		this.stackPosition.pop();
	}
	
	
	/**
	 * Renvoi le stock de piece manger
	 * @return Retourne une pile
	 */
	public Stack<Piece> getPieceManger()
	{
		return this.stackPieceManger;
	}
	
	/**
	 * Met à jour le stock de piece manger
	 * @param p Piece manger à stocker
	 */
	public void setPieceManger(Piece p)
	{
		this.stackPieceManger.push(p);
	}
	
	/**
	 * Supprime la derniere piece manger stocker
	 */
	public void videPieceManger()
	{
		this.stackPieceManger.pop();
	}

}
