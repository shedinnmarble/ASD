public class Main {

    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();
        fan.pullgreen();
        fan.pullgreen();
        fan.pullgreen();
        fan.pullgreen();
        fan.pullred();
        fan.pullred();
        System.out.println("-----------------");
        CeilingFanPullChain ceilingFanPullChain = new CeilingFanPullChain();
        ceilingFanPullChain.pull("green");
        ceilingFanPullChain.pull("green");
        ceilingFanPullChain.pull("green");
        ceilingFanPullChain.pull("green");
        ceilingFanPullChain.pull("red");
        ceilingFanPullChain.pull("red");
    }
}
