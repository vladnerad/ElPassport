public class Traktor {

    private int serialN;
    private int dieselN;
    private int HydPumpNum;
    private int HydMotNum;

    public Traktor(int serialN, int dieselN, int hydPumpNum, int hydMotNum) {
        this.serialN = serialN;
        this.dieselN = dieselN;
        HydPumpNum = hydPumpNum;
        HydMotNum = hydMotNum;
    }

    public int getSerialN() {
        return serialN;
    }

    public int getDieselN() {
        return dieselN;
    }

    public int getHydPumpNum() {
        return HydPumpNum;
    }

    public int getHydMotNum() {
        return HydMotNum;
    }

    public void setSerialN(int serialN) {
        this.serialN = serialN;
    }

    public void setDieselN(int dieselN) {
        this.dieselN = dieselN;
    }

    public void setHydPumpNum(int hydPumpNum) {
        HydPumpNum = hydPumpNum;
    }

    public void setHydMotNum(int hydMotNum) {
        HydMotNum = hydMotNum;
    }
}
