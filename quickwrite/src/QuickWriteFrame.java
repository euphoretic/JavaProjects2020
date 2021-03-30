import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuickWriteFrame extends JFrame {
    /**
     *  переменные для подсчета времени между нажатиями кнопок start и end
     */
    public long timeStart=System.currentTimeMillis(), timeEnd;
    /**
     *  количсетво символов в текстбоксе
     */
    public int amount;
    /**
     * подпись для текстбокса (поля ввода)
     */
    private JLabel lText;
    /**
     *  текстбокс (поле для ввода текста)
     */
    JTextArea jText;
    /**
     * Кнопка для начала подсчета времени ввода
     */
    private JButton startQuickWriteButton = new JButton("Поехали!");
    /**
     * Кнопка для завершения подсчета времени ввода и создания окна результатов
     */
    private JButton endQuickWriteButton = new JButton("Закончить");

    /**
     * Конструктор, создаюший окно приложения
     */
    public QuickWriteFrame(){
        super("QuickWrite");
        setBounds(300, 300, 350, 400);
        lText = new JLabel();
        lText.setPreferredSize(new Dimension(150,20));
        lText.setText("Введите текст: ");
        jText = new JTextArea();
        jText.setPreferredSize(new Dimension(30,100));

        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(2, 1,5,12);

        panel.setLayout(gridLayout);
        panel.add(lText);
        panel.add(jText);

        getContentPane().add(panel);
        startQuickWriteButton.setPreferredSize(new Dimension(150,30));
        endQuickWriteButton.setPreferredSize(new Dimension(150,30));
        startQuickWriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jText.setText(null);
                timeStart = System.currentTimeMillis();
            }
        });
        endQuickWriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeEnd = System.currentTimeMillis();
                String text = jText.getText();
                ResultWindow resultWindow = new ResultWindow(timeStart, timeEnd, text);
            }
        });
        JPanel flowLayoutButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        flowLayoutButtons.add(startQuickWriteButton);
        flowLayoutButtons.add(endQuickWriteButton);

        Container container = getContentPane();
        container.add(flowLayoutButtons, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}

