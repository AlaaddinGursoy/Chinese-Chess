public class Vezir extends Item{

    @Override
    public String toString() {
        if(color.equals("black"))
            return "V";
        return "v";
    }

    @Override
    public String[] getAllMoves() {

        int row=0;
        int column=0;
        int pointer=9;

        String[] ans;
        if(color.equals("black"))
            ans = new String[]{"j4","j5","j6","i4","i5","i6","h4","h5","h6"};
        else
            ans = new String[]{"a4","a5","a6","b4","b5","b6","c4","c5","c6"};

        for (int i=0; i<9;i++) {
            row=convertToIndex(ans[i])/10;
            column=convertToIndex(ans[i])%10;

            if(b.helper[row][column].color.equals(color)) {
                ans[i] = null;
                pointer--;
                continue;
            }

            if(!isNextTo(getPosition(),ans[i])) {
                ans[i] = null;
                pointer--;
            }
        }

        String[] last = new String[pointer];

        int key=0;
        for(int i=0;key<pointer ;i++){
            if(ans[i]==null)
                continue;
            last[key]=ans[i];
            key++;
        }


        return last;

    }

    boolean isNextTo(String now,String next){

        if(now.equals("i5") || now.equals("b5"))
            return true;

        if(next.equals("i5") || next.equals("b5"))
            return true;

        if(now.equals(next))
            return false;

        if(next==null)
            return false;

        int row1=convertToIndex(now)/10;
        int column1=convertToIndex(now)%10;

        int row2=convertToIndex(next)/10;
        int column2=convertToIndex(next)%10;

        int differ=Math.abs(row1-row2)+Math.abs(column1-column2);

        if(differ==1)
            return true;
        return false;
    }
}
