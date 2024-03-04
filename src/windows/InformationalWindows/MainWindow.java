package windows.InformationalWindows;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import windows.MainWindows.ButtonsPanel;
import windows.MainWindows.InformationPanel;
import windows.MainWindows.PeriodPanel;
import windows.MainWindows.YearSalaryPanel;

/**
 * Рабочее окно приложения, которое содержит в себе всю важную логику
 */
public class MainWindow extends JFrame {
    public static MainWindow instance;
    public void closeWindow(){
        this.dispose();
    }
    // add constructor with all main windows
    public MainWindow() {
        CreateWindow(520, 610);
        add(new PeriodPanel());
        add(new YearSalaryPanel());
        add(new InformationPanel());
        add(new ButtonsPanel());
        setVisible(true);
    }

    // creates window for other panels
    private void CreateWindow(int width, int length) {
        setTitle("Калькулятор отпускных");
        setSize(new Dimension(width, length));
        setResizable(false); // prevent from remaining
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("C:\\Users\\roman\\VSCodeProjects\\VacationPaymentsCalculator\\images\\icon.png")
                .getImage());
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow mw= new MainWindow();
        MainWindow.instance = mw;
    }
}
