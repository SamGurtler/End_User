package EndUser;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Scanner;
import java.io.File;
import javax.swing.JLabel;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
	public class Main{
		public static void main(String[] args)throws java.io.FileNotFoundException{
			ArrayList<JFrame> JFrame = new ArrayList<JFrame>();
			ArrayList<ArrayList<Question_Panel>> Arrlst_Questions = new ArrayList<ArrayList<Question_Panel>>();
			ArrayList<JLabel> Arrlst_Sections = new ArrayList<JLabel>();
			Scanner scan = new Scanner(new File("./Questions.txt"));
			Pattern p = Pattern.compile("[^:]+:");
			String line = "";
			for(int counter = -1;scan.hasNext();counter+=0){
				line = scan.nextLine();
				Matcher m = p.matcher(line);
				if(m.matches()){
					counter++;
					System.out.println("Making new JLabel titled:"+line);
					Arrlst_Sections.add(new JLabel(line));
					Arrlst_Questions.add(new ArrayList<Question_Panel>());
					System.out.println("Label ->"+line);
				}
				else Arrlst_Questions.get(counter).add(new Question_Panel(line)); 
			}
			for(int count = 0;Arrlst_Sections.size()>count;count++){
				Arrlst_Sections.get(count).setHorizontalAlignment((int)Arrlst_Sections.get(count).CENTER_ALIGNMENT);
				JFrame.add(new JFrame());
				System.out.println("What JLabel may actually say:"+Arrlst_Sections.get(count).getText());
				JFrame.get(count).add(Arrlst_Sections.get(count));
				for(int count1 = 0;Arrlst_Questions.get(count).size()>count1;count1++){
					JFrame.get(count).add(Arrlst_Questions.get(count).get(count1));
					System.out.println("Jframe.get("+count+").add(Arrlst_Questions.get("+count+").get("+count1+"));");
				}
				JFrame.get(count).setDefaultLookAndFeelDecorated(true);
				JFrame.get(count).setDefaultCloseOperation(JFrame.get(count).DISPOSE_ON_CLOSE);
				JFrame.get(count).setLayout(new GridLayout(0,1));
				JFrame.get(count).pack();
				JFrame.get(count).setVisible(true);
			}
		}
	}
