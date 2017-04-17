/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * plane type class for data enum list
 * @author DELL
 */
public enum PlaneType {
   AIRCRAFT,  HELICOPTER;
   static Map<String, MSFSDataEnum> map;
   static public MSFSDataEnum getEnumFromString(String str) {
    if (map == null) buildMap();
    return map.get(str);
   }
   
   static void buildMap() {
       map = new HashMap<>();
        for(MSFSDataEnum m : MSFSDataEnum.values()) {
            map.put(m.getDes3(), m);
        }
   }
   static List<MSFSDataEnum> aircraftDataLt;
   static List<MSFSDataEnum> helicopterDataLt;
   static public List<MSFSDataEnum> getAircraftDataLt() {
       if (aircraftDataLt == null) buildAircraftDataLt();
       return aircraftDataLt;
   }
    static public List<MSFSDataEnum> getHelicopterDataLt() {
       if (aircraftDataLt == null) buildHelicopterDataLt();
       return helicopterDataLt;
   }
   static private void buildAircraftDataLt() {
        aircraftDataLt = new LinkedList<>();
        aircraftDataLt.add(MSFSDataEnum.TIME);
        aircraftDataLt.add(MSFSDataEnum.LATITUDE);
        aircraftDataLt.add(MSFSDataEnum.LONGITUDE);
        aircraftDataLt.add(MSFSDataEnum.ALTITUDE);
        aircraftDataLt.add(MSFSDataEnum.FLY_ALTITUDE);
        aircraftDataLt.add(MSFSDataEnum.GROUND_ALTITUDE);
        aircraftDataLt.add(MSFSDataEnum.HEADING);
        aircraftDataLt.add(MSFSDataEnum.MAGNETIC_HEADING);
        aircraftDataLt.add(MSFSDataEnum.PITCH);
        aircraftDataLt.add(MSFSDataEnum.BANK);
        aircraftDataLt.add(MSFSDataEnum.AOA);
        aircraftDataLt.add(MSFSDataEnum.BETA);
        aircraftDataLt.add(MSFSDataEnum.INDICATED_AIR_SPEED);
        aircraftDataLt.add(MSFSDataEnum.TRUE_AIR_SPEED);
        aircraftDataLt.add(MSFSDataEnum.MACH_SPEED);
        aircraftDataLt.add(MSFSDataEnum.VERTICAL_SPEED);
        aircraftDataLt.add(MSFSDataEnum.GFORCE);
        aircraftDataLt.add(MSFSDataEnum.GROUND_SPEED);
        aircraftDataLt.add(MSFSDataEnum.WIND_DIRECTION);
        aircraftDataLt.add(MSFSDataEnum.WIND_SPEED);
        aircraftDataLt.add(MSFSDataEnum.THROTTLE_LEVEL);
        aircraftDataLt.add(MSFSDataEnum.PROP_LEVEL);
        aircraftDataLt.add(MSFSDataEnum.MIXTURE_LEVEL);
        aircraftDataLt.add(MSFSDataEnum.ENGINE_RPM);
        aircraftDataLt.add(MSFSDataEnum.PROP_RPM);
        aircraftDataLt.add(MSFSDataEnum.TORQUE);
        aircraftDataLt.add(MSFSDataEnum.FLAPS_CONTROL);
        aircraftDataLt.add(MSFSDataEnum.FLAPS_DEFLECTION);
        aircraftDataLt.add(MSFSDataEnum.GEAR_CONTROL);
        aircraftDataLt.add(MSFSDataEnum.GEAR_POSITION);
        aircraftDataLt.add(MSFSDataEnum.ELEVATOR_CONTROL);
        aircraftDataLt.add(MSFSDataEnum.ELEVATOR_DEFLECTION);
        aircraftDataLt.add(MSFSDataEnum.AILERON_CONTROL);
        aircraftDataLt.add(MSFSDataEnum.AILERON_DEFLECTION);
        aircraftDataLt.add(MSFSDataEnum.RUDDER_CONTROL);
        aircraftDataLt.add(MSFSDataEnum.RUDDER_DEFLECTION);
        aircraftDataLt.add(MSFSDataEnum.ELEVATOR_TRIM_CONTROL);
        aircraftDataLt.add(MSFSDataEnum.AILERON_TRIM_CONTROL);
        aircraftDataLt.add(MSFSDataEnum.RUDDER_TRIM_CONTROL);
        aircraftDataLt.add(MSFSDataEnum.LOCALIZER_DEV);
        aircraftDataLt.add(MSFSDataEnum.GLIDESLOPE_DEV);
        aircraftDataLt.add(MSFSDataEnum.DME);
    }

    static private void buildHelicopterDataLt() {
        helicopterDataLt = new LinkedList<>();
        helicopterDataLt.add(MSFSDataEnum.TIME);
        helicopterDataLt.add(MSFSDataEnum.LATITUDE);
        helicopterDataLt.add(MSFSDataEnum.LONGITUDE);
        helicopterDataLt.add(MSFSDataEnum.ALTITUDE);
        helicopterDataLt.add(MSFSDataEnum.FLY_ALTITUDE);
        helicopterDataLt.add(MSFSDataEnum.GROUND_ALTITUDE);
        helicopterDataLt.add(MSFSDataEnum.HEADING);
        helicopterDataLt.add(MSFSDataEnum.MAGNETIC_HEADING);
        helicopterDataLt.add(MSFSDataEnum.PITCH);
        helicopterDataLt.add(MSFSDataEnum.BANK);
        helicopterDataLt.add(MSFSDataEnum.AOA);
        helicopterDataLt.add(MSFSDataEnum.BETA);
        helicopterDataLt.add(MSFSDataEnum.INDICATED_AIR_SPEED);
        helicopterDataLt.add(MSFSDataEnum.TRUE_AIR_SPEED);
        helicopterDataLt.add(MSFSDataEnum.MACH_SPEED);
        helicopterDataLt.add(MSFSDataEnum.VERTICAL_SPEED);
        helicopterDataLt.add(MSFSDataEnum.GFORCE);
        helicopterDataLt.add(MSFSDataEnum.GROUND_SPEED);
        helicopterDataLt.add(MSFSDataEnum.WIND_DIRECTION);
        helicopterDataLt.add(MSFSDataEnum.WIND_SPEED);
        helicopterDataLt.add(MSFSDataEnum.THROTTLE_LEVEL);
        helicopterDataLt.add(MSFSDataEnum.PROP_LEVEL);
        helicopterDataLt.add(MSFSDataEnum.ENGINE_RPM);
        helicopterDataLt.add(MSFSDataEnum.HELICOPTER_ENGINE_RPM);
        helicopterDataLt.add(MSFSDataEnum.TORQUE);
        helicopterDataLt.add(MSFSDataEnum.MANIFOLD);
        helicopterDataLt.add(MSFSDataEnum.GEAR_CONTROL);
        helicopterDataLt.add(MSFSDataEnum.GEAR_POSITION);
        helicopterDataLt.add(MSFSDataEnum.ELEVATOR_CONTROL);
        helicopterDataLt.add(MSFSDataEnum.AILERON_CONTROL);
        helicopterDataLt.add(MSFSDataEnum.RUDDER_CONTROL);
        helicopterDataLt.add(MSFSDataEnum.LOCALIZER_DEV);
        helicopterDataLt.add(MSFSDataEnum.GLIDESLOPE_DEV);
        helicopterDataLt.add(MSFSDataEnum.DME);
    }
}
