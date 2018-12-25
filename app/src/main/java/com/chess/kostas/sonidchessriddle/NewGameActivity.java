package com.chess.kostas.sonidchessriddle;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Random;

//*****************************************************************************************************************//
// Basic Activity all action happends
//*****************************************************************************************************************//

public class NewGameActivity extends Activity {


	Button reset, run;
	//ChessBoard game;
	protected TextView origin = null;
	protected TextView destiny = null;
	protected TextView result = null;

	protected TextView horse = null;
	protected TextView king = null;

	int horseX,horseY,kingX,kingY;

	protected boolean firstappearence = true;
	protected boolean secondappearence = false;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game);

		initBoard();

		reset = (Button) findViewById(R.id.resetBtn);
		reset.setText("Reset");
		reset.setTextColor(Color.BLACK);
		reset.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			    king.setText("");
			    horse.setText("");
			    result.setText("");
			    result.scrollTo(0,0);

                 firstappearence = true;
                 secondappearence = false;

			}
		});



		run = (Button) findViewById(R.id.runBtn);
		run.setTextColor(Color.BLACK);
		run.setText("Run");
		run.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				FindAllRoutes();

				}

		});
	}


	public void onBackPressed() {
		AlertDialog.Builder builderConfirmation = new AlertDialog.Builder(this);
		builderConfirmation.setMessage("Are you sure you want to exit the game?")
				.setCancelable(false)
				.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
						NewGameActivity.this.finish();
					}
				})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		AlertDialog alertConfirmation = builderConfirmation.create();
		alertConfirmation.show();
	}



	protected void addHorse(int row, int col) {

			horseX = col;
			horseY = row;

				int id;


					id = UtilityClass.getCellID(row , col );
					horse = (TextView) findViewById(id);


		horse.setBackgroundColor(00000000);
		horse.setShadowLayer(0.0f, 0.0f, 0.0f, Color.WHITE);
		horse.setTextSize(26);
		horse.setText(UtilityClass.getPieceUnicodeID("w","N"));
		horse.setTextColor(Color.BLUE);


				}

	protected void addTarget(int row, int col) {

			kingX = col;
			kingY = row;

		int id;


		id = UtilityClass.getCellID(row , col );
		king = (TextView) findViewById(id);


		king.setBackgroundColor(00000000);
		king.setShadowLayer(0.0f, 0.0f, 0.0f, Color.WHITE);
		king.setTextSize(26);
		king.setText(UtilityClass.getPieceUnicodeID("b","K"));
		king.setTextColor(Color.BLUE);



	}


	protected void initBoard(){


		int i,x;//rows
		int j,z;//col
		for(i=0,x=7;i<8;i++,x--){

			for(j=0,z=7;j<8;j++,z--){


				int id;
				TextView tv;


				id = UtilityClass.getCellID(i+1,j+1);
				tv = (TextView) findViewById(id);

				tv.setBackgroundColor(00000000);
				tv.setShadowLayer(0.0f, 0.0f, 0.0f, Color.WHITE);

				tv.setText("\u2588");
				tv.setTextColor(00000000);

				addlistener(tv,id,i+1,j+1);


		}

	}



}


	private void addlistener(final TextView textView, final int id, final int row, final int col) {

		textView.setOnClickListener(new OnClickListener() {


			public void onClick(View v) {


				//Log.i("Stif","ROW:"+row);
				//Log.i("Stif","COL:"+col);

				if (secondappearence) {

					secondappearence = false;

					addTarget(row,col);

					//Log.i("Stif","Second ROW:"+Integer.toString(row));

				}

               if (firstappearence) {

				   firstappearence = false;
				   secondappearence = true;

				   addHorse(row,col);

                   // Log.i("Stif","In ROW:"+Integer.toString(row));

                }



			}

		});


	}

	private void FindAllRoutes() {

		Node start = new Node(horseX,horseY);
		Node end = new Node(kingX,kingY);


		ArrayList<ArrayList<Node>> routes = new ChessKnight().getAllRoutes(start, end);


		String res = presentNodes(routes);

		//Log.i("Stif",res);
		result = (TextView) findViewById(R.id.resultTV);
		result.setMovementMethod(new ScrollingMovementMethod());
		result.setTextColor(Color.BLACK);

		if(res.isEmpty()) {
			result.setText("No -3 move route- Found!");
		}else{
			result.setText(res);
		}
	}


	private String presentNodes(ArrayList<ArrayList<Node>> routes) {

		String arrow = "-->";
		String line = "";

		for (ArrayList<Node> route : routes) {

			int i = 0;
			for (Node node : route) {

				i++;

				int x = node.Node_getx();
				int y = node.Node_gety();

				String square = UtilityClass.getColumnID(x-1) + UtilityClass.getCorrect_y(y-1);
                if(i==4) {
                    line = line + square + "";
                }else{
                    line = line + square + arrow;
                }


			}
				  line = line + "\n**************************\n";
		}
		return line;
	}



		}


