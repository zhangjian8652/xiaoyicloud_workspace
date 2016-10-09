package designpattern.pattern.observer;

/**
 * author:zhangjian
 * date:2016-05-26
 * describe:
 **/
public class TestObserver {
    public static void main(String[] args) {
        Patient patient = new Patient();
        Observer doctor = new Doctor();
        patient.addWatcher(doctor);
        patient.headache();
    }
}
