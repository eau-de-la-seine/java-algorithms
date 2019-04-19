package fr.ekinci.algorithms.combination;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Gokan EKINCI
 */
public class CombinationTest {

	@Test
	public void generate_nominal_with_duplicated() {
		// GIVEN
		Set<Integer>[] series = inputSeries();

		// WHEN
		int[][] actual = Combination.builder()
				.duplicatedElements(true)
				.build()
				.generate(series);

		// THEN
		Assert.assertEquals(18, actual.length);

		int[] e1 = new int[]{1, 5, 3};
		int[] e2 = new int[]{1, 5, 7};
		int[] e3 = new int[]{1, 9, 3};
		int[] e4 = new int[]{1, 9, 7};
		int[] e5 = new int[]{1, 8, 3};
		int[] e6 = new int[]{1, 8, 7};
		int[] e7 = new int[]{2, 5, 3};
		int[] e8 = new int[]{2, 5, 7};
		int[] e9 = new int[]{2, 9, 3};
		int[] e10 = new int[]{2, 9, 7};
		int[] e11 = new int[]{2, 8, 3};
		int[] e12 = new int[]{2, 8, 7};
		int[] e13 = new int[]{3, 5, 3};
		int[] e14 = new int[]{3, 5, 7};
		int[] e15 = new int[]{3, 9, 3};
		int[] e16 = new int[]{3, 9, 7};
		int[] e17 = new int[]{3, 8, 3};
		int[] e18 = new int[]{3, 8, 7};

		Assert.assertTrue(exists(e1, actual));
		Assert.assertTrue(exists(e2, actual));
		Assert.assertTrue(exists(e3, actual));
		Assert.assertTrue(exists(e4, actual));
		Assert.assertTrue(exists(e5, actual));
		Assert.assertTrue(exists(e6, actual));
		Assert.assertTrue(exists(e7, actual));
		Assert.assertTrue(exists(e8, actual));
		Assert.assertTrue(exists(e9, actual));
		Assert.assertTrue(exists(e10, actual));
		Assert.assertTrue(exists(e11, actual));
		Assert.assertTrue(exists(e12, actual));
		Assert.assertTrue(exists(e13, actual));
		Assert.assertTrue(exists(e14, actual));
		Assert.assertTrue(exists(e15, actual));
		Assert.assertTrue(exists(e16, actual));
		Assert.assertTrue(exists(e17, actual));
		Assert.assertTrue(exists(e18, actual));
	}

	@Test
	public void generate_nominal_without_duplicated() {
		// GIVEN
		Set<Integer>[] series = inputSeries();

		// WHEN
		int[][] actual = Combination.builder()
				.duplicatedElements(false)
				.build()
				.generate(series);

		// THEN
		Assert.assertEquals(15, actual.length);

		int[] e1 = new int[]{1, 5, 3};
		int[] e2 = new int[]{1, 5, 7};
		int[] e3 = new int[]{1, 9, 3};
		int[] e4 = new int[]{1, 9, 7};
		int[] e5 = new int[]{1, 8, 3};
		int[] e6 = new int[]{1, 8, 7};
		int[] e7 = new int[]{2, 5, 3};
		int[] e8 = new int[]{2, 5, 7};
		int[] e9 = new int[]{2, 9, 3};
		int[] e10 = new int[]{2, 9, 7};
		int[] e11 = new int[]{2, 8, 3};
		int[] e12 = new int[]{2, 8, 7};
		int[] e14 = new int[]{3, 5, 7};
		int[] e16 = new int[]{3, 9, 7};
		int[] e18 = new int[]{3, 8, 7};

		Assert.assertTrue(exists(e1, actual));
		Assert.assertTrue(exists(e2, actual));
		Assert.assertTrue(exists(e3, actual));
		Assert.assertTrue(exists(e4, actual));
		Assert.assertTrue(exists(e5, actual));
		Assert.assertTrue(exists(e6, actual));
		Assert.assertTrue(exists(e7, actual));
		Assert.assertTrue(exists(e8, actual));
		Assert.assertTrue(exists(e9, actual));
		Assert.assertTrue(exists(e10, actual));
		Assert.assertTrue(exists(e11, actual));
		Assert.assertTrue(exists(e12, actual));
		Assert.assertTrue(exists(e14, actual));
		Assert.assertTrue(exists(e16, actual));
		Assert.assertTrue(exists(e18, actual));
	}

	@Test
	public void generate_nominal_with_duplicated_2() {
		// GIVEN
		Set<Integer>[] series = inputSeries2();

		// WHEN
		int[][] actual = Combination.builder()
				.duplicatedElements(true)
				.build()
				.generate(series);

		// THEN
		Assert.assertEquals(30, actual.length);

		int[] e1 = new int[]{2, 10, 5};
		int[] e2 = new int[]{2, 10, 8};
		int[] e3 = new int[]{2, 10, 11};
		int[] e4 = new int[]{2, 10, 7};
		int[] e5 = new int[]{2, 10, 10};
		int[] e6 = new int[]{2, 2, 5};
		int[] e7 = new int[]{2, 2, 8};
		int[] e8 = new int[]{2, 2, 11};
		int[] e9 = new int[]{2, 2, 7};
		int[] e10 = new int[]{2, 2, 10};
		int[] e11 = new int[]{5, 10, 5};
		int[] e12 = new int[]{5, 10, 8};
		int[] e13 = new int[]{5, 10, 11};
		int[] e14 = new int[]{5, 10, 7};
		int[] e15 = new int[]{5, 10, 10};
		int[] e16 = new int[]{5, 2, 5};
		int[] e17 = new int[]{5, 2, 8};
		int[] e18 = new int[]{5, 2, 11};
		int[] e19 = new int[]{5, 2, 7};
		int[] e20 = new int[]{5, 2, 10};
		int[] e21 = new int[]{3, 10, 5};
		int[] e22 = new int[]{3, 10, 8};
		int[] e23 = new int[]{3, 10, 11};
		int[] e24 = new int[]{3, 10, 7};
		int[] e25 = new int[]{3, 10, 10};
		int[] e26 = new int[]{3, 2, 5};
		int[] e27 = new int[]{3, 2, 8};
		int[] e28 = new int[]{3, 2, 11};
		int[] e29 = new int[]{3, 2, 7};
		int[] e30 = new int[]{3, 2, 10};

		Assert.assertTrue(exists(e1, actual));
		Assert.assertTrue(exists(e2, actual));
		Assert.assertTrue(exists(e3, actual));
		Assert.assertTrue(exists(e4, actual));
		Assert.assertTrue(exists(e5, actual));
		Assert.assertTrue(exists(e6, actual));
		Assert.assertTrue(exists(e7, actual));
		Assert.assertTrue(exists(e8, actual));
		Assert.assertTrue(exists(e9, actual));
		Assert.assertTrue(exists(e10, actual));
		Assert.assertTrue(exists(e11, actual));
		Assert.assertTrue(exists(e12, actual));
		Assert.assertTrue(exists(e13, actual));
		Assert.assertTrue(exists(e14, actual));
		Assert.assertTrue(exists(e15, actual));
		Assert.assertTrue(exists(e16, actual));
		Assert.assertTrue(exists(e17, actual));
		Assert.assertTrue(exists(e18, actual));
		Assert.assertTrue(exists(e19, actual));
		Assert.assertTrue(exists(e20, actual));
		Assert.assertTrue(exists(e21, actual));
		Assert.assertTrue(exists(e22, actual));
		Assert.assertTrue(exists(e23, actual));
		Assert.assertTrue(exists(e24, actual));
		Assert.assertTrue(exists(e25, actual));
		Assert.assertTrue(exists(e26, actual));
		Assert.assertTrue(exists(e27, actual));
		Assert.assertTrue(exists(e28, actual));
		Assert.assertTrue(exists(e29, actual));
		Assert.assertTrue(exists(e30, actual));
	}

	@Test
	public void generate_nominal_without_duplicated_2() {
		// GIVEN
		Set<Integer>[] series = inputSeries2();

		// WHEN
		int[][] actual = Combination.builder()
				.duplicatedElements(false)
				.build()
				.generate(series);

		// THEN
		Assert.assertEquals(20, actual.length);

		int[] e1 = new int[]{2, 10, 5};
		int[] e2 = new int[]{2, 10, 8};
		int[] e3 = new int[]{2, 10, 11};
		int[] e4 = new int[]{2, 10, 7};
		int[] e12 = new int[]{5, 10, 8};
		int[] e13 = new int[]{5, 10, 11};
		int[] e14 = new int[]{5, 10, 7};
		int[] e17 = new int[]{5, 2, 8};
		int[] e18 = new int[]{5, 2, 11};
		int[] e19 = new int[]{5, 2, 7};
		int[] e20 = new int[]{5, 2, 10};
		int[] e21 = new int[]{3, 10, 5};
		int[] e22 = new int[]{3, 10, 8};
		int[] e23 = new int[]{3, 10, 11};
		int[] e24 = new int[]{3, 10, 7};
		int[] e26 = new int[]{3, 2, 5};
		int[] e27 = new int[]{3, 2, 8};
		int[] e28 = new int[]{3, 2, 11};
		int[] e29 = new int[]{3, 2, 7};
		int[] e30 = new int[]{3, 2, 10};

		Assert.assertTrue(exists(e1, actual));
		Assert.assertTrue(exists(e2, actual));
		Assert.assertTrue(exists(e3, actual));
		Assert.assertTrue(exists(e4, actual));
		Assert.assertTrue(exists(e12, actual));
		Assert.assertTrue(exists(e13, actual));
		Assert.assertTrue(exists(e14, actual));
		Assert.assertTrue(exists(e17, actual));
		Assert.assertTrue(exists(e18, actual));
		Assert.assertTrue(exists(e19, actual));
		Assert.assertTrue(exists(e20, actual));
		Assert.assertTrue(exists(e21, actual));
		Assert.assertTrue(exists(e22, actual));
		Assert.assertTrue(exists(e23, actual));
		Assert.assertTrue(exists(e24, actual));
		Assert.assertTrue(exists(e26, actual));
		Assert.assertTrue(exists(e27, actual));
		Assert.assertTrue(exists(e28, actual));
		Assert.assertTrue(exists(e29, actual));
		Assert.assertTrue(exists(e30, actual));
	}

	private boolean exists(int[] expected, int[][] actual) {
		return Arrays.stream(actual)
				.filter(a -> a[0] == expected[0] && a[1] == expected[1] && a[2] == expected[2])
				.count() == 1;
	}

	private Set<Integer>[] inputSeries() {
		Set<Integer> set1 = new HashSet<Integer>(){{
			add(1);
			add(2);
			add(3);
		}};

		Set<Integer> set2 = new HashSet<Integer>(){{
			add(5);
			add(9);
			add(8);
		}};

		Set<Integer> set3 = new HashSet<Integer>(){{
			add(3);
			add(7);
		}};

		return (Set<Integer>[]) new Set<?>[]{set1, set2, set3};
	}

	private Set<Integer>[] inputSeries2() {
		Set<Integer> set1 = new HashSet<Integer>(){{
			add(2);
			add(5);
			add(3);
		}};

		Set<Integer> set2 = new HashSet<Integer>(){{
			add(10);
			add(2);
		}};

		Set<Integer> set3 = new HashSet<Integer>(){{
			add(5);
			add(8);
			add(11);
			add(7);
			add(10);
		}};

		return (Set<Integer>[]) new Set<?>[]{set1, set2, set3};
	}

	@Test(expected = IllegalArgumentException.class)
	public void generate_checkArguments_argument_null() {
		Combination.builder()
				.build()
				.generate(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void generate_checkArguments_argument_empty() {
		Combination.builder()
				.build()
				.generate((Set<Integer>[]) new Set[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void generate_checkArguments_serie_null() {
		Combination.builder()
				.build()
				.generate(null, new HashSet<>());
	}

	@Test(expected = IllegalArgumentException.class)
	public void generate_checkArguments_serie_empty() {
		Combination.builder()
				.build()
				.generate(new HashSet<>(), new HashSet<>());
	}
}