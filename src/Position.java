
public class Position {

	private int x;
	private int y;
	
	/**
	 * Initialise une position
	 * @param x Position en x
	 * @param y Position en y
	 */
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Renvoi la position en x
	 * @return Retourne un int
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Renvoi la position en y
	 * @return Retourne un int
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Modifie la position en x
	 * @param x Position en x
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * Modifie la position en y
	 * @param y Position en y
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**
	 * Renvoi la position sous chaine de caractere ✔
	 */
	public String toString()
	{
		return this.x + " " + this.y;
	}
}
