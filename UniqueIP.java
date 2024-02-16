import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;

public class UniqueIP {
    private static final BitSet bitSet = new BitSet();

    public static void main(String[] args) throws IOException {
        int uniqueCount = countUniqueIPs("D:\\ip_addresses/ip_addresses");
        System.out.println("Уникальных IP-адресов: " + uniqueCount);
    }

    public static int countUniqueIPs(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                bitSet.set(ipToInt(line));
            }
        }
        return bitSet.cardinality();
    }

    private static int ipToInt(String ipAddress) {
        int ipInt = 0;
        for (String part : ipAddress.split("\\.")) {
            ipInt = ipInt << 8;
            ipInt |= Integer.parseInt(part) & 0xFF;
        }
        return ipInt & 0x7FFFFFFF;
    }
}
