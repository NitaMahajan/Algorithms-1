/*
 * Union Find Algorithm
 * 
 * */
class Union {
	int ar[];
	Union(int N) {
		ar = new int[N];
		for(int i=0 ; i<N; i++){
			ar[i] = i;
		}
	}
	public boolean connected(int x, int y) {
		return (ar[x] == ar[y]);
	}
	public void union(int x, int y) {
		int vax = ar[x];
		for(int i=0; i< ar.length; i++) {
			if(ar[i] == vax) {
				ar[i] = ar[y];
			}
		}
	}
}
public class UnionFind {

	public static void main(String[] args) {
		Union u = new Union(10);
		u.union(4,3);
		u.union(3,8);
		u.union(6,5);
		u.union(9,4);
		u.union(2,1);
		System.out.println(u.connected(0, 7));
		System.out.println(u.connected(8, 9));
	}

}
