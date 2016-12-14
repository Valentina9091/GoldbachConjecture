import java.util.ArrayList;
import java.util.List;

/**
 * Program to demonstrate Goldbach's conjecture: Every even integer greater than two can be
 * expressed as the sum of two primes
 * example 10 = 5 + 5 = 3 +7
 * 
 * Usage: java GoldbachConjecture [inputNumber]
 * 
 * @author Valentina Palghadmal
 *
 */
public class GoldbachConjecture {

	public static void main(String[] args) {
		int value=0;
		if (args.length > 0)
			value = Integer.parseInt(args[0]);
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		for (int i = 3; i < value; i += 2) {
			if (isPrime(i))
				primes.add(i);
		}

		StringBuilder sb = new StringBuilder();
		while (primes.size() > 0) {
			int p1 = primes.remove(0);
			int p2 = value - p1;
			if (p1 == p2)
				sb.append(p1 + "+" + p2);
			if (primes.contains(p2)) {
				primes.remove(primes.indexOf(p2));
				sb.append(p1 + "+" + p2 + "\n");
			}
		}
		System.out.println(sb);

	}

	private static boolean isPrime(int n) {
		if (n % 2 == 0)
			return false;
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
