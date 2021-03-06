package tw.com.hasco.MSFS.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import tw.com.hasco.MSFS.FS.FSBasic;
import tw.com.hasco.MSFS.FS.FSFile;
import tw.com.hasco.MSFS.FS.FSFileException;
import tw.com.hasco.MSFS.FS.FSFs;
import tw.com.hasco.MSFS.FS.FSXplane;
import tw.com.hasco.MSFS.Observer;

/**
 * class for get data
 *
 * @author DELL
 */
public class DataGetter implements Runnable {

    private FSBasic fsBasic;

    private LinkedList<Observer> observers;
    private boolean stopRun = false;
    List<MSFSDataEnum> planeDataLt;
    PlaneType planeType;
    Recorder recorder;
    int updatePeriod;

    /**
     * contructor for FS, xplane datagetter
     *
     * @param planeType aircraft or helicopter
     * @param str fs, xplane or file name
     * @throws IOException catch xplane exception
     */
    private void setDataLt(PlaneType planeType) {
        this.planeType = planeType;
      switch (planeType) {
            case AIRCRAFT:
                planeDataLt = PlaneType.getAircraftDataLt();
                break;
            case HELICOPTER:
                planeDataLt = PlaneType.getHelicopterDataLt();
                break;
        }  
        
    }
    private void setFsBasic(String str) throws IOException {
       if ("fs".equals(str)) {
            fsBasic = new FSFs(planeType);
        } else if ("xplane".equals(str)) {
            fsBasic = new FSXplane(planeType);
        } else {
           fsBasic = new FSFile(str, planeType); 
        }
    }
    public DataGetter(PlaneType planeType, String str) throws IOException {
        updatePeriod = 100;
        setDataLt(planeType);
        setFsBasic(str);
        observers = new LinkedList<>();
    }

    
    /**
     * notify observers
     */
    private void notifyObservers() {
        observers.forEach((o) -> {
            o.update(fsBasic);
        });
    }

    /**
     * update data from FS and notify observers
     *
     * @throws IOException file exception
     * @throws FSFileException fs exception
     */
    private void readAllData() throws IOException, FSFileException {
        fsBasic.update();
        notifyObservers();
        /* should remove when using fsuipc */
        try {
            sleep(updatePeriod);
        } catch (InterruptedException ex) {
            Logger.getLogger(DataGetter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stopRun() {
        stopRecord();
        stopRun = true;
        fsBasic.setStop(true);
    }

    @Override
    public void run() {
        try {
            while (!stopRun) {
                readAllData();
            }
        } catch (IOException | FSFileException ex) {
            Logger.getLogger(DataGetter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * record data
     *
     * @param fN file name of record
     * @param t time interval
     */
    public void startRecord(String fN, Double t) {
        try {
            recorder = new Recorder(fN, t, this.fsBasic);
        } catch (IOException ex) {
            Logger.getLogger(DataGetter.class.getName()).log(Level.SEVERE, null, ex);
            recorder = null;
            return;
        }
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.submit(recorder);
    }

    /**
     * stop record
     */
    public void stopRecord() {
        if (recorder != null) {
            recorder.stop();
        }
        recorder = null;
    }
}
