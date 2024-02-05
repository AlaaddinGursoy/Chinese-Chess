import java.io.Serializable;

public class Item extends AbstractItem implements Serializable {

	String color;//red or black * by me
	static Board b;

	public static Board getB() {
		return b;
	}

	static {
		b=new Board();
	}

	@Override
	public void move(String destination) {

		if(!moveBorders(destination)) {
			//System.out.println("hatali hareket");
			return;
		}
		if(!this.canMove(destination)) {
			//System.out.println("hatali hareket");
			return;
		}

		int column=Integer.parseInt(destination.charAt(1)+"")-1;//gideceği kolon
		int row= 9-(destination.charAt(0)-97);//sutun

		int i=0;

		if(color.equals("red") && !getByPos(destination).color.equals(color)) {
			while (i < 16) {

				if (getByPos(destination).equals(b.items[i])) {
					b.items[i] = new Blank();
					b.items[i].setPosition("xx");
				}
				i++;
			}
		}
		i=16;
		if(color.equals("black") && !getByPos(destination).color.equals(color)){
			while (i < 32) {

				if (getByPos(destination).equals(b.items[i])) {
					b.items[i] = new Blank();
					b.items[i].setPosition("xx");
				}

				i++;
			}
		}

		String tmp= this.getPosition();

		if(getByPos(destination).getClass()!=Blank.class) {
			b.helper[row][column]=new Blank();
		}

		this.setPosition(destination);

		b.helper[row][column]=this;

		column=Integer.parseInt(tmp.charAt(1)+"")-1;
		row= 9-(tmp.charAt(0)-97);

		b.helper[row][column]=new Blank();


	}

	public boolean moveBorders(String newPosition){           //-----------------------------by me

		if(newPosition.length()!=2)
			return false;

		int column=Integer.parseInt(newPosition.charAt(1)+"")-1;
		int row= 9-(newPosition.charAt(0)-97);

		if(row>=0 && row<=9 && column>=0 && column<9) {
			return true;
		}
		return false;
	}

	public boolean canMove(String newPos){           //-----------------------------by me

		if(getPosition().equals("xx"))
			return false;

		if(getAllMoves()==null)
			return false;

		if(!moveBorders(newPos))
			return false;

		for(int i=0; i<getAllMoves().length;i++){
			if(newPos.equals(getAllMoves()[i]))
				return true;
		}
		return false;
	}

	public int convertToIndex(String newPos){

		try {
			int column=Integer.parseInt(newPos.charAt(1)+"")-1;
			int row= 9-(newPos.charAt(0)-97);

			return row*10+column;
		}catch (Exception e){
			return -1;
		}



	}

	public Item getByPos (String pos){

		if(!moveBorders(pos))
			return new Blank();

		int row=convertToIndex(pos)/10;
		int column= convertToIndex(pos)%10;


		return b.helper[row][column];
	}

	public boolean isCheck(){

		if(color.equals("red"))
		{
			for (int i=0;i<16;i++) {
				if(b.items[i].canMove(b.items[27].getPosition())){
					return true;
				}

			}

		}
		else {
			for (int i=16;i<32;i++) {
				if(b.items[i].canMove(b.items[4].getPosition())){
					return true;
				}

			}


		}

		return false;
	}

	public boolean checkMate(){

		String temp;
		String old;

		if(color.equals("red"))
		{


			for(int i=0;i<=9;i++){
				for (int j=0;j<9;j++){

					for (int k=16; k<32;k++){

						old=b.items[k].getPosition();

						temp = ((char) (106 - i) + "" + (j+1));

						if(b.items[k].canMove(temp) && safeMove(old,temp))
							return false;

					}
				}
			}
			return true;

		} else {


			for(int i=0;i<=9;i++){
				for (int j=0;j<9;j++){

					for (int k=0; k<16;k++){

						old=b.items[k].getPosition();
						temp = ((char) (106 - i) + "" + (j+1));

						if(b.items[k].canMove(temp) && safeMove(old,temp))
							return false;


					}
				}
			}
			return true;
		}
	}

	boolean safeMove(String from, String to){

		int fRow=convertToIndex(from)/10;
		int fCol=convertToIndex(from)%10;

		int tRow=convertToIndex(to)/10;
		int tCol=convertToIndex(to)%10;

		Item fI=getByPos(from);
		Item tI=getByPos(to);

		b.helper[tRow][tCol]=fI;
		b.helper[tRow][tCol].setPosition(to);
		b.helper[fRow][fCol]=new Blank();

		if(!fI.isCheck()){

			b.helper[tRow][tCol]=tI;
			b.helper[tRow][tCol].setPosition(to);
			b.helper[fRow][fCol]=fI;
			b.helper[fRow][fCol].setPosition(from);

			return true;
		}

		b.helper[tRow][tCol]=tI;
		b.helper[tRow][tCol].setPosition(to);
		b.helper[fRow][fCol]=fI;
		b.helper[fRow][fCol].setPosition(from);

		return false;

	}

	boolean corner(String from, String to) {

		int fRow=convertToIndex(from)/10;
		int fCol=convertToIndex(from)%10;

		int tRow=convertToIndex(to)/10;
		int tCol=convertToIndex(to)%10;

		String c=getByPos(from).color;

		Item fI=getByPos(from);
		Item tI=getByPos(to);

		b.helper[tRow][tCol]=fI;
		b.helper[tRow][tCol].setPosition(to);
		b.helper[fRow][fCol]=new Blank();


		if(c.equals("red")){
			if(b.items[27].isCheck()){
				b.helper[tRow][tCol]=tI;
				b.helper[tRow][tCol].setPosition(to);
				b.helper[fRow][fCol]=fI;
				b.helper[fRow][fCol].setPosition(from);

				return false;
			}
		} else {
			if(b.items[4].isCheck()){
				b.helper[tRow][tCol]=tI;
				b.helper[tRow][tCol].setPosition(to);
				b.helper[fRow][fCol]=fI;
				b.helper[fRow][fCol].setPosition(from);

				return false;
			}

		}


		b.helper[tRow][tCol]=tI;
		b.helper[tRow][tCol].setPosition(to);
		b.helper[fRow][fCol]=fI;
		b.helper[fRow][fCol].setPosition(from);

		return true;

	}

	public String[] getAllMoves() {return null;} //-----------------------------by me

}
