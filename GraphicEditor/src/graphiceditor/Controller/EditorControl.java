package graphiceditor.Controller;

import graphiceditor.Model.Figur;
import graphiceditor.Model.Kreis;
import graphiceditor.Model.Linie;
import graphiceditor.Model.Rechteck;
import graphiceditor.View.Zeichnung;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


final class EditorControl {

  private Zeichnung zeichnung = new Zeichnung(new ArrayList<>());
  private char figurTyp;
  private Point ersterPunkt;

  public void allesNeuZeichnen(Graphics g) {
    zeichnung.zeichneFiguren(g);
  }

  public void setFigurTyp(char figurTyp) {
    this.figurTyp = figurTyp;
  }

  public void setErsterPunkt(Point ersterPunkt) {
    this.ersterPunkt = ersterPunkt;
  }

  public void erzeugeFigurMitZweitemPunkt(Point zweiterPunkt) {

    Figur figur;

    int figurX = Math.min(ersterPunkt.x, zweiterPunkt.x);
    int figurY = Math.min(ersterPunkt.y, zweiterPunkt.y);
    int figurWidth = Math.abs(zweiterPunkt.x - ersterPunkt.x);
    int figurHeight = Math.abs(zweiterPunkt.y - ersterPunkt.y);

    switch (figurTyp) {
      case 'k':
        int radius = (int) Math.sqrt((figurHeight * figurHeight) + (figurWidth * figurWidth));
        figur = new Kreis(figurX, figurY, radius);
        break;
      case 'l':
        figur = new Linie(ersterPunkt.x, ersterPunkt.y, zweiterPunkt.x, zweiterPunkt.y);
        break;
        // 'r' nicht nötig da Rechteck sowieso default ist
      default:
        figur = new Rechteck(figurX, figurY, figurWidth, figurHeight);
    }
    zeichnung.hinzufuegen(figur);
  }
}
