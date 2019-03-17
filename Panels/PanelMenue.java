/*
 * Copyright by Luca Keller
 */

package Panels;
import MiscMain.*;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenue extends JPanel implements ActionListener
{
  private int btnSizeW = 100;
  private int btnSizeH = 75;

  private JButton spielen = new JButton("Spielen");
  private JButton beenden = new JButton("Beenden");
  private JButton settings = new JButton("Einstellungen");

  private boolean starten = false;
  private boolean stoppen = false;
  private boolean config = false;


  public PanelMenue()
  {
    this.setSize(Game.GAME_HEIGHT_WIDTH, Game.GAME_HEIGHT_WIDTH);
    this.setLayout(null);
    initMenuePanel();
  }

  public void initMenuePanel()
  {
    spielen.setBounds(Game.GAME_HEIGHT_WIDTH / 2 - btnSizeW / 2, Game.GAME_HEIGHT_WIDTH / 2 - btnSizeH * 4 / 2, btnSizeW, btnSizeH);
    beenden.setBounds(Game.GAME_HEIGHT_WIDTH / 2 - btnSizeW / 2, Game.GAME_HEIGHT_WIDTH / 2 + btnSizeH , btnSizeW, btnSizeH);
    settings.setBounds(Game.GAME_HEIGHT_WIDTH / 2 - btnSizeW / 2, Game.GAME_HEIGHT_WIDTH / 2 - 30, btnSizeW, btnSizeH);

    this.add(spielen);
    this.add(beenden);
    this.add(settings);

    spielen.addActionListener(this);
    beenden.addActionListener(this);
    settings.addActionListener(this);
  }


  public void update()
  {

  }

  public void render()
  {

  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    starten = false;
    stoppen = false;
    config = false;

    if (e.getSource().equals(spielen)) {
      starten = true;
    } else if (e.getSource().equals(settings)) {
      config = true;
    }
    else
      {
      stoppen = true;
    }
  }

  public boolean getStarten()
  {
    return starten;
  }

  public boolean getStoppen()
  {
    return stoppen;
  }

  public boolean getConfig()
  {
    return config;
  }

}
