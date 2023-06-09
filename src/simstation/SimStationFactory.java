package simstation;

import mvc.Command;
import mvc.Model;
import mvc.View;
import java.io.Serializable;

/* Class "SimStationFactory" Datalog
4/7/2023 - Allen Tran: Created file
4/9/2023 - Minh Bui: Implemented all methods
*/

public class SimStationFactory implements SimFactory, Serializable {

    @Override
    public Model makeModel() {
        return new Simulation();
    }

    @Override
    public View makeView(Model m) {
        System.out.println("factory view");
        return new SimStationView((Simulation) m);
    }

    @Override
    public String[] getEditCommands() {
        return new String[] { "Start", "Suspend", "Resume", "Stop", "Stats" };
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object object) {
        if (type == "Start")
            return new StartCommand(model);
        else if (type == "Stop")
            return new StopCommand(model);
        else if (type == "Suspend")
            return new SuspendCommand(model);
        else if (type == "Resume")
            return new ResumeCommand(model);
        else if (type == "Stats")
            return new StatsCommand(model);
        return null;
    }

    @Override
    public String getTitle() {
        return "simulation";
    }

    @Override
    public String[] getHelp() {
        // put something later
        String[] cmmds = new String[5];
        cmmds[0] = "Start: Start/Restart the simulation";
        cmmds[1] = "Suspend: Pause the simulation";
        cmmds[2] = "Resume: Resume the simulation";
        cmmds[3] = "Stop: Stop the simulation";
        cmmds[4] = "Stats: Check # of agents, clock, and other information";
        return cmmds;
    }

    @Override
    public String about() {
        return "SimStation version 2.0" +
                "\nCopyright 2023 by Allen Tran, Minh Bui, and Niko Jokhadze";
    }
}