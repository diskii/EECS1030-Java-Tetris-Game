//cse13175 , Jeffrey Young
package cse1030.games.tetris;

import java.awt.Color;

import cse1030.drawing.IPoint2D;
import cse1030.drawing.SimpleDrawing4;

public class SBlock extends Block {

	private int angle = 0;

	public SBlock(IPoint2D pos, Color col) {
		super(3, pos, col);
		for (int i = 1; i <= 2; i++) {
			this.grid.set(0, i);
		}
		this.grid.set(1, 0);
		this.grid.set(1, 1);

	}

	@Override
	public void spinLeft() {
		this.angle = this.angle + 90;
		this.grid.clearAll();

		if (this.angle == 90) {

			this.grid.set(0, 0);
			this.grid.set(1, 0);
			this.grid.set(1, 1);
			this.grid.set(2, 1);
		}

		if (this.angle == 180) {
			for (int i = 1; i <= 2; i++) {
				this.grid.set(1, i);
			}
			this.grid.set(2, 0);
			this.grid.set(2, 1);
		}
		if (this.angle == 270) {
			this.grid.set(0, 1);
			this.grid.set(1, 1);
			this.grid.set(1, 2);
			this.grid.set(2, 2);
		}

		if (this.angle == 360) {
			for (int i = 1; i <= 2; i++) {
				this.grid.set(0, i);
			}
			this.grid.set(1, 0);
			this.grid.set(1, 1);
			this.angle = 0;
		}
		
		SimpleDrawing4.clear();
		this.draw();

	}

	@Override
	public void SpinRight() {
		this.angle = this.angle - 90;
		if (this.angle < 0) {
			this.angle = 270;
		}
		this.grid.clearAll();

		if (this.angle == 90) {
			this.grid.set(0, 0);
			this.grid.set(1, 0);
			this.grid.set(1, 1);
			this.grid.set(2, 1);
		}

		if (this.angle == 180) {
			for (int i = 1; i <= 2; i++) {
				this.grid.set(1, i);
			}
			this.grid.set(2, 0);
			this.grid.set(2, 1);
		}
		if (this.angle == 270) {
			this.grid.set(0, 1);
			this.grid.set(1, 1);
			this.grid.set(1, 2);
			this.grid.set(2, 2);
		}

		if (this.angle == 0) {
			for (int i = 1; i <= 2; i++) {
				this.grid.set(0, i);
			}
			this.grid.set(1, 0);
			this.grid.set(1, 1);
		}
		
		SimpleDrawing4.clear();
		this.draw();

	}
}
