import java.io.*;
import java.util.Scanner;

public class Game extends AbstractGame implements Serializable{

    int turn=0;
    private Item item;


    public Game(String a,String b) {
        red=new Player();
        red.ad=a;
        black=new Player();
        black.ad=b;

        item=new Item();
        board=item.b;
    }


    @Override
    void play(String from, String to) {

        if(turn==-1){
            System.out.println("hatali hareket");
            return;
        }

        if(turn%2==0) {
            if (item.getByPos(from).color.equals("black")) {
                System.out.println("hatali hareket");
                return;
            }
        }
        else if(item.getByPos(from).color.equals("red")){
            System.out.println("hatali hareket");
            return;
        }

        /*******************/

        if(!item.corner(from,to)) {
            System.out.println("hatali hareket");
            return;
        }

        /*****************/


        if(item.getByPos(from).getClass()==Blank.class) {
            System.out.println("hatali hareket");
            return;
        }

        item.getByPos(from).move(to);

        if(item.getByPos(from).getClass()!=Blank.class)
            System.out.println("hatali hareket");
        else
            turn++;

        String winner="";
        String loser="";

        if(turn%2==1){

            if(board.items[4].isCheck()) {

                if (board.items[4].checkMate()) {
                    winner = red.ad;
                    loser = black.ad;
                    turn=-1;
                }
            }
        }
        else {

            if(board.items[27].isCheck()) {

                if (board.items[27].checkMate()) {
                    winner = black.ad;
                    loser = red.ad;
                    turn=-1;
                }
            }
        }

        if(!winner.equals("")){
            calculatePoints();

            float wP;
            float lP;

            if(winner.equals(red.ad)) {
                wP=red.puan;
                lP=black.puan;

            }else {

                wP=black.puan;
                lP=red.puan;

            }
            System.out.println("ŞAH MAT! KAZANAN "+winner+" oyununu kazandi. "+winner+"'in puanı: "+wP
                                +", "+loser+"'nin puanı: "+lP);
        }

    }

    @Override
    void save_binary(String address) {

        ObjectOutputStream o=null;

        try {
            o=new ObjectOutputStream(new FileOutputStream(address));
            o.writeObject(this);
            o.writeUTF(black.ad);
            o.writeFloat(black.puan);
            o.writeUTF(red.ad);
            o.writeFloat(red.puan);

            for(int i=0; i<32;i++)
                o.writeUTF(board.items[i].getPosition());

            o.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    void save_text(String address) {

        PrintWriter out=null;

        try {
            out=new PrintWriter(address);

            for (int i=0; i<32 ; i++){
                out.print(board.items[i].getPosition()+" ");
            }
            out.print(turn+" ");
            out.print(black.ad+" ");
            out.print(black.puan+" ");
            out.print(red.ad+" ");
            out.print(red.puan+" ");

            out.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    void load_text(String address) {

        Scanner s=null;

        try {
            s=new Scanner(new FileInputStream(address));

            for(int j=0;j<32;j++)
                board.items[j].setPosition(s.next());

            fillAgain();

            turn=Integer.parseInt(s.next());
            black.ad=s.next();
            black.puan= Float.parseFloat(s.next()) ;
            red.ad=s.next();
            red.puan=Float.parseFloat(s.next());


            s.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    void load_binary(String address) {

        ObjectInputStream i=null;

        try {
            i=new ObjectInputStream(new FileInputStream(address));

            Game k=(Game) i.readObject();
            this.turn=k.turn;
            this.item=k.item;

            this.black.ad=i.readUTF();
            this.black.puan=i.readFloat();
            this.red.ad=i.readUTF();
            this.red.puan=i.readFloat();

            for(int j=0;j<32;j++)
                board.items[j].setPosition(i.readUTF());

            fillAgain();

            i.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    void fillAgain(){

        for(int i=0;i<10;i++){

            for(int j=0;j<9;j++) {
                board.helper[i][j]=new Blank();
            }
        }

        for(int j=0; j<32;j++){
            if(!board.items[j].getPosition().equals("xx"))
                setByPos(board.items[j].getPosition(),board.items[j]);
        }

    }

    void setByPos(String position, Item n) {

        int column = Integer.parseInt(position.charAt(1) + "") - 1;
        int row = 9 - (position.charAt(0) - 97);

        board.helper[row][column]=n;
        board.helper[row][column].setPosition(position);

    }

    void calculatePoints() {

        for(int i=0; i<16;i++){

            if(board.items[i].getPosition().equals("xx")) {
                //System.out.println(i+","+board.items[i].points);
                red.puan += pieceP(i);
            }

        }
        for(int i=16; i<32;i++){

            if(board.items[i].getPosition().equals("xx")){
                black.puan+=pieceP(i);
            }

        }

    }

    float pieceP(int i){

        if(i==0 || i==8 || i==31 || i==23)
            return 9;
        if(i==1 || i==7 || i==30 || i==24)
            return 4.5f;
        if(i==2 || i==6 || i==29 || i==25)
            return 2;
        if(i==3 || i==5 || i==28 || i==26)
            return 2;
        if(i==4 || i==27 )
            return 0;
        if(i==9 || i==10 || i==22 || i==21)
            return 4;


        return 1;
    }

}
