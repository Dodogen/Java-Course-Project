package windows.MainWindows;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import listeners.CalculateButtonListener;
import windows.SecondaryWindows.InformationPlace;

/**
 * Класс, представляющий панель для отображения информации
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */
public class InformationPanel extends JPanel {
    /**
     * Место для текста
     */
    private InformationPlace infoPlace = new InformationPlace();

    /**
     * стандартная ширина элемента
     */
    private int width = 490; // 490

    /**
     * стандартная высота элемента
     */
    private int height = 132; // 132

    /**
     * Конструктор добавляющий на панель текстовую область
     * и инициализирующий поле CalculateButtonListener.infoPanel,
     * чтобы иметь возможность редактировать ее содержимое
     */
    public InformationPanel() {
        // setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK, 1));
        setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        setBorder(BorderFactory.createTitledBorder("Информация"));

        // setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
        setLayout(new BorderLayout());
        add(infoPlace, BorderLayout.CENTER);

        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));

        setVisible(true);

        CalculateButtonListener.infoPanel = this;
    }

    /**
     * Добавляет текст на панель
     * @param text добавляется на панель
     */
    public void addInfo(String text) {
        infoPlace.addInfo(text);
    }

    /**
     * Полность очищает панель
     */
    public void clearAllInfo() {
        infoPlace.clearAllInfo();
    }
}
