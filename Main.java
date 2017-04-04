package EndUser;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Scanner;
import java.io.File;
import javax.swing.JLabel;
	public class Main{
		public static void main(String[] args)throws java.io.FileNotFoundException{
			JFrame JFrame = new JFrame();
			ArrayList<ArrayList<Question_Panel>> Arrlst_Questions = new ArrayList<ArrayList<Question_Panel>>();
			ArrayList<JLabel> Arrlst_Sections = new ArrayList<JLabel>();
			Arrlst_Questions.add(new ArrayList<Question_Panel>());
			JFrame.setDefaultLookAndFeelDecorated(true);
			JFrame.setLayout(new GridLayout(0,1));
			Scanner scan = new Scanner(new File("./Questions.txt"));
			for(int counter = -1;scan.hasNext();counter+=0){
				if(scan.hasNext(".*:?")){
					counter++;
					scan.useDelimiter(":");
					Arrlst_Sections.add(new JLabel(scan.nextLine()));
				}
				scan.useDelimiter(".*/?");
				Arrlst_Questions.get(counter).add(new Question_Panel(scan.nextLine()));
			}
			for(int count = 0;Arrlst_Sections.size()>count;count++){
				Arrlst_Sections.get(count).setHorizontalAlignment((int)Arrlst_Sections.get(count).CENTER_ALIGNMENT);
				JFrame.add(Arrlst_Sections.get(count));
				for(int counter = 0;Arrlst_Questions.get(count).size()>counter;counter++){
					JFrame.add(Arrlst_Questions.get(count).get(counter));
				}
			}
			JFrame.pack();
			JFrame.setVisible(true);
			JFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		}
	}