package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import windows.MainWindows.YearSalaryPanel;
import windows.SecondaryWindows.FullNameInputPanel;

/**
 * Класс-слушатель для кнопки "Очистить"
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */
public class ClearButtonListener implements ActionListener {
    /**
     * панель содержащая ячейки зарплаты
     */
    public static YearSalaryPanel ysPanel;

    /**
     * Панель для ввода имени
     */
    public static FullNameInputPanel fniPanel;

    /**
     * Обрабатывает нажатие на кнопку.
     * Очищает поле работника и ячейки зарплаты
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < ysPanel.getMonthSalaries().size(); i++) {
            ysPanel.setMonthSalary(i, "");
        }

        fniPanel.setName();
    }

}
