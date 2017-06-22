package cse1030.games.tetris;

import java.awt.Color;
import cse1030.drawing.IPoint2D;
import cse1030.drawing.SimpleDrawing4;

/**
 * Abstract base class for standard Tetris blocks. Blocks can move, spin, and
 * draw themselves.
 * 
 * @author CSE1030_F13_14
 * 
 */
public abstract class Block implements Drawable, Movable, Spinnable {

	/**
	 * The grid that represents the block in its current orientation.
	 */
	protected BlockGrid grid;

	/**
	 * The position on the playing field of the top left corner of the grid.
	 */
	protected IPoint2D position;

	/**
	 * The color o/cse/home/cse13175/workspacef the block.
	 */
	protected Color color;

	/**
	 * Construct a block given its grid size, position, and color.
	 * <code>this.grid</code> will be a <code>BlockGrid</code> of size
	 * <code>gridSize</code>-by-<code>gridSize</code> with all grid locations
	 * cleared.
	 * 
	 * <p>
	 * This constructor should be called only by direct child classes.
	 * 
	 * @pre. <code>gridSize > 0</code>
	 * 
	 * @param gridSize
	 *            the size of the grid
	 * @param pos
	 *            the position on the playing field of the top-left corner of
	 *            the grid
	 * @param col
	 *            the color of the block
	 */
	protected Block(int gridSize, IPoint2D pos, Color col) {
		this.grid = new BlockGrid(gridSize);
		this.position = pos;
		this.color = col;
	}

	/**
	 * Erase the block from the playing field in its current position and
	 * orientation.
	 */
	protected void erase() {
		IPoint2D newpos = IPoint2D(x, this.position.getY());
		this.draw(Color.WHITE);
	}

	/**
	 * Draw the block to the playing field in its current position and
	 * orientation using the specified color.
	 * 
	 * @param c
	 *            the color to draw with
	 */
	protected void draw(Color c) {
		for (int i = 0; i < this.grid.size(); i++) {
			for (int j = 0; j < this.grid.size(); j++) {
				if (this.grid.get(i, j)) {
					IPoint2D topLeft = new IPoint2D(this.position.getX() + j,
							this.position.getY() - i);
					IPoint2D bottomRight = new IPoint2D(topLeft.getX() + 1.,
							topLeft.getY() - 1.);
					SimpleDrawing4.setPenColor(c);
					SimpleDrawing4.drawSquare(topLeft, bottomRight);
				}
			}
		}
	}

	/**
	 * Draw the block on the playing field in its current position and
	 * orientation.
	 * 
	 * @see cse1030.games.tetris.Drawable#draw()
	 */
	@Override
	public void draw() {
		this.draw(this.color);
	}

	/**
	 * Moves the block to the left by 1 grid position and draws the block in its
	 * new position. package cse1030.games.tetris;
	 * 
	 * public class Block {
	 * 
	 * }
	 * 
	 * @see cse1030.games.tetris.Movable#moveLeft()
	 */
	@Override
	public void moveLeft() {
		SimpleDrawing4.clear();
		double x = this.position.getX();
		IPoint2D newpos = new IPoint2D(x - 1, this.position.getY());
		this.position = newpos;
		this.draw();

	}

	/**
	 * Moves the block to the right by 1 grid position and draws the block in
	 * its new position.
	 * 
	 * @see cse1030.games.tetris.Movable#moveRight()
	 */
	@Override
	public void moveRight() {
		SimpleDrawing4.clear();
		double x = this.position.getX();
		IPoint2D newpos = new IPoint2D(x + 1, this.position.getY());
		this.position = newpos;
		this.draw();

	}

	/**
	 * Moves the block down by 1 grid position and draws the bl
	 * 
	 * @see cse1030.games.tetris.Movable#moveDown()
	 */
	@Override
	public void moveDown() {
		SimpleDrawing4.clear();
		double y = this.position.getY();
		IPoint2D newpos = new IPoint2D(this.position.getX(), y - 1);
		this.position = newpos;
		this.draw();

	}

	/**
	 * Moves the block up by 0 grid positions and draws the block in its new
	 * position.
	 * 
	 * @see cse1030.games.tetris.Movable#moveUp()
	 */
	@Override
	public void moveUp() {
		this.draw();

	}

	/**
	 * Get the position on the playing field of the top-left corner of the
	 * block's grid.
	 * 
	 * @return the position on the playing field of the top-left corner of the
	 *         block's grid
	 * 
	 * @see cse1030.games.tetris.Drawable#getPosition()
	 */
	@Override
	public IPoint2D getPosition() {
		return this.position;

	}
}
