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

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MazeMenu extends MenuBar {

  public MazeMenu() {
    MenuItem fileNewMenuItem = new MenuItem("New");
    fileNewMenuItem.setOnAction((ae) -> {
      // generate new maze
    });

    MenuItem fileCloseMenuItem = new MenuItem("Close");
    fileCloseMenuItem.setOnAction((ae) -> {
      Platform.exit();
    });

    Menu fileMenu = new Menu("File");
    fileMenu.getItems().add(fileNewMenuItem);
    fileMenu.getItems().add(new SeparatorMenuItem());
    fileMenu.getItems().add(fileCloseMenuItem);

    Menu editMenu = new Menu("Edit");

    Menu helpMenu = new Menu("Help");

    this.getMenus().add(fileMenu);
    this.getMenus().add(editMenu);
    this.getMenus().add(helpMenu);
  }

}
