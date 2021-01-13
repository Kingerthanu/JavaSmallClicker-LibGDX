package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.Texture;

public class ClickablBox extends Sprite {
	public Sprite sprite;
	public int xBound,yBound,WidthBound,HeightBound;
	public int actKey = 0;
	public ClickablBox() {
		this.xBound = (int)(Math.random()*450);
		this.yBound = (int)(Math.random()*450);
		this.HeightBound = 50;
		this.WidthBound = 50;
		this.create();
	}
	public void create() {
		Texture TEXTURE = new Texture("Blue.jpg");
		this.sprite = new Sprite(TEXTURE);
		this.sprite.setBounds(this.xBound,this.yBound,this.WidthBound,this.HeightBound);

		
		
		
	}
	
	

}
