package tw.com.hasco.MSFS.model;

public enum MSFSDataEnum {
    LATITUDE("緯度","Lat", "LATITUDE","Lat"), 
    LONGITUDE("經度","Lon", "LONGITUDE","Lon"), 
    ALTITUDE("飛行高度","Alt (m)","ALTITUDE","Alt (m)"), 
    GROUND_ALTITUDE("地表標高","Tern (m)","GROUND_ALTITUDE","Tern (m)"), 
    FLY_ALTITUDE("離地高度","G Alt (m)","FLY_ALTITUDE","G Alt (m)"), 
    HEADING("方位角H","True H(deg)","HEADING","True H(deg)"), 
    PITCH("俯仰角P", "Pitch(deg)", "PITCH","Pitch(deg)"), 
    BANK("滾轉角R", "Roll(deg)", "BANK","Roll(deg)"), 
    MAGNETIC_HEADING("磁方角M", "Mag H(deg)","MAGNETIC_HEADING","Mag H(deg)"),
    AOA("攻角", "AoA(deg)", "AOA","AoA(deg)"), 
    BETA("側滑角B", "SideSlip(deg)","BETA","SideSlip(deg)"), 
    INDICATED_AIR_SPEED("儀表空速", "IAS(kt)","INDICATED_AIR_SPEED","IAS(kt)"), 
    TRUE_AIR_SPEED("真實空速", "TAS(kt)","TRUE_AIR_SPEED","TAS(kt)"),
    MACH_SPEED("馬赫", "Mach","MACH_SPEED","Mach"), 
    VERTICAL_SPEED("垂直速率","VS(ft/s)","VERTICAL_SPEED","VS(ft/s)"), 
    GFORCE("重力", "G","GFORCE","G"), 
    GROUND_SPEED("對地速度", "GS(kt)","GROUND_SPEED","GS(kt)"),
    WIND_DIRECTION("風向", "Wind(deg)","WIND_DIRECTION","Wind(deg)"), 
    WIND_SPEED("風速", "WS(kt)","WIND_SPEED","WS(kt)"), 
    THROTTLE_LEVEL("節流閥操控", "T %","THROTTLE_LEVEL","T %"), 
    PROP_LEVEL("螺旋槳操控", "P %","PROP_LEVEL","P %"),
    MIXTURE_LEVEL("混合比操控", "M %","MIXTURE_LEVEL","M %"), 
    ENGINE_RPM("引擎轉數","N1 %", "ENGINE_RPM","N1 %"), 
    PROP_RPM("旋槳轉數", "RPM", "PROP_RPM","RPM"),
    TORQUE("扭力輸出", "Torque %", "TORQUE","Torque NM"),
    ELEVATOR_CONTROL("升降舵操控E", "Elev %", "ELEVATOR_CONTROL","Elev %"), 
    ELEVATOR_DEFLECTION("升降舵角度E", "Elev deg", "ELEVATOR_DEFLECTION","Elev deg"), 
    AILERON_CONTROL("副翼操控A","Aileron %", "AILERON_CONTROL","Aileron %"),
    AILERON_DEFLECTION("副翼角度A", "Aileron deg", "AILERON_DEFLECTION","Aileron deg"), 
    RUDDER_CONTROL("方向舵操控R","Rudder %", "RUDDER_CONTROL","Rudder %"),
    RUDDER_DEFLECTION("方向舵角度R", "Rudder deg", "RUDDER_DEFLECTION","Rudder deg"), 
    FLAPS_CONTROL("襟翼操控F", "Flap %", "FLAPS_CONTROL","Flap %"), 
    FLAPS_DEFLECTION("襟翼角度F", "Flap deg", "FLAPS_DEFLECTION","Flap deg"),
    GEAR_CONTROL("起落架<操控G", "LG", "GEAR_CONTROL","LG"), 
    GEAR_POSITION("起落架位置G", "LG", "GEAR_POSITION","LG"), 
    ELEVATOR_TRIM_CONTROL("升降舵配平E", "Elev Trim deg", "ELEVATOR_TRIM_CONTROL","Elev Trim %"),
    RUDDER_TRIM_CONTROL("方向舵配平R", "Rudder Trim deg", "RUDDER_TRIM_CONTROL", "Rudder Trim %"), 
    AILERON_TRIM_CONTROL("副翼配平A", "Aileron Trim deg", "AILERON_TRIM_CONTROL", "Aileron Trim %"),
    NAVIGATE_FREQUENCY("導航 NAV 頻率", "navigator frequency", "NAVIGATE_FREQUENCY","navigator frequency"), 
    NAVIGATE_ID("導航代號", "navigator ID", "NAVIGATE_ID","navigator ID"), 
    NAVIGATE_NAME("導航名稱", "navigator name", "NAVIGATE_NAME","navigator name"),
    LOCALIZER_DEV("Localizer", "Needle (deg)", "LOCALIZER_DEV","Needle (deg)"), 
    GLIDESLOPE_DEV("Glideslope", "Needle (deg)", "GLIDESLOPE_DEV","Needle (deg)"), 
    DME("DME", "DME (nm)", "DME","DME (nm)"), 
    TIME("時間", "Time", "TIME","Time"),
    HELICOPTER_ENGINE_RPM("引擎轉數", "N1 %", "HELICOPTER_ENGINE_RPM","N1 %"), 
    MANIFOLD("進氣壓力", "Manifold Hg", "MANIFOLD","Manifold Hg"),
    HOUR("時", "hour", "HOUR", "hour"),
    MIN("分", "minute", "MIN", "minute"),
    SEC("秒","second","SEC", "second");
    private final String des1; /** chinese name */
    private final String des2; /** name*/
    private final String des3; /** name */
    private final String des4; /** name */
    private MSFSDataEnum(String des1, String des2, String des3, String des4) {
        this.des1 = des1;
        this.des2 = des2;
        this.des3 = des3;
        this.des4 = des4;
    }
    public String getDes1() {
        return des1;
    }
    public String getDes2() {
        return des2;
    }
    public String getDes3() {
        return des3;
    }
    public String getDes4() {
        return des4;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        for(MSFSDataEnum m : MSFSDataEnum.values()) {
            System.out.println(m.getDes1());
        }
        
    }
}
