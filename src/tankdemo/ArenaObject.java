package tankdemo;


/**
 * Parent class for any object that is displayed on the arena window.
 */
abstract public class ArenaObject {

    /**
     * X coordinate, measured in pixels, from the left side of the screen to the
     * left edge of the object.
     */
    float x = 100;

    /**
     * Y coordinate, measured in pixels, from the top side of the screen to the
     * top edge of the object.
     */
    float y = 100;

    /**
     * Width of the object, measured in pixels.
     */
    float width = 100;

    /**
     * Height of the object, measured in pixels.
     */
    float height = 100;

    /**
     * Move the object and then draw it.
     * 
     * @param dt time since the last run, measured in seconds.
     * @return whether the object should stay alive into the next iteration.
     */
    abstract public boolean run(float dt);

    /**
     * @return the current horizontal position in pixels from the left edge of
     *         the screen to this object's leftmost edge.
     */
    public float getX() {
        return x;
    }

    /**
     * @return the current vertical position in pixels from the top edge of the
     *         screen to this object's top edge.
     */
    public float getY() {
        return y;
    }

    /** @return width of this object in pixels. */
    public float getWidth() {
        return width;
    }

    /** @return height of this object in pixels. */
    public float getHeight() {
        return height;
    }

    /** @return whether this object intersects with the other. */
    public boolean intersects(ArenaObject other) {
        if (this.getX() + this.getWidth() < other.getX()) {
            // This object is too far to the left of the other object
            return false;
        }
        if (this.getX() > other.getX() + other.getWidth()) {
            // This object is too far to the right of the other object
            return false;
        }
        if (this.getY() + this.getHeight() < other.getY()) {
            // This object is too far above the other object
            return false;
        }
        if (this.getY() > other.getY() + other.getHeight()) {
            // This object is too far below the other object
            return false;
        }
        return true;
    }

}
