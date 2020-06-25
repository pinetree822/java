package test1;
//-*- mode:java; encoding:utf-8 -*-
// vim:set fileencoding=utf-8:
//@homepage@
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public final class MainPanel extends JPanel {
    private MainPanel() {
        super(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("11\n1");
        model.addElement("222222222222222\n222222222222222");
        model.addElement("3333333333333333333\n33333333333333333333\n33333333333333333");
        model.addElement("444");

        JList<String> list = new JList<String>(model) {
            private transient MouseAdapter cbml;
            @Override public void updateUI() {
                removeMouseListener(cbml);
                removeMouseMotionListener(cbml);
                super.updateUI();
                setFixedCellHeight(-1);
                cbml = new CellButtonsMouseListener(this);
                addMouseListener(cbml);
                addMouseMotionListener(cbml);
                setCellRenderer(new ButtonsRenderer<String>(model));
            }
        };

        add(new JScrollPane(list));
        setPreferredSize(new Dimension(320, 240));
    }
    public static void main(String... args) {
        EventQueue.invokeLater(new Runnable() {
            @Override public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
               | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        JFrame frame = new JFrame("@title@");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class CellButtonsMouseListener extends MouseAdapter {
    private int prevIndex = -1;
    private JButton prevButton;
    private final JList<String> list;
    protected CellButtonsMouseListener(JList<String> list) {
        super();
        this.list = list;
    }
    @Override public void mouseMoved(MouseEvent e) {
        //JList list = (JList) e.getComponent();
        Point pt = e.getPoint();
        int index = list.locationToIndex(pt);
        if (!list.getCellBounds(index, index).contains(pt)) {
            if (prevIndex >= 0) {
                listRepaint(list, list.getCellBounds(prevIndex, prevIndex));
            }
            index = -1;
            prevButton = null;
            return;
        }
        if (index >= 0) {
            JButton button = getButton(list, pt, index);
            ButtonsRenderer renderer = (ButtonsRenderer) list.getCellRenderer();
            renderer.button = button;
            if (Objects.nonNull(button)) {
                button.getModel().setRollover(true);
                renderer.rolloverIndex = index;
                if (!button.equals(prevButton)) {
                    listRepaint(list, list.getCellBounds(prevIndex, index));
                }
            } else {
                renderer.rolloverIndex = -1;
                Rectangle r = null;
                if (prevIndex == index) {
                    if (prevIndex >= 0 && Objects.nonNull(prevButton)) {
                        r = list.getCellBounds(prevIndex, prevIndex);
                    }
                } else {
                    r = list.getCellBounds(index, index);
                }
                listRepaint(list, r);
                prevIndex = -1;
            }
            prevButton = button;
        }
        prevIndex = index;
    }
    @Override public void mousePressed(MouseEvent e) {
        //JList list = (JList) e.getComponent();
        Point pt = e.getPoint();
        int index = list.locationToIndex(pt);
        if (index >= 0) {
            JButton button = getButton(list, pt, index);
            if (Objects.nonNull(button)) {
                ButtonsRenderer renderer = (ButtonsRenderer) list.getCellRenderer();
                renderer.pressedIndex = index;
                renderer.button = button;
                listRepaint(list, list.getCellBounds(index, index));
            }
        }
    }
    @Override public void mouseReleased(MouseEvent e) {
        //JList list = (JList) e.getComponent();
        Point pt = e.getPoint();
        int index = list.locationToIndex(pt);
        if (index >= 0) {
            JButton button = getButton(list, pt, index);
            if (Objects.nonNull(button)) {
                ButtonsRenderer renderer = (ButtonsRenderer) list.getCellRenderer();
                renderer.pressedIndex = -1;
                renderer.button = null;
                button.doClick();
                listRepaint(list, list.getCellBounds(index, index));
            }
        }
    }
    private static void listRepaint(JList list, Rectangle rect) {
        Optional.ofNullable(rect).ifPresent(list::repaint);
//         if (Objects.nonNull(rect)) {
//             list.repaint(rect);
//         }
    }
    private static JButton getButton(JList<String> list, Point pt, int index) {
        Component c = list.getCellRenderer().getListCellRendererComponent(list, "", index, false, false);
        Rectangle r = list.getCellBounds(index, index);
        c.setBounds(r);
        //c.doLayout(); //may be needed for mone LayoutManager
        pt.translate(-r.x, -r.y);
        Component b = SwingUtilities.getDeepestComponentAt(c, pt.x, pt.y);
        if (b instanceof JButton) {
            return (JButton) b;
        } else {
            return null;
        }
    }
}

class ButtonsRenderer<E> extends JPanel implements ListCellRenderer<E> {
    private static final Color EVEN_COLOR = new Color(230, 255, 230);
    private final JTextArea textArea = new JTextArea();
    private final JButton deleteButton = new JButton(new AbstractAction("delete") {
        @Override public void actionPerformed(ActionEvent e) {
            if (model.getSize() > 1) {
                model.remove(index);
            }
        }
    });
    private final JButton copyButton = new JButton(new AbstractAction("copy") {
        @Override public void actionPerformed(ActionEvent e) {
            model.add(index, model.get(index));
        }
    });
    private final DefaultListModel<E> model;
    private int index;
    public int pressedIndex  = -1;
    public int rolloverIndex = -1;
    public JButton button;

    protected ButtonsRenderer(DefaultListModel<E> model) {
        super(new BorderLayout());
        this.model = model;
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 0));
        setOpaque(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        add(textArea);

        Box box = Box.createHorizontalBox();
        for (JButton b: Arrays.asList(deleteButton, copyButton)) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
            box.add(b);
            box.add(Box.createHorizontalStrut(5));
        }
        add(box, BorderLayout.EAST);
    }
    @Override public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        d.width = 0; // VerticalScrollBar as needed
        return d;
    }
    @Override public Component getListCellRendererComponent(JList<? extends E> list, E value, int index, boolean isSelected, boolean cellHasFocus) {
        textArea.setText(Objects.toString(value, ""));
        this.index = index;
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            textArea.setForeground(list.getSelectionForeground());
        } else {
            setBackground(index % 2 == 0 ? EVEN_COLOR : list.getBackground());
            textArea.setForeground(list.getForeground());
        }
        resetButtonStatus();
        if (Objects.nonNull(button)) {
            if (index == pressedIndex) {
                button.getModel().setSelected(true);
                button.getModel().setArmed(true);
                button.getModel().setPressed(true);
            } else if (index == rolloverIndex) {
                button.getModel().setRollover(true);
            }
        }
        return this;
    }
    private void resetButtonStatus() {
        for (JButton b: Arrays.asList(deleteButton, copyButton)) {
            ButtonModel m = b.getModel();
            m.setRollover(false);
            m.setArmed(false);
            m.setPressed(false);
            m.setSelected(false);
        }
    }
}

