package graphiceditor.Controller;


import graphiceditor.Model.Figur;
import graphiceditor.View.Display;
import graphiceditor.Model.Gruppe;
import graphiceditor.Model.Spitzbueb;
import graphiceditor.View.Zeichnung;

import java.util.ArrayList;
import java.util.List;

public class Grafikeditor {

    public static void main(String[] args) {
        new Grafikeditor();
    }

    private Grafikeditor() {
        @SuppressWarnings("unused")
        EditorFrame frame = new EditorFrame(800, 600);
    }
}
