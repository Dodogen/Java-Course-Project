package windows.SecondaryWindows;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import windows.InformationalWindows.About;
import windows.InformationalWindows.Author;

/**
 * Класс, реализующий панель с двумя тесно расположенными кнопками
 */
public class DoubledButtonPanel extends JPanel {
    /**
     * Кнопка для вызова окна "Об авторе"
     */
    private JButton jbAuthor = new JButton("Об авторе");

    /**
     * Кнопка для вызова окна "О программе"
     */
    private JButton jbAbout = new JButton("О программе");

    /**
     * стандартная ширина любой кнопки
     */
    private int width = 115; // 115

    /**
     * стандартная высота любой кнопки
     */
    private int height = 43; // 43

    /**
     * Коструктор создающий панель с двумя близко расположенными кнопками и привязывает их к событиям
     */
    public DoubledButtonPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));

        jbAbout.setPreferredSize(new Dimension(width, (height)/2));
        jbAbout.setMinimumSize(new Dimension(width, (height)/2));
        jbAbout.setMaximumSize(new Dimension(width, (height)/2));

        jbAuthor.setPreferredSize(new Dimension(width, (height)/2));
        jbAuthor.setMinimumSize(new Dimension(width, (height)/2));
        jbAuthor.setMaximumSize(new Dimension(width, (height)/2));

        add(jbAbout);
        add(jbAuthor);

        setVisible(true);

        jbAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                About aboutProgramWindow= new About();
                aboutProgramWindow.setVisible(true);
            }
        });

        jbAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Author aboutAuthorMenu = new Author();
                aboutAuthorMenu.setVisible(true);
            }

        });

    }
}
