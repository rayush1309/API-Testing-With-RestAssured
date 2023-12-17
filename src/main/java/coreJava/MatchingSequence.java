public class MatchingSequence {

    public static void main(String[] args) {
        int [] arr = {1000700,170087, 82927002, 700282,8887099};
        String s2 = "700";
        for (int i = 0; i < arr.length; i++) {
            String s = String.valueOf(arr[i]);
            if (s.contains(s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
