import modal.Whois;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaCode {

    public static final String PATTERN_COMPRESSED_ARIN_NET_RANGE = "\\(\\S+\\) \\S+ - \\S+";

    public void test(boolean bool) {
        if (bool) {
            System.out.println("bool");
        } else {
            System.out.println("none");
        }
    }

    public  void main(String[] args) {

        this.test(true);
    }
}


