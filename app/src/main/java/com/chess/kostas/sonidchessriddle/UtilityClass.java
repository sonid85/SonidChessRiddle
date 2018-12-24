package com.chess.kostas.sonidchessriddle;


/**
 * This class will contain all utility methods
 * @author Sonid
 */
public class UtilityClass {


	public static int getCellID(int row, int col){
		if(col==1){
			if(row==1){
				return R.id.A1;
			}
			else if(row==2){
				return R.id.A2;
			}
			else if(row==3){
				return R.id.A3;		
			}
			else if(row==4){
				return R.id.A4;
			}
			else if(row==5){
				return R.id.A5;
			}
			else if(row==6){
				return R.id.A6;
			}
			else if(row==7){
				return R.id.A7;
			}
			else if(row==8){
				return R.id.A8;
			}
		}
		else if(col==2){
			if(row==1){
				return R.id.B1;
			}
			else if(row==2){
				return R.id.B2;
			}
			else if(row==3){
				return R.id.B3;		
			}
			else if(row==4){
				return R.id.B4;
			}
			else if(row==5){
				return R.id.B5;
			}
			else if(row==6){
				return R.id.B6;
			}
			else if(row==7){
				return R.id.B7;
			}
			else if(row==8){
				return R.id.B8;
			}
		}
		else if(col==3){
			if(row==1){
				return R.id.C1;
			}
			else if(row==2){
				return R.id.C2;
			}
			else if(row==3){
				return R.id.C3;		
			}
			else if(row==4){
				return R.id.C4;
			}
			else if(row==5){
				return R.id.C5;
			}
			else if(row==6){
				return R.id.C6;
			}
			else if(row==7){
				return R.id.C7;
			}
			else if(row==8){
				return R.id.C8;
			}
		}
		else if(col==4){
			if(row==1){
				return R.id.D1;
			}
			else if(row==2){
				return R.id.D2;
			}
			else if(row==3){
				return R.id.D3;		
			}
			else if(row==4){
				return R.id.D4;
			}
			else if(row==5){
				return R.id.D5;
			}
			else if(row==6){
				return R.id.D6;
			}
			else if(row==7){
				return R.id.D7;
			}
			else if(row==8){
				return R.id.D8;
			}
		}
		else if(col==5){
			if(row==1){
				return R.id.E1;
			}
			else if(row==2){
				return R.id.E2;
			}
			else if(row==3){
				return R.id.E3;		
			}
			else if(row==4){
				return R.id.E4;
			}
			else if(row==5){
				return R.id.E5;
			}
			else if(row==6){
				return R.id.E6;
			}
			else if(row==7){
				return R.id.E7;
			}
			else if(row==8){
				return R.id.E8;
			}
		}
		else if(col==6){
			if(row==1){
				return R.id.F1;
			}
			else if(row==2){
				return R.id.F2;
			}
			else if(row==3){
				return R.id.F3;		
			}
			else if(row==4){
				return R.id.F4;
			}
			else if(row==5){
				return R.id.F5;
			}
			else if(row==6){
				return R.id.F6;
			}
			else if(row==7){
				return R.id.F7;
			}
			else if(row==8){
				return R.id.F8;
			}
		}
		else if(col==7){
			if(row==1){
				return R.id.G1;
			}
			else if(row==2){
				return R.id.G2;
			}
			else if(row==3){
				return R.id.G3;		
			}
			else if(row==4){
				return R.id.G4;
			}
			else if(row==5){
				return R.id.G5;
			}
			else if(row==6){
				return R.id.G6;
			}
			else if(row==7){
				return R.id.G7;
			}
			else if(row==8){
				return R.id.G8;
			}
		}
		else if(col==8){
			if(row==1){
				return R.id.H1;
			}
			else if(row==2){
				return R.id.H2;
			}
			else if(row==3){
				return R.id.H3;		
			}
			else if(row==4){
				return R.id.H4;
			}
			else if(row==5){
				return R.id.H5;
			}
			else if(row==6){
				return R.id.H6;
			}
			else if(row==7){
				return R.id.H7;
			}
			else if(row==8){
				return R.id.H8;
			}
		}
		
		return -1;
	}
	
	public static int getPieceUnicodeID(String team, String type){
		
		if(team.equals("w")){
			if(type.equals("p")){ //pawn
				return R.string.whitepawn;
			}
			else if(type.equals("K")){ //King
				return R.string.whiteking;
			}
			else if(type.equals("Q")){ //Queen
				return R.string.whitequeen;
			}
			else if(type.equals("R")){ //Rook
				return R.string.whiterook;
			}
			else if(type.equals("B")){ //Bishop
				return R.string.whitebioshop;
			}
			else if(type.equals("N")){ //Knight
				return R.string.whiteknight;
			}
				
		}
		else{
			if(type.equals("p")){ //pawn
				return R.string.blackpawn;
			}
			else if(type.equals("K")){ //King
				return R.string.blackking;
			}
			else if(type.equals("Q")){ //Queen
				return R.string.blackqueen;
			}
			else if(type.equals("R")){ //Rook
				return R.string.blackrook;
			}
			else if(type.equals("B")){ //Bishop
				return R.string.blackbioshop;
			}
			else if(type.equals("N")){ //Knight
				return R.string.blackknight;
			}
		}
		return 0;		
		
		
	}

	public static int getRowID(String row){

			if(row.equals("1")){
				return R.id.row1;
			}
			else if(row.equals("2")){
				return R.id.row2;
			}
			else if(row.equals("3")){
				return R.id.row3;		
			}
			else if(row.equals("4")){
				return R.id.row4;
			}
			else if(row.equals("5")){
				return R.id.row5;
			}
			else if(row.equals("6")){
				return R.id.row6;
			}
			else if(row.equals("7")){
				return R.id.row7;
			}
			else if(row.equals("8")){
				return R.id.row8;
			}


		return 0;
	}

	public static String getColumnID(int x) {

		switch (x) {

			case 0:
				return "A";
			case 1:
				return "B";
			case 2:
				return "C";
			case 3:
				return "D";
			case 4:
				return "E";
			case 5:
				return "F";
			case 6:
				return "G";
			case 7:
				return "H";
		}
		return "";
	}

    public static String getCorrect_y(int y) {

        return String.valueOf(y+1);

    }

}
