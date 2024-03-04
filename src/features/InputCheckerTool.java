package features;

import java.util.ArrayList;
import java.util.Date;

import windows.SecondaryWindows.DatePanel;

/**
 * Класс, содержащий инструменты для проверки входящих данных
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */
public class InputCheckerTool {
    /**
     * проверяет список на наличие пустых элементов
     * 
     * @param list - массив для проверки
     * @return true, если в списке есть пустые элементы, иначе false
     */
    public static boolean isAnyEmpty(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isEmpty())
                return true;
        }
        return false;
    }

    /**
     * Проверяет, являются ли элементы списка числами типа double или пустыми
     * значениями.
     * 
     * @param list список для проверки
     * @return true, если все элементы списка являются числами типа double или
     *         пустыми значениями, иначе false
     */
    public static boolean isDoubleOrEmpty(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isEmpty() || list.get(i).isBlank() || list.get(i) == null) {
                continue;
            }
            if (!tryParseDouble(list.get(i))) {
                return false;
            }

            if (Double.parseDouble(list.get(i)) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Пытается преобразовать строку в число типа double.
     * 
     * @param value строка для преобразования
     * @return true, если строка может быть преобразована в число типа double, иначе
     *         false
     */
    public static boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Проверяет корректность введенной даты.
     * 
     * @param panelFrom панель для выбора начальной даты
     * @param panelTo   панель для выбора конечной даты
     * @return true, если введенная дата корректна, иначе false
     */
    public static boolean isCorrectDateInput(DatePanel panelFrom, DatePanel panelTo) {
        Date dateFrom = (Date) panelFrom.getSpinner().getValue();
        Date dateTo = (Date) panelTo.getSpinner().getValue();

        if (dateFrom == null || dateTo == null) {
            return false;
        }

        if (dateFrom.toString().isEmpty() || dateTo.toString().isEmpty()) {
            return false;
        }

        if (dateFrom.compareTo(dateTo) > -1) {
            return false;
        }

        return true;
    }
}
