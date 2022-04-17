import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for(int tc = 0; tc < T; tc++) {
			String thisMonth = fs.next(), nextMonth = fs.next();
			String[] dayNames = new String[] {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
			int[] dayNum = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			boolean checker = false;
			for(int i = 0; i < dayNum.length; i++) {
				int rem = dayNum[i] % 7;
				//System.out.println((getNum(dayNames, thisMonth)+rem)%7);
				String possibleNext = dayNames[(getNum(dayNames, thisMonth)+rem)%7];
				//System.out.println(dayNum[i] + " = " + thisMonth + " " + possibleNext);
				if(possibleNext.equals(nextMonth)) {
					checker = true;
					break;
				}
			}
			out.println(checker ? "YES" : "NO");
		}
		out.close();
	}
	
	static int getNum(String[] dayNames, String thisMonth) {
		for(int i = 0; i < dayNames.length; i++) {
			if(dayNames[i].equals(thisMonth)) {
				return i;
			}
		}
		return -1;
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for(int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
		
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
