/**
 * Created by Dewei Xiang on 8/6/2017.
 */
class CeilingFanPullChain {
    private State currentState;

    public CeilingFanPullChain() {
        currentState = new Off();
    }

    public void set_state(State s) {
        currentState = s;
    }

    public void pull(String button) {
        currentState.pull(this, button);
    }
}
class Off implements State {
    public void pull(CeilingFanPullChain wrapper, String button) {
        if(button == "green"){
            wrapper.set_state(new Low());
            System.out.println("low speed");
        }else{
            wrapper.set_state(new High());
            System.out.println("high speed");
        }
    }
}

class Low implements State {
    public void pull(CeilingFanPullChain wrapper, String button) {
        if(button == "green"){
            wrapper.set_state(new Medium());
            System.out.println("medium speed");
        }else{
            wrapper.set_state(new Off());
            System.out.println("turnning off");
        }
    }
}

class Medium implements State {
    public void pull(CeilingFanPullChain wrapper, String button) {


        if(button == "green"){
            wrapper.set_state(new High());
            System.out.println("high speed");

        } else{
            wrapper.set_state(new Low());
            System.out.println("low speed");
        }


    }
}

class High implements State {
    public void pull(CeilingFanPullChain wrapper, String button) {
        if(button == "green"){
            wrapper.set_state(new Off());
            System.out.println("turning off");

        }else{
            wrapper.set_state(new Medium());
            System.out.println("midium speed");
        }

    }
}
