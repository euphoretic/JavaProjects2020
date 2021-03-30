import javax.swing.*;
import java.awt.*;

public class ResultWindow extends JFrame {
    /**
     * подпись для результата
     */
    private JLabel lTime;

    /**
     * с помощью данных формируем окно результат
     * @param timeStart время начала ввода
     * @param timeEnd время конца ввода, нажатия кнопки end
     * @param text введенный в текстбокс текст, по количеству символов рассчитывается скорость на основе параметров времени
     */

    public ResultWindow(long timeStart, long timeEnd, String text){
        super("Result");
        setBounds(300, 300, 350, 100);
        lTime = new JLabel();
        int amount= text.length();
        double speed = (amount*10e4/((timeEnd-timeStart)*5/3));
        System.out.println(timeEnd-timeStart);
        lTime.setText("Средняя скорость: "+String.format("%.3f",speed)+" символов в минуту");


        JPanel panel = new JPanel();
        panel.add(lTime);
        getContentPane().add(panel);
        setResizable(false);
        setVisible(true);
    }
}
