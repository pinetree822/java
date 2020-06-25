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
    for (JButton b : Arrays.asList(deleteButton, copyButton)) {
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
  @Override public Component getListCellRendererComponent(
      JList<? extends E> list, E value, int index,
      boolean isSelected, boolean cellHasFocus) {
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
    for (JButton b : Arrays.asList(deleteButton, copyButton)) {
      ButtonModel m = b.getModel();
      m.setRollover(false);
      m.setArmed(false);
      m.setPressed(false);
      m.setSelected(false);
    }
  }
}