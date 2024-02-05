public class At extends Item{

    @Override
    public String toString() {
        if(color.equals("black"))
            return "A";
        return "a";
    }

    @Override
    public String[] getAllMoves() {

        String[] ans = new String[8];



        int row=convertToIndex(getPosition())/10;
        int column= convertToIndex(getPosition())%10;



        int pointer = 0;

        int tmpR=row;
        int tmpC=column;

        String temp=((char)(107-row)+""+(3+column));// sağ(2) 1 yukarı


        if(moveBorders(temp) && b.helper[tmpR][++tmpC].getClass()==Blank.class && !b.helper[--tmpR][++tmpC].color.equals(color))
            ans[pointer++]=temp;

        tmpR=row;
        tmpC=column;
        temp=((char)(105-row)+""+(3+column));//sağ(2) asagi


        if(moveBorders(temp) && b.helper[tmpR][++tmpC].getClass()==Blank.class && !b.helper[++tmpR][++tmpC].color.equals(color))
            ans[pointer++]=temp;

        /******************************************************/
        tmpR=row;
        tmpC=column;
        temp=((char)(107-row)+""+(column-1));//sol(2) yukarı

        if(moveBorders(temp) && b.helper[tmpR][--tmpC].getClass()==Blank.class && !b.helper[--tmpR][--tmpC].color.equals(color))
            ans[pointer++]=temp;

        tmpR=row;
        tmpC=column;
        temp=((char)(105-row)+""+(column-1));//sol(2) asagi

        if(moveBorders(temp) && b.helper[tmpR][--tmpC].getClass()==Blank.class && !b.helper[++tmpR][--tmpC].color.equals(color))
            ans[pointer++]=temp;

        /******************************************************/
        tmpR=row;
        tmpC=column;
        temp=((char)(108-row)+""+(2+column));//yukarı (2) , sağ

        if(moveBorders(temp) && b.helper[--tmpR][tmpC].getClass()==Blank.class && !b.helper[--tmpR][++tmpC].color.equals(color))
            ans[pointer++]=temp;

        tmpR=row;
        tmpC=column;
        temp=((char)(108-row)+""+(column));//yukarı (2) , sol

        if(moveBorders(temp) && b.helper[--tmpR][tmpC].getClass()==Blank.class && !b.helper[--tmpR][--tmpC].color.equals(color))
            ans[pointer++]=temp;

        /******************************************************/
        tmpR=row;
        tmpC=column;
        temp=((char)(104-row)+""+(2+column));//asagi (2) , sağ

        if(moveBorders(temp) && b.helper[++tmpR][tmpC].getClass()==Blank.class && !b.helper[++tmpR][++tmpC].color.equals(color))
            ans[pointer++]=temp;

        tmpR=row;
        tmpC=column;
        temp=((char)(104-row)+""+(column));//asagi (2) , sol

        if(moveBorders(temp) && b.helper[++tmpR][tmpC].getClass()==Blank.class && !b.helper[++tmpR][--tmpC].color.equals(color))
            ans[pointer++]=temp;


        String[] last = new String[pointer];
        for(int i=0;i<pointer;i++)
            last[i]=ans[i];


        return last;

    }
}
