public class Fil extends Item{


    @Override
    public String toString() {
        if(color.equals("black"))
            return "F";
        return "f";
    }

    @Override
    public String[] getAllMoves() {

        String[] ans = new String[4];

        int row=convertToIndex(getPosition())/10;
        int column= convertToIndex(getPosition())%10;

        int pointer = 0;

        int tmpR=row;
        int tmpC=column;
        String temp=((char)(104-row)+""+(3+column));


        if(row+2<=9 && column+2<9 && b.helper[++tmpR][++tmpC].getClass()==Blank.class && !b.helper[++tmpR][++tmpC].color.equals(color)) {
            if (color.equals("red") && tmpR >= 5)
                ans[pointer++] = temp;
            if (color.equals("black") && tmpR < 5)
                ans[pointer++] = temp;
        }

        tmpR=row;
        tmpC=column;
        temp=((char)(104-row)+""+(column-1));


        if(row+2<=9 && column-2>=0 && b.helper[++tmpR][--tmpC].getClass()==Blank.class && !b.helper[++tmpR][--tmpC].color.equals(color)){
            if (color.equals("red") && tmpR >= 5)
                ans[pointer++] = temp;
            if (color.equals("black") && tmpR < 5)
                ans[pointer++] = temp;
        }

        tmpR=row;
        tmpC=column;
        temp=((char)(108-row)+""+(3+column));


        if(row-2>=0 && column+2<9 && b.helper[--tmpR][++tmpC].getClass()==Blank.class && !b.helper[--tmpR][++tmpC].color.equals(color)){
            if (color.equals("red") && tmpR >= 5)
                ans[pointer++] = temp;
            if (color.equals("black") && tmpR < 5)
                ans[pointer++] = temp;
        }

        tmpR=row;
        tmpC=column;
        temp=((char)(108-row)+""+(column-1));


        if(row-2>=0 && column-2>=0 && b.helper[--tmpR][--tmpC].getClass()==Blank.class && !b.helper[--tmpR][--tmpC].color.equals(color)){
            if (color.equals("red") && tmpR >= 5)
                ans[pointer++] = temp;
            if (color.equals("black") && tmpR < 5)
                ans[pointer++] = temp;
        }



        String[] last = new String[pointer];
        for(int i=0;i<pointer;i++)
            last[i]=ans[i];

        return last;

    }
}
