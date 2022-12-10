package modal;

public class WhoisChild extends Whois{

    String child;

    public WhoisChild(String child) {
        this.child = child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "WhoisChild{" +
                "child='" + child + '\'' +
                '}';
    }
}
