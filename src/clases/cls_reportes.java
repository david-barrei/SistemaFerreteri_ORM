package clases;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Raider
 */
public class cls_reportes {

    private static final String URL = "jdbc:mysql://localhost:3310/ferreteria?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static java.sql.Connection connection = null;

    public JasperViewer ReporteCliente() {
        JasperViewer obj = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("conectado");
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("src/reportes/report_clientes.jasper");
            JasperPrint printer = JasperFillManager.fillReport(reporte, null, connection);
            obj = new JasperViewer(printer, false);
            obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            obj.setVisible(true);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return obj;
    }

    public JasperViewer ReporteFactura() {
        JasperViewer obj = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("conectado");
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("src/reportes/report_factura.jasper");
            JasperPrint printer = JasperFillManager.fillReport(reporte, null, connection);
            obj = new JasperViewer(printer, false);
            obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            obj.setVisible(true);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return obj;
    }

}
