package modal;

import java.util.Objects;

public class Whois {

    private int anInt;
    private String ip;
    private String inetnum;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getInetnum() {
        return inetnum;
    }

    public void setInetnum(String inetnum) {
        this.inetnum = inetnum;
    }

    public int getAnInt() {
        return anInt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Whois whois)) return false;
        return getAnInt() == whois.getAnInt() && Objects.equals(getIp(), whois.getIp()) && Objects.equals(getInetnum(), whois.getInetnum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnInt(), getIp(), getInetnum());
    }

    @Override
    public String toString() {
        return "Whois{" +
                "anInt=" + anInt +
                ", ip=" + ip +
                ", inetnum=" + inetnum +
                '}';
    }
}
