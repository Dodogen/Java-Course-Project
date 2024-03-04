package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Employee;

/**
 * Класс, содержащий инструменты для сохранения данных в файл формата .txt
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */
public class SaveButtonListener implements ActionListener {
    /**
     * Объект класса Employee, требующийся для создания отчёта для записи в файл
     */
    public static Employee emp;

    /**
     * Вызывает метод объекта класса Employee, который записывает информацию о себе в файл
     * Не записывает, если предварительно не создать объект и информацию о немЫ
     * @param ActionEvent представляет собой объект, вызвавший событие
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            emp.reportToFile();
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Для начала необходимо посчитать отпускные", "Внимание",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
