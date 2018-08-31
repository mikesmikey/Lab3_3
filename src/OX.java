public class OX {
    private String[][] arr = {
            { "", "0", "1", "2"},
            { "0", "-", "-", "-"},
            { "1", "-", "-", "-"},
            { "2", "-", "-", "-"}
    };
    String player = "X";
    private int countX = 0, countO = 0, countDraw = 0;

    public OX() {

    }

    public String getTableString() {
        String result = " ";
        for (int i=0; i< arr.length; i++) {
            for (int j=0; j< arr[0].length; j++) {
                result = result+arr[i][j]+" ";
            }
            result = result+"\n";
        }
        return result;
    }

    public String getCurrentPlayer() {
        return player;
    }

    public int getCountO() {
        return countO;
    }

    public int getCountX() {
        return countX;
    }

    public int getCountDraw() {
        return countDraw;
    }

    public boolean put( int col, int row) {
        if (col < arr[0].length-1
                && row < arr.length-1
                && arr[row+1][col+1] == "-")
        {
            arr[row+1][col+1] = player;
            return true;
        }
        else
        {
            return false;
        }
    }

    public void switchPlayer() {
        if (player == "X") { player = "O"; } else { player = "X"; };
    }

    public boolean checkWin() {
        int colwincount=0, rowwincount=0;
        for (int i = 1;i< arr.length;i++) {
            colwincount=0;
            rowwincount=0;

            for (int j = 1;j< arr[0].length;j++) {
                if (arr[i][j] == player)
                {
                    colwincount++;
                }
                if (arr[j][i] == player)
                {
                    rowwincount++;
                }
            }

            if (colwincount >= 3 || rowwincount >= 3) {
                if (getCurrentPlayer() == "X") {
                    countX++;
                }
                else if (getCurrentPlayer() == "O") {
                    countO++;
                }
                return true;
            }
        }

        //cross win
        if (arr[1][1] == player
                && arr[2][2] == player
                && arr[3][3] == player) {
            if (getCurrentPlayer() == "X") {
                countX++;
            }
            else if (getCurrentPlayer() == "O") {
                countO++;
            }
            return true;
        }
        else if (arr[1][3] == player
                && arr[2][2] == player
                && arr[3][1] == player) {
            if (getCurrentPlayer() == "X") {
                countX++;
            }
            else if (getCurrentPlayer() == "O") {
                countO++;
            }
            return true;
        }
        return false;
    }

    public String get(int col, int row) {
        return arr[row+1][col+1];
    }

    public void setCountDraw(int n) {
        countDraw = countDraw + n;
    }

    public void Reset() {
        arr = new String[][]{
                {"", "0", "1", "2"},
                {"0", "-", "-", "-"},
                {"1", "-", "-", "-"},
                {"2", "-", "-", "-"}
        };
    }
}
