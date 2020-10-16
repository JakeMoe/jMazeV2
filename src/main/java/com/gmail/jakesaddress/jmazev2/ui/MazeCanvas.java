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

package com.gmail.jakesaddress.jmazev2.ui;

import com.gmail.jakesaddress.jmazev2.maze.Maze;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MazeCanvas extends Canvas {

  private Color backgroundColor;
  private int cellSize;
  private Color mazeColor;
  private int padding;

  private int mazeCols, mazeRows;

  private final GraphicsContext gc = this.getGraphicsContext2D();

  public MazeCanvas(int cols, int rows, int cellSize, int padding) {
    this.backgroundColor = Color.WHITE;
    this.cellSize = cellSize;
    this.mazeColor = Color.BLACK;
    this.padding = padding;
    this.setHeight((2 * padding) + (rows * cellSize));
    this.setWidth((2 * padding) + (cols * cellSize));

    this.mazeCols = cols;
    this.mazeRows = rows;
  }

  public void drawMaze(Maze maze) {

    gc.setFill(backgroundColor);
    gc.setLineWidth(1);
    gc.setStroke(mazeColor);

    gc.fillRect(0, 0, this.getWidth(), this.getHeight());

    for (int col = 0; col < mazeCols; col++) {
      for (int row = 0; row < mazeRows; row++) {
        if (maze.getCells()[col][row].hasEastWall()) {
          gc.strokeLine(padding + ((col + 1) * cellSize), padding + (row * cellSize), padding + ((col + 1) * cellSize), padding + ((row + 1) * cellSize));
        }
        if (maze.getCells()[col][row].hasNorthWall()) {
          gc.strokeLine(padding + (col * cellSize), padding + (row * cellSize), padding + ((col + 1) * cellSize), padding + (row * cellSize));
        }
        if (maze.getCells()[col][row].hasSouthWall()) {
          gc.strokeLine(padding + (col * cellSize), padding + ((row + 1) * cellSize), padding + ((col + 1) * cellSize), padding + ((row + 1) * cellSize));
        }
        if (maze.getCells()[col][row].hasWestWall()) {
          gc.strokeLine(padding + (col * cellSize), padding + (row * cellSize), padding + (col * cellSize), padding + ((row + 1) * cellSize));
        }
      }
    }

  }

}
