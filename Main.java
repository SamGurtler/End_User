package EndUser;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.util.ArrayList;
	public class Main{
		public static void main(String[] args){
			JFrame JFrame = new JFrame();
			ArrayList<ArrayList<Question_Panel>> Arrlst_Questions = new ArrayList<ArrayList<Question_Panel>>();
			
			JFrame.setDefaultLookAndFeelDecorated(true);
			//JFrame.setLayout();
			JFrame.add(new Question_Panel("Is this a question?"));
			JFrame.add(new Question_Panel("Is this a second question?"));
			JFrame.setVisible(true);
			JFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		}
	}