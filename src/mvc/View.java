package mvc;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JPanel implements PropertyChangeListener {

    public Model model;
    public View(Model m){
        super();
        this.model = m;
        model.addPropertyChangeListener(this);
    }
    public void setModel(Model model){
        this.model.removePropertyChangeListener(this);
        this.model = model;
        this.model.initSupport();
        this.model.addPropertyChangeListener(this);
        System.out.println("changed");
        repaint();
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
