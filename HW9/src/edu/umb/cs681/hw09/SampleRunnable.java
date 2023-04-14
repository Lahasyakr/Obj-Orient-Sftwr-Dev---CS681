package edu.umb.cs681.hw09;

public class SampleRunnable implements Runnable {

    @Override
    public void run() {
        Aircraft aircraft = new Aircraft(new Position(43.5143, 75.359, 35.369));
        System.out.println("Aircraft's original position: \t" + aircraft.getPosition());
        aircraft.setPosition(45.6598, 55.987, 40.00);
        System.out.println("First time Aircraft's original position changed to: \t" + aircraft.getPosition());
        aircraft.setPosition(50.2549, 60.259, 51.257);
        System.out.println("Second time Aircraft's new position is set to: \t" + aircraft.getPosition());
    }

}
