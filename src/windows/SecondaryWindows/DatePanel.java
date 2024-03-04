package windows.SecondaryWindows;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import java.util.Date;
import java.util.Calendar;

/**
 * Класс представляющий маленькую панель для ввода даты
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */

public class DatePanel extends JPanel {
    /**
     * Надпись на основным элементом
     */
    private JLabel jlCaption = new JLabel();

    /**
     * Спиннер для ввода даты
     */
    private JSpinner scpDate;

    /**
     * Стандартная ширина элемента
     */
    private int width = 259;

    /**
     * Стандартная высота элемента
     */
    private int height = 54;

    /**
     * Конструктор создающий маленькую панель для ввода како-либо даты
     * @param caption надпись над полем
     */
    public DatePanel(String caption) {
        scpDate = new JSpinner(setSpinnerProperties());
        // Установка формата отображения даты
        JSpinner.DateEditor editor = new JSpinner.DateEditor(this.scpDate, "dd.MM.yyyy");
        this.scpDate.setEditor(editor);

        this.jlCaption.setText(caption);
        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setLayout(new GridLayout(2, 0, 0, 0));
        add(jlCaption);
        add(scpDate);
        setVisible(true);
    }

    /**
     * Устанавливает вид JSpinner -> SpinnerDateModel
     * @return
     */
    private SpinnerDateModel setSpinnerProperties() {
        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        return dateModel;
    }

    /**
     * Получает поле для даты
     * @return JSpinner, в котором находится дата
     */
    public JSpinner getSpinner() {
        return this.scpDate;
    }
}