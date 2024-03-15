import java.lang.IllegalArgumentException;

public class Gamestate {
    private Player[][] gamestate;

    Gamestate() {
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            this.gamestate[i][j] = null;
          }
        }
    }
        
    /*
     * Fill the square for the specified player.
     * @throws when square at specified coordinates is already filled
     */
    public void put(int x, int y, Player player) throws IllegalArgumentException {
        if (this.gamestate[x][y] != null) {
          throw new IllegalArgumentException("Square is alredy taken");
        }
        this.gamestate[x][y] = player;
    }
    /*
     * Checks wether anyone has won
     * @return the player who won or null if nobody won yet
     */
    public Player hasWon() {
        // check collumns
        for (int x = 0; x < 3; x++) {
            Player checkingFor = null;
            for (int y = 0; y < 3; y++) {
                if (checkingFor != this.gamestate[x][y] && this.gamestate[x][y] != null) {
                    checkingFor = null;
                } else if (checkingFor == null) {
                    checkingFor = this.gamestate[x][y];
                }
            }
            if (checkingFor != null) {
                return checkingFor;
            } 
        }
        // check rows
        for (int y = 0; y < 3; y++) {
            Player checkingFor = null;
            for (int x = 0; x < 3; x++) {
                if (checkingFor != this.gamestate[x][y] && this.gamestate[x][y] != null) {
                    checkingFor = null;
                } else if (checkingFor == null) {
                    checkingFor = this.gamestate[x][y];
                }
            }
            if (checkingFor != null) {
                return checkingFor;
            } 
        }
        // check diagonals
        if ((this.gamestate[0][0] == this.gamestate[1][1] 
                && this.gamestate[1][1] == this.gamestate[2][2]
                && this.gamestate[0][0] != null)
            || (this.gamestate[0][2] == this.gamestate[1][1] 
                && this.gamestate[1][1] == this.gamestate[2][0]
                && this.gamestate[0][2] != null))
        {
            return this.gamestate[1][1];
        }
        return null;
    }
}
