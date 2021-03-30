import javax.swing.*;
import java.awt.*;

/*3.6.
Вариант 6
Создать программу, показывающую среднюю скорость печати пользователя в
минуту. Т.е. при вводе любого текста в текстбокс, программа сразу же показывает его
примерную скорость (чтобы не нужно было ждать целую минуту, чтобы узнать
среднюю скорость печати в минуту).
*/

public class QuickWrite {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> { QuickWriteFrame frame = new QuickWriteFrame(); });
    }
}
