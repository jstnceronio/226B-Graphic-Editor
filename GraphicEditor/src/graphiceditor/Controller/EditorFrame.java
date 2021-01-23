package graphiceditor.Controller;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EditorFrame extends JFrame implements KeyListener, ActionListener {

  private EditorControl editorControl = new EditorControl();

  public JButton rect;
  public JButton circ;
  public JButton line;
  public JLabel function;
  public JLabel mouse;

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
    panel.setLayout(new BorderLayout());
    setContentPane(panel);

    panel.addMouseMotionListener(new MouseAdapter() {
      @Override
      public void mouseMoved(MouseEvent e) {
        mouse.setText("Maus: x=" + e.getX() + " y=" + e.getY());
      }
    });
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
    JMenu edit = new JMenu("Bearbeiten");

    // add menu to MenuBar
    bar.add(menu);
    bar.add(edit);

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

    // "Neu" item
    JMenuItem rueckgaengig = new JMenuItem("Rückgängig");
    rueckgaengig.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
            InputEvent.CTRL_DOWN_MASK));
    rueckgaengig.setActionCommand("undo");
    rueckgaengig.addActionListener(this);
    edit.add(rueckgaengig);

    // "Neu" item
    JMenuItem cut = new JMenuItem("Ausschneiden");
    cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
            InputEvent.CTRL_DOWN_MASK));
    cut.setActionCommand("cut");
    cut.addActionListener(this);
    edit.add(cut);
  }

  private void buildToolbar() {
    // Create North ToolBar
    JToolBar bar = new JToolBar();
    bar.setFloatable(false);
    add(bar, BorderLayout.NORTH);

    // Create South ToolBar
    JToolBar footerBar = new JToolBar();
    footerBar.setFloatable(false);
    footerBar.setBackground(Color.ORANGE);
    add(footerBar, BorderLayout.SOUTH);

    // Funktion Label
    function = new JLabel("Funktion: Rechteck");
    footerBar.add(function);

    // Maus Position Label
    mouse = new JLabel("Maus: x=0, y=0");
    EmptyBorder border = new EmptyBorder(5, 500, 5, 20);
    mouse.setBorder(border);

    footerBar.add(mouse);

    // Buttons
    rect = new JButton("Rechteck");
    rect.setToolTipText("Rechteck zeichnen");
    rect.setActionCommand("rect");
    rect.addActionListener(this);
    bar.add(rect);

    circ = new JButton("Kreis");
    circ.setToolTipText("Kreis zeichnen");
    circ.setActionCommand("circ");
    circ.addActionListener(this);
    bar.add(circ);

    line = new JButton("Linie");
    line.setToolTipText("Linie zeichnen");
    line.setActionCommand("line");
    line.addActionListener(this);
    bar.add(line);
  }

  @Override
  public void keyTyped(KeyEvent e) { }

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
      switch (cmd) {
        case "rect":
          editorControl.setFigurTyp('r');
          function.setText("Funktion: Rechteck");
          break;
        case "circ":
          editorControl.setFigurTyp('k');
          function.setText("Funktion: Kreis");
          break;
        case "line":
          editorControl.setFigurTyp('l');
          function.setText("Funktion: Linie");
          break;
        default:
          System.out.println("Invalid command");
          break;
      }
    }
  }
}
