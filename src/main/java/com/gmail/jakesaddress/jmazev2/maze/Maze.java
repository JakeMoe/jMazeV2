/*
 * This file is part of jMazeV2.
 *
 * jMazeV2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * jMazeV2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jMazeV2.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.gmail.jakesaddress.jmazev2.maze;

import java.util.ArrayDeque;
import java.util.Random;

public class Maze {

  private int cols;
  private int rows;
  private MazeCell[][] cells;

  private enum Direction {
    EAST,
    NORTH,
    SOUTH,
    WEST
  }

  public Maze(int Cols, int Rows) {
    this.cols = Cols;
    this.rows = Rows;

    generate();
  }

  public int getCols() {
    return cols;
  }

  public void setCols(int cols) {
    this.cols = cols;
  }

  public int getRows() {
    return rows;
  }

  public void setRows(int rows) {
    this.rows = rows;
  }

  public MazeCell[][] getCells() {
    return cells;
  }

  public void generate() {
    cells = new MazeCell[cols][rows];
    for (int col = 0; col < cols; col++) {
      for (int row = 0; row < rows; row++) {
        cells[col][row] = new MazeCell(col, row);
      }
    }

    Random random = new Random();
    int rndCol = random.nextInt(cols);
    int rndRow = random.nextInt(rows);

    ArrayDeque<MazeCell> stack = new ArrayDeque<>();
    stack.push(cells[rndCol][rndRow]);

    while (hasUnvisited(cells)) {
      MazeCell currCell = stack.peek();
      if (hasUnvisitedNeighbor(currCell)) {
        MazeCell nextCell = null;
        boolean foundNeighbor = false;
        do {
          Direction dir = Direction.values()[random.nextInt(4)];
          switch (dir) {
            case EAST:
              if (currCell.getCol() != (cols - 1) && !cells[currCell.getCol() + 1][currCell.getRow()].isVisited()) {
                currCell.setEastWall(false);
                nextCell = cells[currCell.getCol() + 1][currCell.getRow()];
                nextCell.setWestWall(false);
                nextCell.setVisited(true);
                foundNeighbor = true;
              }
              break;
            case NORTH:
              if (currCell.getRow() != 0 && !cells[currCell.getCol()][currCell.getRow() - 1].isVisited()) {
                currCell.setNorthWall(false);
                nextCell = cells[currCell.getCol()][currCell.getRow() - 1];
                nextCell.setSouthWall(false);
                nextCell.setVisited(true);
                foundNeighbor = true;
              }
              break;
            case SOUTH:
              if (currCell.getRow() != (rows - 1) && !cells[currCell.getCol()][currCell.getRow() + 1].isVisited()) {
                currCell.setSouthWall(false);
                nextCell = cells[currCell.getCol()][currCell.getRow() + 1];
                nextCell.setNorthWall(false);
                nextCell.setVisited(true);
                foundNeighbor = true;
              }
              break;
            case WEST:
              if (currCell.getCol() != 0 && !cells[currCell.getCol() - 1][currCell.getRow()].isVisited()) {
                currCell.setWestWall(false);
                nextCell = cells[currCell.getCol() - 1][currCell.getRow()];
                nextCell.setEastWall(false);
                nextCell.setVisited(true);
                foundNeighbor = true;
              }
              break;
          }
          if (foundNeighbor) {
            stack.push(nextCell);
          }
        } while (!foundNeighbor);
      } else {
        currCell = stack.pop();
      }
    }
  }

  private boolean hasUnvisited(MazeCell[][] cells) {
    for (int col = 0; col < cols; col++) {
      for (int row = 0; row < rows; row++) {
        if (!cells[col][row].isVisited()) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean hasUnvisitedNeighbor(MazeCell mazeCell) {
    return ((mazeCell.getCol() != 0          && !cells[mazeCell.getCol() - 1][mazeCell.getRow()].isVisited()) ||
            (mazeCell.getCol() != (cols - 1) && !cells[mazeCell.getCol() + 1][mazeCell.getRow()].isVisited()) ||
            (mazeCell.getRow() != 0          && !cells[mazeCell.getCol()][mazeCell.getRow() - 1].isVisited()) ||
            (mazeCell.getRow() != (rows - 1) && !cells[mazeCell.getCol()][mazeCell.getRow() + 1].isVisited()));
  }

}
