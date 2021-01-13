package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	ClickablBox tagged;
	private float InterVal = 2;
	private BitmapFont font;
	private int ClickerCounter;
	Texture img;
	private ShapeRenderer squareCurs;
	ClickablBox boxx;
	ArrayList<ClickablBox> listOfBoxes = new ArrayList<ClickablBox>(0);	
	myInputProccessor proc;
	
	
	public void everyTwo() {
		for(int i = 0; i < listOfBoxes.size(); i++) {
			if(listOfBoxes.get(i).actKey == 0) {
				listOfBoxes.get(i).actKey ++;
			}
			else if(listOfBoxes.get(i).actKey == 1) {
				listOfBoxes.get(i).actKey ++;
				listOfBoxes.get(i).sprite.setTexture(new Texture("Red.png"));
			}
			else if(listOfBoxes.get(i).actKey == 2) {
				listOfBoxes.get(i).actKey ++;
				listOfBoxes.get(i).sprite.setTexture(new Texture("Kaboom.jpg"));
			}
			else if(listOfBoxes.get(i).actKey == 3) {
				listOfBoxes.get(i).actKey = 0;
				listOfBoxes.remove(i);
			}
		}
	}
	
	@Override
	public void create () {
		Gdx.graphics.setTitle("Java Small Clicker");
		ClickerCounter = 0;
		batch = new SpriteBatch();
		font = new BitmapFont();
		for(int i = 0; i < 5; i++) {
		listOfBoxes.add(new ClickablBox());}
		squareCurs = new ShapeRenderer();
		img = new Texture("fortnite.jpg");
		squareCurs.setProjectionMatrix(batch.getProjectionMatrix());
		squareCurs.setAutoShapeType(true);
		proc = new myInputProccessor(listOfBoxes);
		Gdx.input.setInputProcessor(new InputProcessor() {
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				if(button == Input.Buttons.LEFT) {
					for(ClickablBox box : listOfBoxes) {
						float xpos = box.sprite.getX()+box.sprite.getWidth()/2;
						float ypos = Gdx.graphics.getHeight()-box.sprite.getY()-box.sprite.getHeight()/2;
						if(Math.abs(xpos-screenX)<=box.sprite.getWidth() && (Math.abs(ypos-screenY)<=box.sprite.getHeight())) {
							tagged = box;
							ClickerCounter++;
						}
					}
					listOfBoxes.remove(tagged);
					return true;
				}
				return false;
			}

			@Override
			public boolean keyDown(int keycode) {
				if(keycode == Input.Keys.ENTER) {
					ClickerCounter = 0;
				}
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
		});
	}
	float clock = 0;
	@Override
	public void render () {
	try {
		clock += Gdx.graphics.getDeltaTime();
		if(clock > .35) {
			this.everyTwo();
			clock = 0;
		}
		int len = listOfBoxes.size();
		if(len < 3) {
			listOfBoxes.add(new ClickablBox());
		}
	
		batch.begin();
		squareCurs.begin();
		font.draw(batch, Integer.toString(ClickerCounter), 20, 450);
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		for(ClickablBox each : listOfBoxes) {
		    each.sprite.draw(batch);
		}
	}
	catch(Exception E){
		System.out.println(E);
	}
	batch.end();
	squareCurs.end();
	}
		
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
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
		// TODO Auto-generated method stub
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
