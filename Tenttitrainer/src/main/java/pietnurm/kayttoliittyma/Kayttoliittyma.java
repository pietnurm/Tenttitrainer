/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.kayttoliittyma;

/**
 *
 * @author pieta
 */
public class Kayttoliittyma {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Haikugeneraattori");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(2, 1);
        container.setLayout(layout);
        
        JLabel yla = new JLabel("", SwingConstants.CENTER);
        JButton nappi = new JButton("Generoi uusi haiku");
//        JLabel ala = new JLabel("");
        
        TapahtumanKuuntelija kuuntelija = new TapahtumanKuuntelija(yla);
        nappi.addActionListener(kuuntelija);
        
        container.add(yla);
        container.add(nappi);
//        container.add(ala);
    }
}
