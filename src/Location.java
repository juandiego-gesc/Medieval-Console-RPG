import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Location implements ActionListener {
    String[] options;
    String mainString;
    Game rpg;

    public Location(String[] options, Game rpg) {
        this.options = options;
        this.rpg = rpg;
    }
    public void actionPerformed(ActionEvent event){
        String choice = event.getActionCommand();
        switch (choice){
            case "c1":command1();break;
            case "c2":command2();break;
            case "c3":command3();break;
        }
    }

    abstract void command1();
    abstract void command2();
    abstract void command3();
}
