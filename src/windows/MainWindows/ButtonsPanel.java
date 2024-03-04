package windows.MainWindows;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import listeners.CalculateButtonListener;
import listeners.ClearButtonListener;
import listeners.SaveButtonListener;
import windows.InformationalWindows.MainWindow;
import windows.SecondaryWindows.DoubledButtonPanel;

/**
 * Класс, представляющий панель с рабочими кнопками
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */

public class ButtonsPanel extends JPanel {
    /**
     * Кнопка для печати отчёта
     */
    private JButton jbReportToFile = new JButton("Отчёт");

    /**
     * Кнопка для подсчета
     */
    private JButton jbCalculate = new JButton("Подсчёт");

    /**
     * Кнопка для очистки данных
     */
    private JButton jbClear = new JButton("Очистка");

    /**
     * Кнопка выхода
     */
    private JButton jbExit = new JButton("Выход");

    /**
     * Двойная кнопка
     */
    private DoubledButtonPanel dbp = new DoubledButtonPanel();

    /**
     * стандартная ширина всей панели
    */
    private int width = 490;// 490

    /**
     * стандартная высота всей панели
     */
    private int height = 53;// 43

    /**
     * стандартная ширина любой кнопки
     */
    private int btWidth = 90; // 115

    /**
     * стандартная высота любой кнопки
     */
    private int btHeight = 43; // 43

    /**
    * Конструктор класса, добавляющий кнопки на панель,
    * располагающий их последовательно,
    * добавляющий слушателей нажатия на каждую кнопку
    */
    public ButtonsPanel() {
        setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        setLayout(new FlowLayout(FlowLayout.CENTER, 7, 0));

        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));

        setButtonsSizes();

        add(jbReportToFile);
        add(jbCalculate);
        add(jbClear);
        add(jbExit);
        add(dbp);

        setVisible(true);

        jbReportToFile.addActionListener(new SaveButtonListener());
        jbCalculate.addActionListener(new CalculateButtonListener());
        jbClear.addActionListener(new ClearButtonListener());
        jbExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                MainWindow.instance.closeWindow();
            }
        });
    }

    /**
     * задает всем кнопкам стандартные размеры
     */
    private void setButtonsSizes() {
        jbReportToFile.setPreferredSize(new Dimension(btWidth, btHeight));
        jbCalculate.setPreferredSize(new Dimension(btWidth, btHeight));
        jbClear.setPreferredSize(new Dimension(btWidth, btHeight));
        dbp.setPreferredSize(new Dimension(btWidth, btHeight));
        jbExit.setPreferredSize(new Dimension(btWidth, btHeight));
    }

}
