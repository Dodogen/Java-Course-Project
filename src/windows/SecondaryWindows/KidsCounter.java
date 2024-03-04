package windows.SecondaryWindows;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import listeners.CalculateButtonListener;

import java.awt.*;

/**
 * Класс, представляющий панель со счетчиком детей
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */
public class KidsCounter extends JPanel {
    /**
     * Надпись над основным элементом
     */

    private JLabel jlCaption = new JLabel();

    /**
     * Счетчик детей 
     */
    private JSpinner sjCounter;

    /**
     * стандартная ширина
     */
    private int width = 259; // 259

    /**
     * стандартная высота
     */
    private int height = 54;

    /**
     * Создает счетчик детей с надписью сверху
     * @param caption надпись
     */
    public KidsCounter(String caption) {
        this.jlCaption.setText(caption);

        SpinnerNumberModel snm = new SpinnerNumberModel();
        sjCounter = new JSpinner(snm);

        sjCounter.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

        sjCounter.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if ((int) sjCounter.getValue() < 0) {
                    sjCounter.setValue(0);
                    return;
                }

                if ((int) sjCounter.getValue() > 10) {
                    sjCounter.setValue(10);
                    return;
                }
            }
        });

        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setLayout(new GridLayout(2, 0, 0, 0));
        add(jlCaption);
        add(sjCounter);
        setVisible(true);

        CalculateButtonListener.kidsCounter = this;
    }

    /**
     * Получает количество детей
     * @return значение счетчика
     */
    public int getKidsCount() {
        return (int) sjCounter.getValue();
    }

}
