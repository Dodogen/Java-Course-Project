package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import features.InputCheckerTool;
import models.Employee;
import models.YearSalary;
import windows.MainWindows.InformationPanel;
import windows.MainWindows.PeriodPanel;
import windows.MainWindows.YearSalaryPanel;
import windows.SecondaryWindows.DatePanel;
import windows.SecondaryWindows.FullNameInputPanel;
import windows.SecondaryWindows.KidsCounter;

/**
 * Слушатель для кнопки "Рассчитать".
 * Проверяет все значение на возможность конвертации их в тип тип Double
 * Проверяет правильность введенной даты отпуска
 * Если все правильно, то возвращает результат
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */
public class CalculateButtonListener implements ActionListener {
    /**
     * Информационная панель, на которую выводится отчет либо предупреждение об
     * ошибке
     */
    public static InformationPanel infoPanel;

    /**
     * Панель, содержащая ячейки для ввода зароботной платы
     */
    public static YearSalaryPanel ysPanel;

    /**
     * Панель содержащая поля для ввода даты
     */
    public static PeriodPanel periodPanel;

    /**
     * Панель содержащая поля для ввода имени
     */
    public static FullNameInputPanel nameInputPanel;

    /**
     * Для ввода количества детей
     */
    public static KidsCounter kidsCounter;

    /**
     * Панель для выбора даты начала отпуска
     */
    public static DatePanel datePanelFrom;

    /**
     * Панель для ввода даты конца отпуска
     */
    public static DatePanel datePanelTo;

    /**
     * Обработчик события нажатия на кнопку.
     * Проверяет входящие данные и выводит результат проверки
     * Успешная проверка выводит отчет о работнике
     * @param e событие ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> strSalaries = ysPanel.getMonthSalaries();
        if (InputCheckerTool.isDoubleOrEmpty(strSalaries)) {
            ArrayList<Double> salaries = new ArrayList<Double>(strSalaries.size());
            for (int i = 0; i < strSalaries.size(); i++) {
                try {
                    salaries.add(Double.parseDouble(strSalaries.get(i)));
                } catch (NumberFormatException ex) {
                    ysPanel.setMonthSalary(i, "");
                    salaries.add(.00000000000000001);
                }
            }

            if (InputCheckerTool.isCorrectDateInput(datePanelFrom, datePanelTo)) {
                Employee emp = new Employee(nameInputPanel.getName(), new YearSalary(salaries),
                        (Date) datePanelFrom.getSpinner().getValue(), (Date) datePanelTo.getSpinner().getValue(),
                        kidsCounter.getKidsCount(),
                        false);

                infoPanel.clearAllInfo();
                infoPanel.addInfo(emp.toString());

            } else {
                infoPanel.clearAllInfo();
                infoPanel.addInfo("Проверьте ввод данных вашего отпуска");
            }
        } else {
            infoPanel.clearAllInfo();
            infoPanel.addInfo("Одно из чисел имеет неправильный формат");
        }
    }

}
