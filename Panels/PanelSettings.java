/*
 * Copyright by Luca Keller
 */

package Panels;

import MiscMain.Game;
import MiscMain.Settings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSettings extends JPanel implements ActionListener
{
  private Game game;
  private Settings playerSettings = Settings.SINGLEPLAYER; //Single or Double Player
  private Settings difficulty = Settings.eZ;     // Difficulty

  private int btnSizeW = 250;
  private int btnSizeH = 50;


  private JButton zurück = new JButton("Zürück");

  private JToggleButton singlePl = new JToggleButton("Einzelspieler", true);
  private JToggleButton doublePl = new JToggleButton("Zwei Spieler", false);

  private JToggleButton eZ = new JToggleButton("Schwierigkeitsgrad -> Einfach",true);
  private JToggleButton medium = new JToggleButton("Schwierigkeitsgrad -> Mittel",false);
  private JToggleButton schwer = new JToggleButton("Schwierigkeitsgrad -> Einfach",false);

  private ButtonGroup schwierigkeit = new ButtonGroup();
  private ButtonGroup playerSelect = new ButtonGroup();

  private boolean changePlayer = false; // When actionperformed is used and player Settings need to be changed
  private boolean changeDifficulty = false;  // When actionperformed is used and difficulty Settings need to be changed

  private boolean back = false;


  public PanelSettings(Game game)
  {
    this.game = game;
    this.setSize(Game.GAME_HEIGHT_WIDTH, Game.GAME_HEIGHT_WIDTH);
    this.setLayout(null);
    initPanelSettings();
  }

  public void initPanelSettings() //TODO vllt irgebdwann theming --> textur
  {
    zurück.setBounds(50,50,btnSizeW / 2, btnSizeH);

    singlePl.setBounds(Game.GAME_HEIGHT_WIDTH / 3 - (btnSizeW /2), (Game.GAME_HEIGHT_WIDTH * 2)/ 3, btnSizeW, btnSizeH);
    doublePl.setBounds((Game.GAME_HEIGHT_WIDTH * 2) / 3 - (btnSizeW /2), (Game.GAME_HEIGHT_WIDTH * 2)/ 3, btnSizeW, btnSizeH);

    eZ.setBounds(Game.GAME_HEIGHT_WIDTH / 6 - (btnSizeW /2), Game.GAME_HEIGHT_WIDTH / 3, btnSizeW, btnSizeH);
    medium.setBounds(Game.GAME_HEIGHT_WIDTH / 2 - (btnSizeW /2), Game.GAME_HEIGHT_WIDTH / 3, btnSizeW, btnSizeH);
    schwer.setBounds((Game.GAME_HEIGHT_WIDTH * 5) / 6 - (btnSizeW /2), Game.GAME_HEIGHT_WIDTH / 3, btnSizeW, btnSizeH);

    playerSelect.add(singlePl);
    playerSelect.add(doublePl);

    schwierigkeit.add(eZ);
    schwierigkeit.add(medium);
    schwierigkeit.add(schwer);

    this.add(zurück);

    this.add(singlePl);
    this.add(doublePl);

    this.add(eZ);
    this.add(medium);
    this.add(schwer);

    zurück.addActionListener(this);

    singlePl.addActionListener(this);
    doublePl.addActionListener(this);

    eZ.addActionListener(this);
    medium.addActionListener(this);
    schwer.addActionListener(this);

    zurück.setVisible(true);

    singlePl.setVisible(true);
    doublePl.setVisible(true);

    eZ.setVisible(true);
    medium.setVisible(true);
    schwer.setVisible(true);
  }

  public void update()
  {
    if(changePlayer == true && back == true)
    {
      game.changePlayerSettings(playerSettings); //TODO Panel ruft Game auf. Vllt State fragt ab und ruft Game auf
      changePlayer = false;

    }
    else if (changeDifficulty == true && back == true)
    {
      game.changeDifficulty(difficulty, playerSettings);
      changeDifficulty = false;

    }
  }
  public void render()
  {
    super.repaint();
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == singlePl)
    {
      playerSettings = Settings.SINGLEPLAYER;
      changePlayer = true;
    }
    else if(e.getSource() == doublePl)
    {
      playerSettings = Settings.DOUBLEPLAYER;
      changePlayer = true;
    }

    if(e.getSource() == eZ)
    {
      difficulty = Settings.eZ;
      changeDifficulty = true;
    }
    else if(e.getSource() == medium)
    {
      difficulty = Settings.MEDIUM;
      changeDifficulty = true;
    }
    else if(e.getSource() == schwer)
    {
      difficulty = Settings.HARD;
      changeDifficulty = true;
    }
    else if(e.getSource() == zurück)
    {
      back = true;
    }

  }

  public boolean getBack()
  {
    return back;
  }

  public void setBack(boolean back)
  {
    this.back = back;
  }
}
