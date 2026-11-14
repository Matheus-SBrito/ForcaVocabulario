package screens;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class ObservadorHoverDoBotaoPlay extends MouseAdapter{
	 private JButton botao;

	    public ObservadorHoverDoBotaoPlay(JButton botao) {
	        this.botao = botao;
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {
	        pintar(Color.orange);
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
	        pintar(Color.BLACK);
	    }

	    private void pintar(Color cor) {
	        for (Component c : botao.getComponents()) {
	            if (c instanceof JLabel) {
	                JLabel lbl = (JLabel) c;
	                lbl.setForeground(cor);
	                lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, cor));
	            }
	        }
	    }
}
