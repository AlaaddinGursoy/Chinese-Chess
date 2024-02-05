public class Piyon extends Item{

    @Override
    public String toString() {
        if(color.equals("black"))
            return "P";
        return "p";
    }

    @Override
    public String[] getAllMoves() {
        String[] ans = new String[3];
        int pointer = 0;

        int column = Integer.parseInt(getPosition().charAt(1) + "") - 1;
        int row = 9 - (getPosition().charAt(0) - 97);

        String temp = "";

        if (color.equals("black") && row+1<=9 && !b.helper[row + 1][column].color.equals("black")) {
            temp = ((char) (105 - row) + "" + (column + 1));
            ans[pointer++] = temp;
        }
        if (color.equals("red") && row-1>=0 && !b.helper[row - 1][column].color.equals("red")) {
            temp = ((char) (107 - row) + "" + (column + 1));
            ans[pointer++] = temp;
        }

        /****************************************************/
        if (color.equals("black") && row>=5 && column-1>=0 && !b.helper[row][column-1].color.equals("black")) {
            temp = ((char) (106 - row) + "" + (column));
            ans[pointer++] = temp;

        }
        if (color.equals("red") && row<5 && column-1>=0 && !b.helper[row][column-1].color.equals("red")) {
            temp = ((char) (106 - row) + "" + (column));
            ans[pointer++] = temp;
        }

        /****************************************************/
        if (color.equals("black") && row>=5 && column+1<9 && !b.helper[row][column+1].color.equals("black")) {
            temp = ((char) (106 - row) + "" + (column+2));
            ans[pointer++] = temp;
        }
        if (color.equals("red") && row<5 && column+1<9 && !b.helper[row][column+1].color.equals("red")) {
            temp = ((char) (106 - row) + "" + (column+2));
            ans[pointer++] = temp;
        }


        String[] last = new String[pointer];
        for(int i=0;i<pointer;i++)
            last[i]=ans[i];


        return last;

    }
}
