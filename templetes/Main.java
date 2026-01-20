import java.io.*;
import java.util.*;


public class Main {
	public static int solution(int n) {

		// get maximum value where is smaller than or equal to n and divisible by 5
		int maxMultiply = n;
		while (maxMultiply % 5 != 0) {
			maxMultiply--;
		}

		for (int i = maxMultiply; i >= 0; i -= 5) {
			if ((n - i) % 3 == 0) return (i / 5 + (n - i) / 3);
		}

        return -1;
    }

	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(reader.readLine());

		int ans = solution(N);
		sb.append(ans).append("\n");
		System.out.println(sb);
		reader.close();
	}
}