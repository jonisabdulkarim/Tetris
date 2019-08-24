class Square {
    //initialise key field variables
    private int x;
    private int y;
    private char c;

    Square(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    private int getX() {
        return x;
    }

    private void setX(int x1){ x = x + x1; }

    private int getY() {
        return y;
    }

    private void setY(int y1){ y = y + y1; }

    private int getC() { return c; }

    // allows shape to be moved down in regular intervals
    // returns false when it collides, else true
    boolean getDown(Square sq[], int[][] tv, int color, TetrisView tetrisView) {
        boolean check = true;
        for(int i = 0; i < 4; i++) {
            if (sq[i].getC() == 'O' || sq[i].getC() == 'A' || sq[i].getC() == 'X' || sq[i].getC() == 'D') {
                if (!collideDown(tv, sq[i].getX(), sq[i].getY())) {
                    check = false;
                }
            }
        }
        if (check) {
            for (int i = 0; i < 4; i++) {
                tv[sq[i].getX()][sq[i].getY()] = 0;
                sq[i].setY(1);
                tv[sq[i].getX()][sq[i].getY()] = color;
            }
        }
        else{
            checkLine(tv, tetrisView);
            return true;
        }
        return false;
    }

    // allows shape to be moved right when clicking RMB
    // checks collision before movement.
    void getRight(Square sq[], int[][] tv, int color) {
        boolean check = true;
        for(int i = 0; i < 4; i++) {
            if (sq[i].getC() == 'X' || sq[i].getC() == 'A' || sq[i].getC() == 'B' || sq[i].getC() == 'R') {
                if (!collideRight(tv, sq[i].getX(), sq[i].getY())) {
                    check = false;
                }
            }
        }
        if (check) {
            for (int i = 0; i < 4; i++) {
                tv[sq[i].getX()][sq[i].getY()] = 0;
                sq[i].setX(1);
                tv[sq[i].getX()][sq[i].getY()] = color;
            }
        }
    }

    // allows shape to be moved right when clicking LMB
    // checks collision before movement.
    void getLeft(Square sq[], int[][] tv, int color) {
        boolean check = true;
        for(int i = 0; i < 4; i++) {
            if (sq[i].getC() == 'O' || sq[i].getC() == 'L' || sq[i].getC() == 'B' || sq[i].getC() == 'A') {
                if (!collideLeft(tv, sq[i].getX(), sq[i].getY())) {
                    check = false;
                }
            }
        }
        if (check) {
            for (int i = 0; i < 4; i++) {
                tv[sq[i].getX()][sq[i].getY()] = 0;
                sq[i].setX(-1);
                tv[sq[i].getX()][sq[i].getY()] = color;
            }
        }
    }

    // checks each line in the grid to see if filled up
    // if true, call clearLine() method.
    private void checkLine(int[][] tv, TetrisView tetrisView){
        int repeat = 10;
        while(repeat != 0) {
            for (int y = 19; y > 0; y--) {
                boolean full = true;
                for (int x = 0; x < 10; x++) {
                    if (tv[x][y] == 0) {
                        full = false;
                    }
                }
                if (full) {
                    clearLine(y, tv);
                    tetrisView.setScore(10);
                }
            }
            repeat--;
        }
    }

    // clears the line and shifts grid down from top
    private void clearLine(int y, int[][] tv){
        y--;
        for(; y > 0; y--){
            for(int x = 0; x < 10; x++){
                tv[x][y+1] = tv[x][y];
            }
        }
    }

    // checks for downward collision
    private boolean collideDown(int[][] tv, int x, int y) {
        try{
            return tv[x][y+1] == 0;
        }
        catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    // checks for rightward collision
    private boolean collideRight(int[][] tv, int x, int y) {
        try{
            return tv[x+1][y] == 0;
        }
        catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    // checks for leftward collision
    private boolean collideLeft(int[][] tv, int x, int y) {
        try{
            return tv[x-1][y] == 0;
        }
        catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    // checks if shape is at top of grid
    // ends game if true
    boolean gameOver(int[][] tv){
        for(int x = 0; x < 10; x++){
            if(tv[x][3] != 0){
                return true;
            }
        }
        return false;
    }
}
