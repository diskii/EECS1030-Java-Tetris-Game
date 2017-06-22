package cse1030.games.tetris;

import java.awt.Color;

import cse1030.drawing.IPoint2D;
import cse1030.drawing.SimpleDrawing4;



public class IBlock extends Block {
	
	private int angle = 0;
	
	public IBlock(IPoint2D pos , Color col){
		super(4, pos,col);
		for(int i = 0 ; i<=3 ; i++){
			this.grid.set(1, i);
		}
	}

	@Override
	public void spinLeft() {
		this.angle = angle+90;
		this.grid.clearAll();
		
		if(this.angle == 90){
			for(int i = 0 ; i<=3 ; i++){
				this.grid.set(i,1);
			}
		}
			
		if(this.angle == 180){
			for(int i = 0 ; i<=3 ; i++){
				this.grid.set(2, i);
			}
		}
		if(this.angle == 270){
			for(int i = 0 ; i<=3 ; i++){
				this.grid.set(i,2 );
			}
		}
		
		if(this.angle == 360){
			for(int i = 0 ; i<=3 ; i++){
				this.grid.set(1,i);
				
			}
			this.angle=0;
		}
		SimpleDrawing4.clear();
		this.draw();
		
	
	}

	@Override
	public void SpinRight() {
		
		this.angle = angle-90;
		if(angle<0){
			this.angle = 270;
		}
		this.grid.clearAll();
		
		if(this.angle == 90){
			for(int i = 0 ; i<=3 ; i++){
				this.grid.set(i,2);
			}
		}
			
		if(this.angle == 180){
			for(int i = 0 ; i<=3 ; i++){
				this.grid.set(2, i);
			}
		}
		if(this.angle == 270){
			for(int i = 0 ; i<=3 ; i++){
				this.grid.set(i,2 );
			}
		}
		
		if(this.angle == 0){
			for(int i = 0 ; i<=3 ; i++){
				this.grid.set(1,i);
				
			}
			
		}
		SimpleDrawing4.clear();
		this.draw();
	
	}	
	
}


