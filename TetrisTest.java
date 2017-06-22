package cse1030.games.tetris;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import cse1030.drawing.IPoint2D;
import cse1030.drawing.SimpleDrawing4;

public class TetrisTest implements ActionListener {

	private Timer timer;
	private Block block;
	private boolean isFalling;

	public TetrisTest() {
		this.timer = new Timer(500, this);
		this.isFalling = false;
	}

	public void run() {
		this.block = TetrisTest.randomBlock();
		this.block.draw();
		this.timer.start();

		while (true) {
			if (SimpleDrawing4.hasNextKeyTyped()) {
				char c = SimpleDrawing4.nextKeyTyped();
				if (c == 'j') {
					this.block.moveLeft();
				} else if (c == 'l') {
					this.block.moveRight();
				} else if (c == 'i') {
					this.block.spinLeft();
				} else if (c == 'k') {
					this.block.SpinRight();
				} else if (c == 's') {
					this.isFalling = !this.isFalling;
				} else if (c == 'q') {
					this.timer.stop();
					break;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.isFalling) {
			this.block.moveDown();
			if (this.block.getPosition().getY() < -0.1) {
				this.block = TetrisTest.randomBlock();
				this.block.draw();
			}
		}
	}

	public static Block randomBlock() {
		Random r = new Random();
		int val = r.nextInt(3);
		Block b = null;
		switch (val) {
		case 0:
			b = new IBlock(new IPoint2D(4, 20), Color.CYAN);
			break;
		case 1:
			b = new JBlock(new IPoint2D(4, 20), Color.BLUE);
			break;
		case 2:
			b = new SBlock(new IPoint2D(4, 20), Color.GREEN);
			break;
		}
		return b;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TetrisTest test = new TetrisTest();
		test.run();
		SimpleDrawing4.close();
	}

}
