package windows.SecondaryWindows;

import java.awt.Dimension;

import javax.swing.*;

import listeners.CalculateButtonListener;
import listeners.ClearButtonListener;

import java.awt.GridLayout;
import java.awt.Color;

/**
 * Класс представляющий маленькую панель для ввода имени
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */
public class FullNameInputPanel extends JPanel {
    /**
     * Надпись над основным элементом
     */
    private JLabel jlCaption = new JLabel();

    /**
     * Поля для ввода имени
     */
    private JTextArea jtaNameInput = new JTextArea();

    /**
     * Стандартная ширина
     */
    private int width = 259;
    /**
     * Стандартная высота
     */
    private int height = 54;

    /**
     * Создает маленькую панель для ввода имени
     * @param caption надпись на панели
     */
    public FullNameInputPanel(String caption) {
        this.jlCaption.setText(caption);

        setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

        jtaNameInput.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setLayout(new GridLayout(2, 0, 0, 0));
        add(jlCaption);
        add(jtaNameInput);
        setVisible(true);

        CalculateButtonListener.nameInputPanel = this;
        ClearButtonListener.fniPanel = this;
    }

    /**
     * Получает имя работника из поля
     */
    public String getName() {
        return jtaNameInput.getText();
    }

    /**
     * Устанавливает имя работника
     */
    public void setName() {
        jtaNameInput.setText("");
    }

}
