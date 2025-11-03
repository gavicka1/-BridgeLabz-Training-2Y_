interface LightAction {
    void activate();
}

public class Main1 {
    public static void main(String[] args) {
        LightAction motionTrigger = () -> System.out.println("Light ON due to motion");
        LightAction timeTrigger = () -> System.out.println("Light ON at sunset");
        LightAction voiceTrigger = () -> System.out.println("Light ON by voice command");
        motionTrigger.activate();
        timeTrigger.activate();
        voiceTrigger.activate();
    }
}
