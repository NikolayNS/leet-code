package com.dmitrenko.leetcode.diagonal;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DiagonalService {

	public int diagonalDifference(List<List<Integer>> arr) {
		var left = 0;
		var right = 0;

		for (var i = 0; i < arr.size(); i++) {
			left = left + arr.get(i).get(i);
			right = right + arr.get(i).get(arr.size() - i -1);
		}

		var result = left - right;
		return result < 0 ? result * -1 : result;
	}

	public void plusMinus(List<Integer> arr) {
		int positive = 0;
		int negative = 0;
		int zero = 0;

		for (Integer a : arr) {
			if (a > 0) positive = positive + 1;
			if (a < 0) negative = negative + 1;
			if (a == 0) zero = zero + 1;
		}

		System.out.println(positive / arr.size());
		System.out.println(negative / arr.size());
		System.out.println(zero / arr.size());
	}

	public void staircase(int n) {
		for (int i = 1; i <= n; i++) {
			StringBuilder r = new StringBuilder();
			for (int j = 0; j < n - i; j++) {
				r.append(" ");
			}

			for (int j = 0; j < i; j++) {
				r.append("#");
			}

			System.out.println(r);
		}
	}

	public void miniMaxSum(List<Integer> arr) {
		List<Integer> sorted = arr
			.stream()
			.sorted()
			.collect(Collectors.toList());

		long result = sorted.stream().mapToLong(o -> o).sum();

		System.out.println(result - sorted.get(sorted.size() - 1) + " " + (result - sorted.get(0)));
	}

	public int birthdayCakeCandles(List<Integer> candles) {
		int max = candles
			.stream()
			.mapToInt(o -> o)
			.max()
			.getAsInt();

		return (int) candles
			.stream()
			.filter(o -> o == max)
			.count();
	}

	public String timeConversion(String s) {
		String result = s.charAt(8) == 'A'
			? s.substring(0, 8)
			: Integer.parseInt(s.substring(0, 2)) + 12 + s.substring(2, 8);

		result = s.startsWith("12") && s.charAt(8) == 'A'
			? 24 + s.substring(2, 8)
			: s.startsWith("12")
			? 12 + s.substring(2, 8)
			: result;

		return result.startsWith("24")
			? "00" + result.substring(2, 8)
			: result;
	}

	public int chocolateInBox(List<Integer> arr) {
		long r = arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			r = r ^ arr.get(i);
		}

		int s = 0;

		for (Integer i : arr) {
			if ((r ^ i) < i) s = s + 1;
		}

		return s;
	}

	public List<Integer> gradingStudents(List<Integer> grades) {
		return grades
			.stream()
			.map(o -> {
				if (o < 38) return o;
				int s = o % 5;
				if (s >= 3) {
					o = o + (5 - s);
				}
				return o;
			})
			.collect(Collectors.toList());
	}

	public void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
		System.out.println(apples.stream().filter(o -> s <= o + a && o + a <= t).count());
		System.out.println(oranges.stream().filter(o -> s <= o + b && o + b <= t).count());
	}

	public String kangaroo(int x1, int v1, int x2, int v2) {
		String response = "NO";
		boolean canCatchUp = (v2 < v1);
		if(canCatchUp) {
			boolean willIntersectOnLand = (x1 - x2) % (v2 - v1) == 0;
			if(willIntersectOnLand) {
				response = "YES";
			}
		}
		return response;
	}

	public List<Integer> breakingRecords(List<Integer> scores) {
		var max = scores.get(0);
		var maxCount = 0;
		var min = scores.get(0);
		var minCount = 0;
		for (var i = 1; i < scores.size(); i++) {
			if (max < scores.get(i)) {
				max = scores.get(i);
				maxCount++;
			}
			if (min > scores.get(i)) {
				min = scores.get(i);
				minCount++;
			}
		}

		return List.of(maxCount, minCount);
	}

	public int birthday(List<Integer> s, int d, int m) {
		var result = 0;
		for (int i = 0; i < s.size(); i++) {
			var sum = 0;
			for (int j = 0; j < m; j++) {
				if (s.size() <= (i + j)) break;
				sum = sum + s.get(i + j);
			}
			if (d == sum) result++;
		}
		return result;
	}

	public List<Integer> reverseArray(List<Integer> a) {
		Collections.reverse(a);
		return a;
	}

	public int countingValleys(int steps, String path) {
		var count = 0;
		var s = 0;

		char[] chars = path.toCharArray();
		for (int i = 0; i < steps; i++) {
			s = chars[i] == 'U' ? s + 1 : s - 1;
			if(s == 0 && chars[i] == 'U')
				count++;
		}

		return count;
	}

	public int sockMerchant(int n, List<Integer> ar) {
		var map = new HashMap<Integer, Integer>();
		ar.forEach(o -> map.merge(o, 1, Integer::sum));

		return map.values()
			.stream()
			.map(o -> o / 2)
			.reduce(0, Integer::sum);
	}

	public int pickingNumbers(List<Integer> a) {
		var map = new HashMap<Integer, Integer>();
		a.forEach(o -> map.merge(o, 1, Integer::sum));

		var m = 0;
		for (Integer o : map.keySet()) {
			var s = map.get(o);
			var b = map.get(o - 1) == null ? 0 : map.get(o - 1);
			if (s + b > m)
				m = s + b;
		}

		return m;
	}

	public int hurdleRace(int k, List<Integer> height) {
		var sorted = height
			.stream()
			.sorted()
			.collect(Collectors.toList());

		return sorted.get(height.size() - 1) <= k ? 0 : sorted.get(height.size() - 1) - k;
	}

	public int designerPdfViewer(List<Integer> h, String word) {
		var chars = word.chars()
			.boxed()
			.collect(Collectors.toList());

		var max = 0;
		for (Integer s : chars) {
			var r = h.get(s - 97);
			if (r > max)
				max = r;
		}

		return max * chars.size();
	}

	public int utopianTree(int n) {
		var size = 1;
		for (int i = 1; i <= n; i++) {
			size = i % 2 == 0 ? size + 1 : size * 2;
		}
		return size;
	}

	public String angryProfessor(int k, List<Integer> a) {
		var count = a
			.stream()
			.filter(o -> o <= 0)
			.count();
		return k <= count ? "NO" : "YES";
	}

	public int beautifulDays(int i, int j, int k) {
		var count = 0;

		for (int l = i; l <= j; l++) {
			double r = ((double) l - reverse(l)) / k;
			if (r % 1 == 0) count++;
		}

		return count;
	}

	private int reverse(int n) {
		var reverse = 0;
		while (n > 0) {
			reverse = reverse * 10;
			reverse = reverse + n % 10;
			n = n / 10;
		}
		return reverse;
	}

	public String morganAndString(String a, String b) {
		var builder = new StringBuilder();

		int i = 0;
		int j = 0;
		var aChars = a.toCharArray();
		var bChars = b.toCharArray();

		while (true) {
			if (i == aChars.length) {
				for (int k = j; k < bChars.length; k++) {
					builder.append(bChars[k]);
				}
				break;
			}
			if (j == bChars.length) {
				for (int k = i; k < aChars.length; k++) {
					builder.append(aChars[k]);
				}
				break;
			}

			if (aChars[i] == bChars[j]) {
				if (compare(aChars, bChars, i, j)) {
					builder.append(aChars[i]);
					i++;
				} else {
					builder.append(bChars[j]);
					j++;
				}
			} else if (aChars[i] < bChars[j]) {
				builder.append(aChars[i]);
				i++;
			} else if (aChars[i] > bChars[j]) {
				builder.append(bChars[j]);
				j++;
			}
		}

		return builder.toString();
	}

	private boolean compare(char[] a, char[] b, int i, int j) {
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) return true;
			else if (a[i] > b[j]) return false;
			i++;
			j++;
		}

		return i != a.length;
	}

	public List<Integer> permutationEquation(List<Integer> p) {
		var result = new ArrayList<Integer>();
		var map = new HashMap<Integer, Integer>();

		for (int i = 0; i < p.size(); i++) {
			map.put(p.get(i), i + 1);
		}

		for (int i = 1; i <= p.size(); i++) {
			result.add(map.get(map.get(i)));
		}

		return result;
	}

	public List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
		var result = new ArrayList<Integer>();
		LinkedList<Integer> b = new LinkedList<>(a);

		for (int i = 0; i < k; i++) {
			b.addFirst(b.getLast());
			b.removeLast();
		}

		ArrayList<Integer> c = new ArrayList<>(b);

		for (Integer query : queries) {
			result.add(c.get(query));
		}

		return result;
	}

	public int findDigits(int n) {
		var count = 0;
		var s = String.valueOf(n).toCharArray();

		for (char c : s) {
			var r = c - 48;
			if (r != 0 && n % r == 0) count++;
		}

		return count;
	}

	public void extraLongFactorials(int n) {
		BigInteger result = new BigInteger(String.valueOf(1));
		while (n > 0) {
			result = result.multiply(new BigInteger(String.valueOf(n)));
			n--;
		}
		System.out.println(result);
	}

	public String appendAndDelete(String s, String t, int k) {
		var sChars = s.toCharArray();
		var tChars = t.toCharArray();

		var m = 0;
		for (int i = 0; i < sChars.length && i < tChars.length; i++) {
			if (sChars[i] != tChars[i]) break;
			m++;
		}

		int count = (sChars.length - m) + (tChars.length - m);

		System.out.println(count);
		System.out.println(k % 2);
		System.out.println(count % 2);
		if (count != 0 && k % 2 != count % 2) {
			return "No";
		}

		return count <= k ? "Yes" : "No";
	}

	public String appendAndDelete1(String s, String t, int k) {
		if (k == 0) return s.equals(t) ? "Yes" : "No";
		if(s.length() + k > t.length()) return appendAndDelete1(s.length() == 0 ? "" : s.substring(0, s.length()-1), t, k -1);
		return s.length() + k == t.length() && t.startsWith(s) ? "Yes" : "No";
	}

	public long count() {
		var count = 0;

		for (int i = 0; i < 1000000; i++) {
			for (int j = 0; j < i; j++) {
				count++;
			}
		}

		return count;
	}

	public long getFloor(long apartmentNumber) {
		if (apartmentNumber % 7 == 0)
			return apartmentNumber / 7 + 1;

		return apartmentNumber / 7 + 2;
	}

	public int pageCount(int n, int p) {
		return n / 2 < p ? (n/2 - p/2) : p/2;
	}

	public int viralAdvertising(int n) {
		var result = 2;
		var s = 2;
		for (int i = 1; i < n; i++) {
			s = s * 3 / 2;
			result = result + s;
		}
		return result;
	}

	public long getHeaviest(List<Integer> packageWeights) {

		List<Integer> newList = packageWeights;

		while (!canNotMerged(newList)) {
			newList = merge(newList);
		}

		return newList
			.stream()
			.sorted()
			.collect(Collectors.toList())
			.get(newList.size() -1);
	}

	private boolean canNotMerged(List<Integer> packageWeights) {
		for (int i = 0; i < packageWeights.size() -1; i++) {
			if (packageWeights.get(i) < packageWeights.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	private List<Integer> merge(List<Integer> packageWeights) {
		List<Integer> newList = new LinkedList<>();

		for (int i = 0; i < packageWeights.size() -1; i++) {
			newList.add(packageWeights.get(i) < packageWeights.get(i + 1)
				? packageWeights.get(i) + packageWeights.get(i + 1)
				: packageWeights.get(i));
		}

		return newList;
	}

	public String truncate(String value) {
		if (value == null || value.isBlank() || value.isEmpty())
			return null;

		if (value.length() == 1) {
			return "0.0" + value;
		} else if (value.length() == 2) {
			return "0." + value;
		} else {
			return value.substring(0, value.length() - 2) + "." + value.substring(value.length() - 2);
		}
	}

	public int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
		var s = (int) ChronoUnit.DAYS.between(LocalDate.of(y1, m1, d1), LocalDate.of(y2, m2, d2)) * 15;
		if (s < 0) {
			s = s * (-1);
		}
		return s;
	}

	public long repeatedString(String s, long n) {
		long aCount = 0;
		var charArray = s.toCharArray();

		for (char c : charArray) {
			if (c == 'a') {
				aCount++;
			}
		}

		long extra = 0;
		for (int i = 0; i < n % s.length(); i++) {
			if (charArray[i] == 'a') {
				extra++;
			}
		}

		return aCount * n / s.length() + extra;
	}

	public List<Integer> cutTheSticks(List<Integer> arr) {
		List<Integer> result = new LinkedList<>();
		result.add(arr.size());
		Collections.sort(arr);

		while (!arr.isEmpty()) {
			int min = arr.get(0);
			List<Integer> temp = new ArrayList<>();
			for (Integer integer : arr) {
				int c = integer - min;
				if (c != 0) {
					temp.add(c);
				}
			}
			arr = temp;
			if (!arr.isEmpty()) {
				result.add(arr.size());
			}
		}

		return result;
	}

	public int squares(int a, int b) {
		int count = 0;
		int sqr = 1;
		int sum = 3;

		while (sqr <= b) {
			if (sqr >= a) {
				count++;
			}
			sqr = sqr + sum;
			sum = sum + 2;
		}

		return count;
	}

	public int equalizeArray(List<Integer> arr) {
		Map<Integer, Integer> counts = new HashMap<>();

		arr.forEach(o -> counts.merge(o, 1, Integer::sum));

		int max = 0;
		int number = 0;
		for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
			if (entry.getValue() > max){
				max = entry.getValue();
				number = entry.getKey();
			}
		}

		int count = 0;
		for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
			if (entry.getKey() != number) {
				count = count + entry.getValue();
			}
		}

		return count;
	}

	public String encryption(String s) {
		s = s.replace(" ", "");
		int sqrt = (int) Math.ceil(Math.sqrt(s.length()));

		System.out.println(sqrt);
		List<String> rows = new ArrayList<>();

		for (int i = 0; i < s.length(); i+=sqrt) {
			if (sqrt + i > s.length()) {
				rows.add(s.substring(i));
			} else {
				rows.add(s.substring(i, sqrt + i));
			}
		}

		System.out.println(rows);

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i <= sqrt; i++) {
			for (String row : rows) {
				char[] chars = row.toCharArray();
				if (chars.length > i) {
					builder.append(row.toCharArray()[i]);
				}
			}
			builder.append(" ");
		}

		return builder.toString();
	}

	public String catAndMouse(int x, int y, int z) {
		int xz = z - x;
		if (xz < 0) xz = xz * (-1);

		int yz = z - y;
		if (yz < 0) yz = yz * (-1);

		if (xz == yz) {
			return "Mouse C";
		} else if (xz < yz) {
			return "Cat A";
		} else {
			return "Cat B";
		}
	}

	public int minimumDistances(List<Integer> a) {
		int minDistance = Integer.MAX_VALUE;
		int distance;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < a.size(); i++) {
			if(map.containsKey(a.get(i))){
				distance = i - map.get(a.get(i));
				if(distance < 0) distance = distance * (-1);

				if(distance < minDistance){
					minDistance = distance;
				}
			} else {
				map.put(a.get(i), i);
			}
		}

		return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
	}

	public int beautifulTriplets(int d, List<Integer> arr) {
		Collections.sort(arr);

		int count = 0;
		for (Integer s : arr) {
			int current = 1;
			int c = s;
			for (Integer w : arr) {
				if (c + d == w) {
					current++;
					c = w;
				}

				if (current == 3) {
					count++;
					break;
				}
			}
		}

		return count;
	}

	public List<Integer> rotateLeft(int d, List<Integer> arr) {
		var result = new LinkedList<Integer>();
		result.addAll(arr.subList(d, arr.size()));
		result.addAll(arr.subList(0, d));

		return result;
	}

	public int maxValue(String t) {
		Map<String, Integer> count = new HashMap<>();

		char[] chars = t.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			for (int j = i + 1; j < chars.length; j++) {
				var s = t.substring(i, j + 1);
				count.merge(s, s.length(), Integer::sum);
			}
		}

		System.out.println(count);
		System.out.println(t.length());
		return count.values()
			.stream()
			.max(Integer::compareTo)
			.orElse(0);
	}

	public int maxValue1(String t) {
		Map<Character, Integer> counts = new HashMap<>();

		char[] chars = t.toCharArray();

		for (char aChar : chars) {
			counts.merge(aChar, 1, Integer::sum);
		}

		char c = ' ';
		int max = 0;
		for (Map.Entry<Character, Integer> count : counts.entrySet()) {
			if (max < count.getValue()) {
				c = count.getKey();
				max = count.getValue();
			}
		}

		List<String> substrings = new LinkedList<>();
		int flag = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != c) {
				substrings.add(new String(Arrays.copyOfRange(chars, flag, i)));
			}
		}

		return 0;
	}
}
