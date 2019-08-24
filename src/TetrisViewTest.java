// code copied from Simon Lucas
// code copied by Udo Kruschwitz
// code provided by Professor Ian Daly

class TetrisViewTest
{
    public static void main(String[] args)
    {
        // test the view component
        int w = 10; //width of grid
        int h = 20; //height
        int[][] a = new int[w][h];
        TetrisView tv = new TetrisView(a); //initialise grid
        new JEasyFrame(tv, "Jonis Abdulkarim 1404626");
        tv.startTimer(); //start timer, allowing blocks to be moved
    }

}
