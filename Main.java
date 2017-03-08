package EndUser;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.GridLayout;
	public class Main{
		public static void main(String[] args){
			JFrame JFrame = new JFrame();
			ArrayList<ArrayList<Question_Panel>> Arrlst_Questions = new ArrayList<ArrayList<Question_Panel>>();
			JFrame.setDefaultLookAndFeelDecorated(true);
			JFrame.setLayout(new GridLayout(0,1));
			JFrame.add(new Question_Panel("Is this a question?"));
			JFrame.add(new Question_Panel("Is this a second question?"));
			JFrame.setSize(new java.awt.Dimension(200,400));
			JFrame.setVisible(true);
			JFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		}
	}