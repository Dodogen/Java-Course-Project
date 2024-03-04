package windows.SecondaryWindows;

import java.awt.Dimension;
import javax.swing.JTextArea;

/**
 * Класс, представляющий панель для информации
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */
public class InformationPlace extends JTextArea {
    /**
     * стандартная ширина
     */
    private int width = 490; // 490

    /**
     * стандартная высота
     */
    private int height = 120; // 120

    /**
     * создает место для непорседственного вода информации
     */
    public InformationPlace() {
        setEditable(false);

        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));

        setVisible(true);
    }

    /**
     * Добавляет текст на панель
     * @param text для панели
     */
    public void addInfo(String text) {
        append(text + "\n");
    }

    /**
     * полностью очищает панель
     */
    public void clearAllInfo() {
        this.setText("");
    }
}
