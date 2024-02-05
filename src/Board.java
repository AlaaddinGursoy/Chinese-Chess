
public class Board extends AbstractBoard{

	Item[][] helper = new Item[10][9]; //-----------------------------by me

	{
		items=new Item[32];

		items[0]=new Kale();
		items[8]=new Kale();
		items[1]=new At();
		items[7]=new At();
		items[2]=new Fil();
		items[6]=new Fil();
		items[3]=new Vezir();
		items[5]=new Vezir();
		items[4]=new King();

		items[9]=new Top();
		items[10]=new Top();

		for(int i=11; i<21; i++)
			items[i]=new Piyon();

		items[21]=new Top();
		items[22]=new Top();

		items[23]=new Kale();
		items[31]=new Kale();
		items[24]=new At();
		items[30]=new At();
		items[25]=new Fil();
		items[29]=new Fil();
		items[26]=new Vezir();
		items[28]=new Vezir();
		items[27]=new King();

		for (int i=0;i<16;i++)
			items[i].color="black";
		for (int i=16;i<32;i++)
			items[i].color="red";

	}

	Board () {

		for(int i=0;i<9;i++)
			for (int j=0; j<9;j++)
				helper[i][j]=new Blank();


		for(int i=0; i<9; i++)
			helper[0][i]=items[i];
		for(int i=23; i<32; i++)
			helper[9][i-23]=items[i];

		for(int i=11; i<16; i++)
			helper[3][2*(i-11)]=items[i];
		for(int i=16; i<21; i++)
			helper[6][2*(i-16)]=items[i];

		helper[2][1]=items[9];
		helper[2][7]=items[10];
		helper[7][1]=items[21];
		helper[7][7]=items[22];

		for(int i=0;i<10;i++){
			for(int j=0; j<9;j++) {
				helper[i][j].setPosition((char)(106-i)+""+(j+1));
			}
		}
	}

	@Override
	public void print() {

		System.out.print("j\t"+helper[0][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+helper[0][i]);
		System.out.println();

		System.out.println(" \t|  |  |  |\\ | /|  |  |  |");

		System.out.print("i\t"+helper[1][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+helper[1][i]);
		System.out.println();

		System.out.println(" \t|  |  |  |/ | \\|  |  |  |");


		System.out.print("h\t"+helper[2][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+helper[2][i]);
		System.out.println();

		System.out.println(" \t|  |  |  |  |  |  |  |  |");

		System.out.print("g\t"+helper[3][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+helper[3][i]);
		System.out.println();

		System.out.println(" \t|  |  |  |  |  |  |  |  |");

		System.out.print("f\t"+helper[4][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+helper[4][i]);
		System.out.println();

		System.out.println(" \t|                       |");

		System.out.print("e\t"+helper[5][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+helper[5][i]);
		System.out.println();

		System.out.println(" \t|  |  |  |  |  |  |  |  |");

		System.out.print("d\t"+helper[6][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+helper[6][i]);
		System.out.println();

		System.out.println(" \t|  |  |  |  |  |  |  |  |");

		System.out.print("c\t"+helper[7][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+helper[7][i]);
		System.out.println();

		System.out.println(" \t|  |  |  |\\ | /|  |  |  |");

		System.out.print("b\t"+helper[8][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+helper[8][i]);
		System.out.println();

		System.out.println(" \t|  |  |  |/ | \\|  |  |  |");

		System.out.print("a\t"+helper[9][0]);
		for(int i=1;i<9;i++)
			System.out.print("--"+helper[9][i]);
		System.out.println();

		System.out.println();
		System.out.println(" \t1--2--3--4--5--6--7--8--9");


	}

}
