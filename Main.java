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
			ArrayList<JFrame> JFrame = new ArrayList<JFrame>();
			ArrayList<ArrayList<Question_Panel>> Arrlst_Questions = new ArrayList<ArrayList<Question_Panel>>();
			ArrayList<JLabel> Arrlst_Sections = new ArrayList<JLabel>();
			Scanner scan = new Scanner(new File("./Questions.txt"));
			for(int counter = -1;scan.hasNext();counter+=0){
				if(scan.hasNext(".*:?")){
					counter++;
					scan.useDelimiter(":");
					Arrlst_Sections.add(new JLabel(scan.nextLine()));
					Arrlst_Questions.add(new ArrayList<Question_Panel>());
					JFrame.add(new JFrame());
					//JFrame.get(counter).setDefaultLookAndFeelDecorated(true);
					//JFrame.get(counter).setLayout(new GridLayout(0,1));
				}
				scan.useDelimiter(".*/?");
				Arrlst_Questions.get(counter).add(new Question_Panel(scan.nextLine()));
			}
			for(int count = 0;Arrlst_Sections.size()>count;count++){
				Arrlst_Sections.get(count).setHorizontalAlignment((int)Arrlst_Sections.get(count).CENTER_ALIGNMENT);
				JFrame.get(count).add(Arrlst_Sections.get(count));
				for(int counter = 0;Arrlst_Questions.get(count).size()>counter;counter++){
					JFrame.get(counter).add(Arrlst_Questions.get(count).get(counter));
				}
				JFrame.get(count).pack();
			}
			for(int count = 0;Arrlst_Sections.size()>count;count++){
				for(int counter = 0;Arrlst_Questions.get(count).size()>counter;counter++){
					Arrlst_Questions.get(count).get(counter).addGap();
				}
			}
			for(int count = 0;count<JFrame.size();count++){
				JFrame.get(count).setVisible(true);
				JFrame.get(count).setDefaultCloseOperation(JFrame.get(count).DISPOSE_ON_CLOSE);
			}
		}
	}
