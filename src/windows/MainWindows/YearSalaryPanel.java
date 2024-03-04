package windows.MainWindows;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import listeners.CalculateButtonListener;
import listeners.ClearButtonListener;
import windows.SecondaryWindows.MonthSalaryPanel;

/**
 * Класс представляющий панель для ввода зарплаты за 12 месяцев
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */
public class YearSalaryPanel extends JPanel {
    /**
     * Количество месяцев в году
     */
    private final int MONTH_COUNT = 12;

    /**
     * Список порядковых номеров месяцев
     */
    private final String[] MONTH_NAMES = new String[] { "Первый", "Второй", "Третий", "Четвертый", "Пятый", "Шестой",
            "Седьмой",
            "Восьмой", "Девятый", "Десятый", "Одиннадцатый", "Двенадцатый", };

    /**
     * Зарплатные ячейки
     */
    private ArrayList<MonthSalaryPanel> salaryCells = new ArrayList<MonthSalaryPanel>(MONTH_COUNT);

    /**
     * Стандартная ширина
     */
    private int width = 490; // 490

    /**
     * Стандартная высота
     */
    private int height = 247; // 247

    /**
     * Конструктор, создающий панель фиксированной величины
     */
    public YearSalaryPanel() {
        setLayout(new GridLayout(4, 3, 10, 10));
        for (int i = 0; i < MONTH_COUNT; i++) {
            MonthSalaryPanel panel = new MonthSalaryPanel(MONTH_NAMES[i]);
            salaryCells.add(panel);
            add(panel);
        }

        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));

        setVisible(true);

        CalculateButtonListener.ysPanel = this;
        ClearButtonListener.ysPanel = this;
    }

    /**
     * Получает значение каждой зарплатной панели
     * @return массив строк, которые нужно распарсить в Double
     */
    public ArrayList<String> getMonthSalaries() {
        ArrayList<String> sals = new ArrayList<>(12);
        for (int i = 0; i < MONTH_COUNT; i++) {
            sals.add(salaryCells.get(i).getTAreaValue());
        }
        return sals;
    }

    /**
     * Устанавливает месячную зарплату
     * @param index для конкретного месяца
     * @param text зароботная плата
     */
    public void setMonthSalary(int index, String text) {
        salaryCells.get(index).setTAreaValue(text);
    }

}