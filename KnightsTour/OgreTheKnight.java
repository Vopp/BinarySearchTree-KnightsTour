package uppg4_Backtracking;

import java.util.ArrayList;

/**
 * A implementation of a Knights Tour solution where a knight visits each tile
 * on the board, but only once and in a brutal way.
 *
 * @author Henrik Eliasson
 */
public final class OgreTheKnight {

        private final int[][] MOVES = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2},
        {-2, 1}, {-2, -1}, {-1, -2}};
        private ArrayList<String> _Visited = new ArrayList<>();
        private String[][] _Board;
        private int AN;
        /**
         * Constr
         *
         * @param x The tile-length of the board, up to a maximum of 25.
         * @param y The tile-width of the board.
         * @param start The tile where to have the knight start from.
         */
        public OgreTheKnight(int x, int y, String start) throws IndexOutOfBoundsException {
                newBoard(x, y);
                System.out.println(("Boardsize in tiles: " + _Board.length * _Board[0].length));
                solve(getPosition(start));
                if (_Visited.size() == x * y) {
                        System.out.println(this.toString());
                }
                else {
                        System.out.println("Could not find a solution, starting from: " + start);
                }
        }

        /**
         * Attempts to solve a Knights Tour by brute force. Go through every
         * possible move until a solution is found, or til we run out of moves.
         *
         * @param pos The knights current position on the board. As an int[2]
         * where first index is x-axis, and 2nd index is y-axis.
         */
        private void solve(int[] pos) {
                if (pos[0] < 0 || pos[0] >= _Board.length || pos[1] < 0 || pos[1] >= _Board[0].length) {
                        return; //stop if our move is out of bounds
                }
                if (_Visited.contains(_Board[pos[0]][pos[1]]) && !_Visited.isEmpty()) {
                        return; //stop if we've already been at this tile.
                }
                _Visited.add(_Board[pos[0]][pos[1]]);
                for (int[] mov : MOVES) {
                        if (_Visited.size() == (_Board.length * _Board[0].length)) {
                                return;
                        }
                        else {
                                int[] newPosition = new int[2];
                                newPosition[0] = pos[0] + mov[0];
                                newPosition[1] = pos[1] + mov[1];
                                solve(newPosition);
                        }
                }
                if (_Visited.size() != (_Board.length * _Board[0].length)) { //
                        _Visited.remove(_Visited.size() - 1); //backtrack when last move is not the final tile.
                }
        }

        /**
         * Generates a new board filled with tiles named with letters starting
         * from "a" for length, and a numbers starting from 1 for width.
         *
         * @param x A value representing the length of the board, max 25.
         * @param y A value representing the width of the board.
         */
        private void newBoard(int x, int y) {
                String alfa = "abcdefghijklmnopqrstuvxyz";
                if (x > alfa.length() || x < 3 || y < 3 || y > x) { 
                        throw new IndexOutOfBoundsException("Board is over 9000!!1!");
                }
                _Board = new String[x][y];
                for (int i = 0; i < x; i++) {
                        for (int j = 0; j < y; j++) {
                                _Board[i][j] = alfa.substring(i, i + 1) + (j + 1);
                        }
                }
        }

        /**
         * Finds the position for an individual tile in the board.
         *
         * @param tile The tile to search for in this board.
         * @return The position of the tile in this board in the format {x, y}.
         */
        private int[] getPosition(String tile) {
                for (int i = 0; i < _Board.length; i++) {
                        for (int j = 0; j < _Board[0].length; j++) {
                                if (_Board[i][j].equals(tile)) {
                                        int[] pos = {i, j};
                                        return pos;
                                }
                        }
                }
                throw new NullPointerException("Tile not found: " + tile);
        }

        @Override
        public String toString() {
                StringBuilder SB = new StringBuilder();
                String result = _Board.length + "x" + _Board[0].length;
                SB.append(result);
                for (String str : _Visited) {
                        SB.append(" ").append(str);
                }
                return SB.toString();
        }
}
