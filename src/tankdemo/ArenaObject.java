package tankdemo;

/**
 * All objects that display on the screen should implement this interface.
 */
public interface ArenaObject {

	/**
	 * Move the object and then draw it.
	 * 
	 * @param dt time since the last run, measured in seconds.
	 * @return whether the object should stay alive into the next iteration.
	 */
	public boolean run(float dt);
	
	/**
	 * @return the current horizontal position in pixels from the left edge of
	 *         the screen to this object's leftmost edge.
	 */
	public float getX();

	/**
	 * @return the current vertical position in pixels from the top edge of the
	 *         screen to this object's top edge.
	 */
	public float getY();
	
	/** @return width of this object in pixels. */
	public float getWidth();
	
	/** @return height of this object in pixels. */
	public float getHeight();
	
	/** @return whether the current object intersects with the other. */
	public boolean intersects(ArenaObject other);
	
}
