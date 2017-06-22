package cse1030.games.tetris;

import java.awt.Color;

import cse1030.drawing.IPoint2D;
import cse1030.drawing.SimpleDrawing4;

public class JBlock extends Block {

	private int angle = 0;

	public JBlock(IPoint2D pos, Color col) {
		super(3, pos, col);
		for (int i = 0; i <= 2; i++) {
			this.grid.set(1, i);
		}
		this.grid.set(0, 0);

	}

	@Override
	public void spinLeft() {
		this.angle = this.angle + 90;
		this.grid.clearAll();

		if (this.angle == 90) {
			for (int i = 0; i <= 2; i++) {
				this.grid.set(i, 1);
			}
			this.grid.set(2, 0);
		}
		if (this.angle == 180) {
			for (int i = 0; i <= 2; i++) {
				this.grid.set(1, i);
			}
			this.grid.set(2, 2);

		}
		if (this.angle == 270) {
			for (int i = 0; i <= 2; i++) {
				this.grid.set(i, 1);
			}
			this.grid.set(0, 2);
		}

		if (this.angle == 360) {
			for (int i = 0; i <= 2; i++) {
				this.grid.set(1, i);
			}
			this.grid.set(0, 0);
			this.angle = 0;
		}
		SimpleDrawing4.clear();
		this.draw();

	}

	@Override
	public void SpinRight() {
		this.angle = this.angle - 90;
		if (angle < 0) {
			this.angle = 270;
		}
		this.grid.clearAll();

		if (this.angle == 90) {
			for (int i = 0; i <= 2; i++) {
				this.grid.set(i, 1);
			}
			this.grid.set(2, 0);
		}
		if (this.angle == 180) {
			for (int i = 0; i <= 2; i++) {
				this.grid.set(1, i);
			}
			this.grid.set(2, 2);

		}
		if (this.angle == 270) {
			for (int i = 0; i <= 2; i++) {
				this.grid.set(i, 1);
			}
			this.grid.set(0, 2);
		}

		if (this.angle == 0) {
			for (int i = 0; i <= 2; i++) {
				this.grid.set(1, i);
			}
			this.grid.set(0, 0);

		}
		SimpleDrawing4.clear();
		this.draw();

	}
}
