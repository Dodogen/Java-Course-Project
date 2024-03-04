package windows.InformationalWindows;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс, представляющий окно с информацией об авторе.
 */
public class Author extends JFrame {
    /**
     * Конструктор класса Author, инициализирующий окно с информацией об авторе.
     * 
     * @author Barkovets R. S.
     * @version 1.0
     */
    public Author() {
        super("Об авторе");
        setSize(270, 410);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Закрывать только текущее окно
        setLayout(null);
        setLocationRelativeTo(null);
        JLabel lblAuthorWindowData_1 = new JLabel("Автор");
        lblAuthorWindowData_1.setBounds(110, 250, 75, 20);
        JLabel lblAuthorWindowData_2 = new JLabel("Студент группы 10702221");
        lblAuthorWindowData_2.setBounds(50, 270, 200, 20);
        JLabel lblAuthorWindowData_3 = new JLabel("Барковец Роман Сергеевич");
        lblAuthorWindowData_3.setBounds(45, 290, 230, 20);
        JLabel lblAuthorWindowData_4 = new JLabel("romanbarkovets@yandex.ru");
        lblAuthorWindowData_4.setBounds(45, 310, 200, 20);
        JButton cancel = new JButton("Выход");
        add(lblAuthorWindowData_1);
        add(lblAuthorWindowData_2);
        add(lblAuthorWindowData_3);
        add(lblAuthorWindowData_4);
        cancel.setBounds(80, 335, 100, 30);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // При нажатии на "Назад" делаем окно автора невидимым
                setVisible(false);
            }
        });
        add(cancel);
        JLabel foto = new JLabel();
        ImageIcon image = new ImageIcon("C:\\Users\\roman\\VSCodeProjects\\VacationPaymentsCalculator\\images\\avatar.jpg");
        foto.setIcon(image);
        // Устанавливаем положение и размер метки с изображением
        foto.setBounds(30, 0, 200, 250);
        add(foto);
    }

    /**
     * Главный метод, запускающий приложение.
     *
     * @param args Параметры командной строки (не используются).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Author().setVisible(true);
            }
        });
    }
}
