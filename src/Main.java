public class Main {


    public static void main(String[] args){

        Game g=new Game("A","B");

        //g.play();

        /*g.getBoard().helper[0][1] =g.getBoard().helper[7][1];

        g.getBoard().helper[7][1]=new Blank();

        for (int i=0; i<g.getBoard().items[1].getAllMoves().length;i++)
            System.out.print(g.getBoard().items[1].getAllMoves()[i]+",");*/

        /*g.play("a5","b5");
        g.play("h2","h5");

        g.play("c8","j8");
        g.play("j9","j8");

        g.play("a2","c1");
        g.play("h5","d5");
        g.play("a7","c5");*/
        
        //---------------------------------/
        /*g.play("c8","j8");
        g.play("j9","j8");
        g.play("a8","c7");
        g.play("h8","h6");
        g.play("d7","e7");


        g.play("j8","b8");
        g.play("a9","b9");
        g.play("b8","f8");
        g.play("c7","e6");
        g.play("j2","h3");

        g.play("e6","g7");
        g.play("j4","i5");
        g.play("g7","h9");
        g.play("j7","h9");
        g.play("b9","b8");

        g.play("f8","b8");
        g.play("e7","f7");
        g.play("h6","h7");
        g.play("f7","g7");
        g.play("h7","j7");

        g.play("g7","h7");
        g.play("h2","h7");
        g.play("c2","c3");
        g.play("j7","a7");
        g.play("a6","b5");

        g.play("a7","a9");
        g.play("d5","e5");
        g.play("h7","a7");/*

        /********************************************************/


        /*g.play("d9","e9");
        g.play("h2","h5");
        g.play("e9","f9");
        g.play("h5","d5");
        g.play("f9","g9");

        //g.save_text("dosya.txt");

        g.play("j1","i1");
        g.play("g9","h9");
        g.play("j9","h9");
        g.play("a9","h9");
        g.play("j8","h9");

        g.play("a8","c9");
        g.play("h8","f8");
        g.play("c8","d8");
        g.play("f8","f5");*/

        /*********************************************/

        g.getBoard().print();

        g.play("d5","e5");
        g.play("g5","f5");
        g.play("c2","c5");
        g.play("j7","h9");
        g.play("a9","b9");

        //g.load_text("dosya.txt");

        g.play("j4","i5");
        g.play("e5","f5");
        g.play("j9","i9");
        g.play("c8","j8");
        g.play("h9","j7");

        g.play("b9","b6");
        g.play("i9","j9");
        g.play("b6","j6");

        g.getBoard().print();








    }
}
