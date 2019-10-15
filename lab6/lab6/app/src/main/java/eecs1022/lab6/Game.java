package eecs1022.lab6;

/**
 * Created by user on 3/23/18.
 */
public class Game
{
    private char[][] board;
    private String PlayerX;
    private String PlayerO;
    private int turn;
    private String result;
    private boolean start;
    private String winner;
    private boolean win;

    public Game()
    {
        this.start = false;
        this.board = new char[3][3];
        this.turn = 0;
        this.result = " ";
        this.PlayerX = null;
        this.PlayerO = null;
        this.winner = null;
        this.win = false;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                this.board[i][j] = '-';
            }
        }
    }

    public String getResult()
    {
        return this.result;
    }

    public String printResult()
    {
        String s = "Current game status:\n\n";
        String player = null;
        for (int i = 0; i < 3; i++)
        {
            s += String.format("%c  %c  %c\n", this.board[i][0], this.board[i][1], this.board[i][2]);
        }
        if (this.turn == 0)
        {
            player = this.PlayerX;
        } else if (this.turn == 1)
        {
            player = this.PlayerO;
        }
        if (this.win)
        {
            if (this.winner.equals("Tie"))
                s += String.format("Game is over with Tie between %s and %s", this.PlayerX, this.PlayerO);
            else
            {
                s += String.format("Game is over with %s being the winner", this.winner);
            }
        } else
            s += String.format("\nNeed Player to play: %s", player);
        return s;
    }

    public void setPlayerName(String name, int id)
    {
        if (id == 1)
        {
            this.PlayerX = name;
        } else if (id == 2)
        {
            this.PlayerO = name;
        }
    }

    public void setEntry(int r, int c)
    {
        char en = '-';
        r -= 1;
        c -= 1;
        if (this.turn == 0)
        {
            en = 'X';
            this.turn = 1;
        } else if (this.turn == 1)
        {
            en = 'O';
            this.turn = 0;
        }
        if (this.board[r][c] == '-')
        {
            this.board[r][c] = en;
            this.result = this.printResult();
        } else
        {
            r += 1;
            c += 1;
            if (this.turn == 0)
            {
                this.turn = 1;
            } else if (this.turn == 1)
            {
                this.turn = 0;
            }
            this.result = String.format("Error: slot @ (%d , %d) already occupied\n\n%s", r, c, this.printResult());
        }
    }

    public void computeWin()
    {

        boolean bool = false;
        char winner = '-';
        for (int i = 0; i < 3; i++)  // For Row Check
        {
            if (this.board[i][0] != '-' && this.board[i][1] != '-'&&this.board[i][2]!='-')
            {
                if (this.board[i][0] == this.board[i][1] && this.board[i][1] == this.board[i][2])
                {
                    bool = true;
                    winner = this.board[i][0];
                    break;
                }
            }
        }
        if (!bool)
        {
            for (int j = 0; j < 3; j++) // For Column Check
            {
                    if (this.board[0][j] != '-' && this.board[1][j] != '-' && this.board[2][j]!='-')
                    {
                        if(this.board[0][j]==this.board[1][j]&&this.board[1][j]==this.board[2][j])
                        {
                            bool = true;
                            winner = this.board[0][j];
                            break;
                        }
                    }
            }
        }
        if (!bool)
        {
            if(this.board[0][0]!='-'&&this.board[1][1]!='-'&&this.board[2][2]!='-'){
                if(this.board[0][0]==this.board[1][1]&&this.board[1][1]==this.board[2][2]){
                    bool=true;
                    winner = this.board[0][0];
                }
            }
        }
        if (!bool) // Digonal Two
        {
            if(this.board[0][2]!='-'&&this.board[1][1]!='-'&&this.board[2][0]!='-'){
                if(this.board[0][2]==this.board[1][1]&&this.board[1][1]==this.board[2][0]){
                    bool=true;
                    winner = this.board[2][0];
                }
            }
        }

    if(!bool)
    {
        if (full())
        {
            this.winner = "Tie";
            this.win = true;
        }
    }
        if(winner=='X')

        {
            this.winner = this.PlayerX;
            this.win=true;
        }

        else if(winner=='O')

        {
            this.winner = this.PlayerO;
            this.win=true;
        }

}


    public boolean full(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(this.board[i][j]=='-'){
                    return false;
                }
            }
        }
        return true;
    }

    public void gamestart(String p1, String p2,String pfirst)
    {
        if (!this.start)
        {
            if (!p1.isEmpty() && !p2.isEmpty())
            {
                this.PlayerX = p1;
                this.PlayerO = p2;
                if(pfirst.equals("Player X")){
                    this.turn=0;
                }
                else if(pfirst.equals("Player O")){
                    this.turn=1;
                }
                this.start = true;
            }
        }
        this.result=this.printResult();

    }
    public void play(int r,int c){
        if(this.win){
            this.result=String.format("Error: game is already over.\n\n%s",this.printResult());
        }
        else if(this.start)
        {
            if(!this.full())
            {
                this.setEntry(r, c);
                this.computeWin();
                if (this.win)
                {
                    this.result = this.printResult();
                }
            }
        }
    }
}
