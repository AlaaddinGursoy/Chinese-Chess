public class Kale extends Item{

    @Override
    public String toString() {
        if(color.equals("black"))
            return "K";
        return "k";
    }

    @Override
    public String[] getAllMoves() {

        String[] ans = new String[18];

        int column = Integer.parseInt(getPosition().charAt(1)+"")-1;
        int row = 9-(getPosition().charAt(0)-97);



        int pointer = 0;


        int tmpR=row;
        int tmpC=column+1;
        int flag=0;

        while(tmpC<9 && flag!=1){
            if(b.helper[row][tmpC].getClass()!=Blank.class)
                flag++;
            if(flag==1 && b.helper[row][tmpC].color.equals(color))
                break;

            ans[pointer]=((char)(106-row)+""+(1+tmpC++));
            pointer++;
        }
        tmpR=row;
        tmpC=column-1;
        flag=0;

        while(tmpC>=0 && tmpC<9 && flag!=1){
            if(b.helper[row][tmpC].getClass()!=Blank.class)
                flag++;
            if(flag==1 && b.helper[row][tmpC].color.equals(color))
                break;

            ans[pointer]=((char)(106-row)+""+(1+tmpC--));
            pointer++;
        }
        tmpR=row+1;//7
        tmpC=column;//2
        flag=0;

        while(tmpR<9 && tmpR>=0 && flag!=1){
            if(b.helper[tmpR][column].getClass()!=Blank.class)
                flag++;
            if(flag==1 && b.helper[tmpR][column].color.equals(color))
                break;

            ans[pointer]=((char)(106-tmpR++)+""+(1+column));
            pointer++;
        }
        tmpR=row-1;//5
        tmpC=column;//2
        flag=0;

        while(tmpR>=0 && tmpR<=9 && flag!=1){
            if(b.helper[tmpR][column].getClass()!=Blank.class)
                flag++;
            if(flag==1 && b.helper[tmpR][column].color.equals(color))
                break;

            ans[pointer]=((char)(106-tmpR--)+""+(1+column));
            pointer++;
        }

        String[] last = new String[pointer];
        for(int i=0;i<pointer;i++)
            last[i]=ans[i];


        return last;

    }


}
