public class IpV4 {

public static String numberToIp(long number){
    String binary = Long.toBinaryString(number);//to Binary from long (one x32b number)
    String[] twoVisionOfNumber = new String[4]; //create array to four binary(x8) number
    int k = 0;//to index of array twoVisionOfNumber
    String ip = "";//to result

    for (int i=0; i < 4; i++, k+=8)
    {
        twoVisionOfNumber[i] = binary.substring(k, k+8);//add one binary number
        int numberFromTwoSystem = Integer.parseInt(twoVisionOfNumber[i], 2);//prepare to ten system from two system

        if(i != 3) ip = ip + numberFromTwoSystem + ".";
        else ip+=numberFromTwoSystem;
    }
    return ip;
}
    public static Long ipToNumber(String number)
    {
        String[] ipToArray = number.split("\\.");//create array with numbers from ip
        long answer = 0;
        for(int i = 0, power = 3; i < ipToArray.length; i++)
        {
            int ip = Integer.parseInt(ipToArray[i]);
            answer += ip * Math.pow(256, power);
            power--;
        }
        return answer;
    }

    public static void main(String[] args) {
        long i;
        System.out.println(ipToNumber("192.168.1.2"));
        System.out.println(numberToIp(2149583360l));
    }
}
