class SBlock {
    private final static int[][] rota = {{0, 2}, {0, 1}, {1, 1}, {1, 0}};

    static void createBlock(Square[] sq){
        sq[0] = new Square(rota[0][0] + 4, rota[0][1] + 1, 'A');
        sq[1] = new Square(rota[1][0] + 4, rota[1][1] + 1, 'L');
        sq[2] = new Square(rota[2][0] + 4, rota[2][1] + 1, 'X');
        sq[3] = new Square(rota[3][0] + 4, rota[3][1] + 1, 'B');
    }
}

/*

All shapes take the following information:

x - coordinate: horizontal position in grid
y - coordinate: vertical position in grid
collision char: each square checks for collision in the following ways:

    A - All sides (left, right, down)
    R - Right only
    L - Left only
    B - Left and right
    O - Left and down
    X - Right and down
    D - Down only

 */