package graphiceditor.Controller;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
final class EditorFrame extends JFrame implements KeyListener, ActionListener {

  private EditorControl editorControl = new EditorControl();

  public EditorFrame(int breite, int hoehe) {
    super("Grafikeditor");
    erzeugeUndSetzeEditorPanel();
    fensterEinmitten(breite, hoehe);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    buildMenu();
    buildToolbar();
    setVisible(true);
    addKeyListener(this);
  }

  private void erzeugeUndSetzeEditorPanel() {
    JPanel panel = new EditorPanel(editorControl);
    setContentPane(panel);
    // buildToolbar(panel);
  }

  private void fensterEinmitten(int breite, int hoehe) {
    Dimension bildschirmGroesse = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle fensterAusschnitt = new Rectangle();
    fensterAusschnitt.width = breite;
    fensterAusschnitt.height = hoehe;
    fensterAusschnitt.x = (bildschirmGroesse.width - fensterAusschnitt.width) / 2;
    fensterAusschnitt.y = (bildschirmGroesse.height - fensterAusschnitt.height) / 2;
    setBounds(fensterAusschnitt);
  }

  private void buildMenu() {

    // create new MenuBar
    JMenuBar bar = new JMenuBar();
    bar.setSize(100, 100);
    // set new MenuBar
    setJMenuBar(bar);
    // create new menu
    JMenu menu = new JMenu("Datei");
    // add menu to MenuBar
    bar.add(menu);

    // "Öffnen" item
    JMenuItem oeffnen = new JMenuItem("Öffnen");
    oeffnen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
            InputEvent.CTRL_DOWN_MASK));
    oeffnen.setActionCommand("open");
    oeffnen.addActionListener(this);
    menu.add(oeffnen);

    // "Speichern" item
    JMenuItem speichern = new JMenuItem("Speichern");
    speichern.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
            InputEvent.CTRL_DOWN_MASK));
    speichern.setActionCommand("save");
    speichern.addActionListener(this);
    menu.add(speichern);
    menu.addSeparator();

    // "Beenden" item
    JMenuItem beenden = new JMenuItem("Beenden");
    beenden.setActionCommand("exit");
    beenden.addActionListener(this);
    menu.add(beenden);
  }

  private void buildToolbar() {
    // Create new ToolBar
    JToolBar bar = new JToolBar();
    bar.setSize(500, 300);
    bar.setFloatable(true);
    add(bar, BorderLayout.NORTH);

    // Buttons
    JButton rect = new JButton("Rechteck");
    rect.setToolTipText("Rechteck zeichnen");
    rect.setActionCommand("rect");
    rect.addActionListener(this);
    bar.add(rect);

    JButton circ = new JButton("Kreis");
    circ.setToolTipText("Kreis zeichnen");
    circ.setActionCommand("circ");
    circ.addActionListener(this);
    bar.add(circ);

    JButton line = new JButton("Linie");
    line.setToolTipText("Linie zeichnen");
    line.setActionCommand("line");
    line.addActionListener(this);
    bar.add(line);
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    editorControl.setFigurTyp(e.getKeyChar());
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    String cmd = e.getActionCommand();
    if (obj instanceof JMenuItem) {
      System.out.println("Menue: " + cmd);
      if (cmd.equals("exit"))
        System.exit(0);
    } else if (obj instanceof JButton) {
      System.out.println("Toolbar: " + cmd);
    }
  }
}
