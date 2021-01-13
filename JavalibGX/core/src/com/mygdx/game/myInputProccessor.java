package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import java.util.ArrayList;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class myInputProccessor extends MyGdxGame implements InputProcessor {
	public ClickablBox flaggedBox;
	ArrayList<ClickablBox> ListOfBoxes = new ArrayList<ClickablBox>(1);
	public myInputProccessor(ArrayList<ClickablBox> LisOfBoxes) {
		for (ClickablBox each : LisOfBoxes) {
		this.ListOfBoxes.add(each);}
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(button == Input.Buttons.LEFT) {
			System.out.println(""+screenX+" "+ screenY );
			for(ClickablBox box : ListOfBoxes) {
				float xpos = box.sprite.getX()+box.sprite.getWidth()/2;
				float ypos = Gdx.graphics.getHeight()-box.sprite.getY()-box.sprite.getHeight()/2;
				if(Math.abs(xpos-screenX)<=box.sprite.getWidth() && (Math.abs(ypos-screenY)<=box.sprite.getHeight())) {
					flaggedBox = box;
					
					
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}

}
