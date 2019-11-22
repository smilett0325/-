import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private Container cp;
    private JLabel jlb = new JLabel("Key");
    private JTextField tf =new JTextField(3);
    private JButton jbt1 = new JButton("Encrypt");
    private JButton jbt2 =new JButton("Decrypt");
    private JButton jbt3 =new JButton("Exit");
    private JTextArea ta =new JTextArea();
    private JScrollPane jsp =new JScrollPane(ta);
    private JPanel jp =new JPanel(new GridLayout(1,5,3,3));


    public MainFrame(){
        init();
    }

    private void init(){
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setBounds(300,150,1000,700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp.add(jsp,BorderLayout.CENTER);
        cp.add(jp,BorderLayout.NORTH);

        jp.add(jlb);
        jp.add(tf);
        jp.add(jbt1);
        jp.add(jbt2);
        jp.add(jbt3);

        jbt3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jbt1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[]= ta.getText().toCharArray();
                int key =Integer.parseInt(tf.getText());
                for (int i=0;i<data.length;i++){
                    data[i] =(char) (data[i] + key);
                }
                ta.setText(new String(data));
            }
        });

        jbt2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[]= ta.getText().toCharArray();
                int key =Integer.parseInt(tf.getText());
                for (int i=0;i<data.length;i++){
                    data[i] =(char) (data[i] - key);
                }
                ta.setText(new String(data));
            }
            
        });




    }
}
