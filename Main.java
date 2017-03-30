package EndUser;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.GridLayout;
	public class Main{
		public static void main(String[] args){
			JFrame JFrame = new JFrame();
			ArrayList<ArrayList<Question_Panel>> Arrlst_Questions = new ArrayList<ArrayList<Question_Panel>>();
			JFrame.setDefaultLookAndFeelDecorated(true);
			JFrame.setLayout(new GridLayout(0,1));
			Arrlst_Questions.add(new ArrayList<Question_Panel>());
			Arrlst_Questions.get(0).add(new Question_Panel("Is this a question?"));
			Arrlst_Questions.get(0).add(new Question_Panel("Is this a second question?"));
			Arrlst_Questions.get(0).add(new Question_Panel("Pika Pika?"));
			for(int count = 0;Arrlst_Questions.get(0).size()>count;count++){
				JFrame.add(Arrlst_Questions.get(0).get(count));
			}
			//JFrame.pack();
			//int[] size = get_Size(Arrlst_Questions,1);
			//JFrame.setSize(size[0],size[1]);
			JFrame.pack();
			JFrame.setVisible(true);
			JFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		}
		public static int[] get_Size(ArrayList<ArrayList<Question_Panel>> Arrlst_JPanel, int page){
			int[] dimensions = {0,0};
			for(int count = 0;Arrlst_JPanel.get(page-1).size()>count;count++){
				if(Arrlst_JPanel.get(page-1).get(count).getWidth()>dimensions[0])dimensions[0] = Arrlst_JPanel.get(page-1).get(count).getWidth();
				dimensions[1] += Arrlst_JPanel.get(page-1).get(count).getHeight();
			}
			return dimensions;
		}
	}