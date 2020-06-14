class QuickUnion{
	int ar[];
	QuickUnion(int N) {
		ar = new int[N];
		for(int i = 0; i < N; i++) {
			ar[i] = i;
		}
	}
	public boolean connected(int x, int y) {
		return (root(x)==root(y));
	}
	int root(int x) {
		while(ar[x]!=x){
			x=ar[x];
		}
		return x;
	}
	public void union(int x, int y) {
		int rootx = root(x);
		int rooty = root(y);
		ar[rootx] = rooty;
	}
}
class WeightedQuickUnion{
	int ar[];
	int sz[];
	WeightedQuickUnion(int N){
		ar = new int[N];
		for(int i = 0; i < N; i++){
			ar[i] = i;
		}
		sz = new int[N];
	}
	int root(int x){
		while(ar[x] != x){
			ar[x] = ar[ar[x]];
			x = ar[x];
		}
		return x;
	}
	public boolean connected(int x, int y) {
		return (root(x) == root(y));
	}
	public void union(int x, int y) {
		int rootx = root(x);
		int rooty = root(y);
		if(rootx == rooty) return;
		if(sz[rootx] < sz[rooty]) {
			ar[rootx] = ar[rooty];
			sz[rootx] = sz[rootx] + sz[rooty];
		}
		else {
			ar[rooty] = ar[rootx];
			sz[rooty] = sz[rooty] + sz[rootx];
		}
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
		
		WeightedQuickUnion wu = new WeightedQuickUnion(10);
		wu.union(4,3);
		wu.union(3,8);
		wu.union(6, 5);
		wu.union(9, 4);
		wu.union(2, 1);
		System.out.println(wu.connected(0, 7));
		System.out.println(wu.connected(8, 9));
		wu.union(2, 1);
		wu.union(5, 0);
		wu.union(7, 2);
		wu.union(6, 1);
		System.out.println(wu.connected(0, 7));
		
	}

}
