class QuickUnion{
	int ar[];
	QuickUnion(int N) {
		ar = new int[N];
		for(int i = 0; i < N; i++) {
			ar[i] = i;
		}
	}
	public boolean connected(int x, int y) {
		return (ar[x]==ar[y]);
	}
	int root(int x) {
		int i=x;
		while(ar[i]!=i){
			i=ar[i];
		}
		return i;
	}
	public void union(int x, int y) {
		int rootx = root(x);
		int rooty = root(y);
		ar[rootx] = rooty;
	}
}
public class QuickUnionRunner {

	public static void main(String[] args) {
		QuickUnion u = new QuickUnion(10);
		u.union(4,3);
		u.union(3,8);
		u.union(6, 5);
		u.union(9, 4);
		u.union(2, 1);
		System.out.println(u.connected(0, 7));
		System.out.println(u.connected(8, 9));
		u.union(2, 1);
		u.union(5, 0);
		u.union(7, 2);
		u.union(6, 1);
		System.out.println(u.connected(0, 7));
	}

}
