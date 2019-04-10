import java.util.*;

public class Brain {
    ArrayList<String> qs;
    HashMap<String, String> minidb;
    Scanner sc;
    Random r;

    public Brain() {
        r = new Random();
        sc = new Scanner(System.in);
        minidb = new HashMap<String, String>();
        qs = new ArrayList<String>();

        System.out.println("^_^");

    }

    private void beginProcess() {
      //  System.out.println("brain process");
        String ques = getQuestion();
        if (minidb.containsKey(ques)) {
            showAnswer(minidb.get(ques));
        } else {
            qs.add(ques);
            //System.out.println("adding " + ques + " to data base");
        }

    }

    private void brainlearn() {
       // System.out.println("brain learn");
        if(qs.isEmpty())return;
       // System.out.println("not empty");
        Iterator<String> it = qs.iterator();
        String ques = it.next();
        String answer;
        while (it.hasNext() && getBoolRand()) {
            ques = it.next();
        }
        answer = askQuestion(ques);
      //  System.out.println("adding " + ques + " to database with answer " + answer);
        minidb.put(ques, answer);
        qs.remove(ques);

    }

    private String getQuestion() {
        System.out.println("You: ");
        String ques = sc.nextLine();
        return ques;
    }

    private void showAnswer(String ans) {
        System.out.println("bot: \n" + ans);
    }

    private String askQuestion(String ques) {
        System.out.println("bot: \n" + ques);
        System.out.println("You: ");
        String answer = sc.nextLine();
        return answer;
    }

    private int getWholeRandom(int min, int max) {
        double x = Math.random() * (max - min) + min;
        return (int) x;
    }

    private boolean getBoolRand() {
        return r.nextBoolean();
    }

    public static void main(String[] args) {
            Brain as = new Brain();
            int tc = 50;
            while (tc-->0){
                if(as.getBoolRand()){
                    as.beginProcess();
                }
                else {
                    as.brainlearn();
                }
            }
    }
}
