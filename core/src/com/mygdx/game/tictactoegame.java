package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class tictactoegame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img,background,cross,circle,p1win,p2win;
        public static final int WIDTH = 800;
        public static final int HEIGHT = 800;
        int arr[];
	int player, win;
        Boolean end=false;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
                background = new Texture("tictactoe_board.png");
                cross= new Texture("tictactoe_cross.png");
                circle= new Texture("tictactoe_circle.png");
                p1win = new Texture("p1win.jpg");
                p2win = new Texture("p2win.jpg");
                arr = new int[9];
                for(int i=0;i<9;i++){
                    arr[i]=0;
                }
                player=1;
                win=0;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
                batch.begin();
                batch.draw(background,0,0,WIDTH,HEIGHT);
                
                
                if(arr[0]==arr[1] && arr[0]==arr[2]){
                    if(arr[0]==1){
                        win=1;
                        end=true;
                    }else if(arr[0]==2){
                        win=2;
                        end=true;
                    }
                }else if(arr[3]==arr[4] && arr[3]==arr[5]){
                    if(arr[3]==1){
                        win=1;
                        end=true;
                    }else if(arr[3]==2){
                        win=2;
                        end=true;
                    }
                }else if(arr[6]==arr[7] && arr[6]==arr[8]){
                   if(arr[6]==1){
                        win=1;
                        end=true;
                    }else if(arr[6]==2){
                        win=2;
                        end=true;
                    }
                }else if(arr[0]==arr[3] && arr[0]==arr[6]){
                    if(arr[0]==1){
                        win=1;
                        end=true;
                    }else if(arr[0]==2){
                        win=2;
                        end=true;
                    }
                }else if(arr[1]==arr[4] && arr[1]==arr[7]){
                    if(arr[1]==1){
                        win=1;
                        end=true;
                    }else if(arr[1]==2){
                        win=2;
                        end=true;
                    } 
                }else if(arr[2]==arr[5] && arr[2]==arr[8]){
                    if(arr[2]==1){
                        win=1;
                        end=true;
                    }else if(arr[2]==2){
                        win=2;
                        end=true;
                    }
                }else if(arr[0]==arr[4]&& arr[0]==arr[8]){
                    if(arr[0]==1){
                        win=1;
                        end=true;
                    }else if(arr[0]==2){
                        win=2;
                        end=true;
                    }
                }else if(arr[2]==arr[4]&& arr[2]==arr[6]){
                  if(arr[2]==1){
                        win=1;
                        end=true;
                    }else if(arr[2]==2){
                        win=2;
                        end=true;
                    }
                }
                
                if(end==false){
                    if(Gdx.input.getX()<250 && Gdx.input.getY()<250){    
                    if(Gdx.input.justTouched()){
                        if(arr[0]==0){
                            if(player==1){
                                arr[0] = 1;
                                player=2;
                            }else{
                                arr[0] = 2;
                                player=1;
                            }
                         }
                        System.out.printf("Array 0\n");
                    }
                    
                }else if(Gdx.input.getX()<520 && Gdx.input.getY()<250 && Gdx.input.getX()>283 ){
                    if(Gdx.input.justTouched()){
                        if(arr[1]==0){
                            if(player==1){
                                arr[1] = 1;
                                player=2;
                            }else{
                                arr[1] = 2;
                                player=1;
                            }
                         }
                        System.out.printf("Array 1\n");
                    }
                }else if(Gdx.input.getX()<800 && Gdx.input.getY()<250 && Gdx.input.getX()>550 ){
                    if(Gdx.input.justTouched()){
                        if(arr[2]==0){
                            if(player==1){
                                arr[2] = 1;
                                player=2;
                            }else{
                                arr[2] = 2;
                                player=1;
                            }
                        }
                        System.out.printf("Array 2\n");
                    }
                }else if(Gdx.input.getX()<=250 && Gdx.input.getY()<520 && Gdx.input.getY()>283 ){
                    if(Gdx.input.justTouched()){
                        if(arr[3]==0){
                            if(player==1){
                                arr[3] = 1;
                                player=2;
                            }else{
                                arr[3] = 2;
                                player=1;
                            }
                        }
                        System.out.printf("Array 3\n");
                    }
                }else if(Gdx.input.getX()<520 && Gdx.input.getY()<520 && Gdx.input.getY()>283 && Gdx.input.getX()>283 ){
                    if(Gdx.input.justTouched()){
                        if(arr[4]==0){
                            if(player==1){
                                arr[4] = 1;
                                player=2;
                            }else{
                                arr[4] = 2;
                                player=1;
                            }
                        }
                        System.out.printf("Array 4\n");
                    }
                }else if(Gdx.input.getX()<800 && Gdx.input.getY()<520 && Gdx.input.getY()>283 && Gdx.input.getX()>550 ){
                    if(Gdx.input.justTouched()){
                        if(arr[5]==0){
                            if(player==1){
                                arr[5] = 1;
                                player=2;
                            }else{
                                arr[5] = 2;
                                player=1;
                            }
                        }
                        System.out.printf("Array 5\n");
                    }
                }else if(Gdx.input.getX()<250 && Gdx.input.getY()<800 && Gdx.input.getY()>550 ){
                    if(Gdx.input.justTouched()){
                        if(arr[6]==0){
                            if(player==1){
                                arr[6] = 1;
                                player=2;
                            }else{
                                arr[6] = 2;
                                player=1;
                            }
                        }
                        System.out.printf("Array 6\n");
                    }
                }else if(Gdx.input.getX()<520 && Gdx.input.getY()<800 && Gdx.input.getY()>550 &&Gdx.input.getX()>283){
                    if(Gdx.input.justTouched()){
                        if(arr[7]==0){
                            if(player==1){
                                arr[7] = 1;
                                player=2;
                            }else{
                                arr[7] = 2;
                                player=1;
                            }
                        }
                        System.out.printf("Array 7\n");
                    }
                }else if(Gdx.input.getX()<800 && Gdx.input.getY()<800 && Gdx.input.getY()>550 && Gdx.input.getX()>550 ){
                    if(Gdx.input.justTouched()){
                        if(arr[8]==0){
                            if(player==1){
                                arr[8] = 1;
                                player=2;
                            }else{
                                arr[8] = 2;
                                player=1;
                            }
                        }
                        System.out.printf("Array 8\n");
                    }
                }
                }
                
                
                
                if (win==0){
                    if(arr[0]==1){
                    batch.draw(circle,0,550,250,250);
                }else if(arr[0]==2){
                    batch.draw(cross,0,550,250,250);
                }
                if(arr[1]==1){
                    batch.draw(circle,280,550,250,250);
                }else if(arr[1]==2){
                    batch.draw(cross,280,550,250,250);
                }
                if(arr[2]==1){
                    batch.draw(circle,550,550,250,250);
                }else if(arr[2]==2){
                    batch.draw(cross,550,550,250,250);
                }
                if(arr[3]==1){
                    batch.draw(circle,0,280,250,250);
                }else if(arr[3]==2){
                    batch.draw(cross,0,280,250,250);
                }
                if(arr[4]==1){
                    batch.draw(circle,280,280,250,250);
                }else if(arr[4]==2){
                    batch.draw(cross,280,280,250,250);
                }
                if(arr[5]==1){
                    batch.draw(circle,550,280,250,250);
                }else if(arr[5]==2){
                    batch.draw(cross,550,280,250,250);
                }
                if(arr[6]==1){
                    batch.draw(circle,0,0,250,250);
                }else if(arr[6]==2){
                    batch.draw(cross,0,0,250,250);
                }
                if(arr[7]==1){
                    batch.draw(circle,280,0,250,250); 
                }else if(arr[7]==2){
                    batch.draw(cross,280,0,250,250);
                }
                if(arr[8]==1){
                    batch.draw(circle,550,0,250,250);
                }else if(arr[8]==2){
                    batch.draw(cross,550,0,250,250);
                }
                }else if(win==1){
                    batch.draw(p1win,0,0,800,800);
                }else if(win==2){
                    batch.draw(p2win,0,0,800,800);
                }
                
                
                
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
