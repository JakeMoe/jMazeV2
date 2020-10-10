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

package com.gmail.jakesaddress.jmazev2;

import com.gmail.jakesaddress.jmazev2.maze.Maze;
import com.gmail.jakesaddress.jmazev2.ui.MazeMain;
import com.gmail.jakesaddress.jmazev2.ui.MazeMenu;
import com.gmail.jakesaddress.jmazev2.ui.MazePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Scene scene = new Scene(new MazeMain(new MazeMenu(), new MazePane()));
    primaryStage.setScene(scene);
    primaryStage.setTitle("jMaze V2");
    primaryStage.show();
  }

}
