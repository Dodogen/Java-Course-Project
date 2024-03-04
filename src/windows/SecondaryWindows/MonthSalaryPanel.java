package windows.SecondaryWindows;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Класс, представляющий панель для информации
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */
public class MonthSalaryPanel extends JPanel {
    /**
     * Надпись над полем
     */
    private JLabel jlMonthName = new JLabel();

    /**
     * Место для ввода зарплаты за месяц
     */
    private JTextArea taSalaryInput = new JTextArea("720");

    /**
     * стандартная ширина
     */
    private int width = 150; // 150

    /**
     * стандартная высота
     */
    private int height = 47; // 47

    /**
     * Создает ячейку для ввода зарплаты за месяц
     * @param name надпись сверху
     */
    public MonthSalaryPanel(String name) {
        jlMonthName.setText(name);
        // setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK, 1));

        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));

        setLayout(new GridLayout(2, 1));
        add(jlMonthName);
        add(taSalaryInput);

        setVisible(true);

    }

    /**
     * Получает значение зарплаты
     * @return содержимоетекстового поля
     */
    public String getTAreaValue() {
        return this.taSalaryInput.getText();
    }

    /**
     * Меняет содержимое текстового поля
     * @param text текст для изменения
     */
    public void setTAreaValue(String text) {
        this.taSalaryInput.setText(text);
    }

}
