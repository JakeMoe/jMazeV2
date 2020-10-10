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
import javafx.scene.layout.BorderPane;

public class MazeMain extends BorderPane {

  private final Maze maze = new Maze(20, 20, 20, 10);

  public MazeMain(MazeMenu menuBar, MazePane contentPane) {
    this.setTop(menuBar);
    this.setCenter(contentPane);
  }

  public Maze getMaze() {
    return maze;
  }

}
