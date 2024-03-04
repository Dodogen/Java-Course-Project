package windows.MainWindows;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import listeners.CalculateButtonListener;
import windows.SecondaryWindows.DatePanel;
import windows.SecondaryWindows.FullNameInputPanel;
import windows.SecondaryWindows.KidsCounter;

/**
 * Класс, представляющий панель для содержания на ней дат, работника, счетчика детей
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */
public class PeriodPanel extends JPanel {
    /**
     * Панель для ввода начала отпуска
     */
    private DatePanel dpFrom = new DatePanel("Отпуск с...");
    /**
     * панель для ввода конца отпуска
     */
    private DatePanel dpTo = new DatePanel("По...");

    /**
     * поле для ввода ФИО работника
     */
    private FullNameInputPanel nameInputPanel = new FullNameInputPanel("Введите имя сотрудника:");

    /**
     * поле для отображения кол-ва детей
     */
    private KidsCounter kidsCounterPanel = new KidsCounter("Введите количество детей: ");

    /**
     * стандартная ширина
     */
    private int width = 490; // 490

    /**
    * стандартная высота
    */
    private int height = 128; // 128

    /**
     * Конструктор, создающий панель фиксированных размеров
     */
    public PeriodPanel() {
        setLayout(new GridLayout(2, 2));
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));

        add(dpFrom);
        add(nameInputPanel);
        add(dpTo);
        add(kidsCounterPanel);
        setVisible(true);

        CalculateButtonListener.datePanelFrom = dpFrom;
        CalculateButtonListener.datePanelTo = dpTo;
    }
}
