package geeksforgeeks.recurssion;

// didn't got
public class TowerOfHanoi {
    public void towerOfHanoi(char s, char d, char e, int n) {
        if (n <= 0)
            return;

        towerOfHanoi(s, e, d, n-1);
        System.out.println("Move disk " + n + " from "+ s + " to " + d);
        towerOfHanoi(e, d, s, n-1);
    }

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.towerOfHanoi('S', 'D', 'E', 4);
    }
}
