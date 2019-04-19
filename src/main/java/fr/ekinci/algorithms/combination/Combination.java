package fr.ekinci.algorithms.combination;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Gokan EKINCI
 */
public class Combination {
	private final boolean duplicatedElements;

	private Combination(boolean duplicatedElements) {
		this.duplicatedElements = duplicatedElements;
	}

	public static CombinationBuilder builder() {
		return new CombinationBuilder();
	}

	public static class CombinationBuilder {
		private boolean duplicatedElements;

		public CombinationBuilder duplicatedElements(boolean duplicatedElements) {
			this.duplicatedElements = duplicatedElements;
			return this;
		}

		public Combination build() {
			return new Combination(duplicatedElements);
		}
	}

	public int[][] generate(Set<Integer>... series) {
		checkArguments(series);

		Data data = new Data(series);
		int nbRows = data.nbCombinations;
		int nbColumns = data.columnIndexes.length;
		ColumnIndex[] columnIndexes = data.columnIndexes;

		int[][] combinations = new int[nbRows][nbColumns];
		int[][] arraySeries = convert(series);

		for (int i = 0; i < nbRows; i++) {
			for (int j = 0; j < nbColumns; j++) {
				combinations[i][j] = arraySeries[j][columnIndexes[j].getIndex()];
			}
		}

		if (!duplicatedElements) {
			return Arrays.stream(combinations)
					.filter(array -> {
						Set<Integer> set = Arrays.stream(array).boxed().collect(Collectors.toSet());
						return set.size() == nbColumns;
					})
					.toArray(int[][]::new);
		}

		return combinations;
	}

	private static class ColumnIndex {
		private final int length;
		private int counter;
		private int currentIndex;

		public ColumnIndex(int length) {
			this.length = length;
			counter = 0;
			currentIndex = 0;
		}

		public int getIndex() {
			// Re-init currentIndex
			if (counter == length) {
				counter = 0;
				currentIndex++;
				if (currentIndex > length) {
					currentIndex = 0;
				}
			}

			counter++;
			return currentIndex;
		}
	}

	private static class Data {
		private final int nbCombinations;
		private final ColumnIndex[] columnIndexes;

		public Data(Set<Integer>[] series) {
			columnIndexes = new ColumnIndex[series.length];
			nbCombinations = initColumnIndexAndReturnNbCombinations(series, columnIndexes);
		}

		private int initColumnIndexAndReturnNbCombinations(Set<Integer>[] series, ColumnIndex[] columnIndexes) {
			// Loop starting from the last index of "columnIndexes"
			int nbCombinations = 1;

			// Initializing "i" for starting from the last index
			for (int i = columnIndexes.length - 1; i >= 0; i--) {
				columnIndexes[i] = new ColumnIndex(nbCombinations);

				// Prepare next "nbCombinations"
				nbCombinations *= series[i].size();
			}

			return nbCombinations;
		}
	}

	private int[][] convert(Set<Integer>[] arrayOfSet) {
		int[][] arraySeries = new int[arrayOfSet.length][];
		for (int i = 0; i < arrayOfSet.length; i++) {
			List<Integer> list = new ArrayList<>(arrayOfSet[i]);
			int[] arraySerie = new int[list.size()];
			for (int j = 0; j < arraySerie.length; j++) {
				arraySerie[j] = list.get(j);
			}
			arraySeries[i] = arraySerie;
		}

		return arraySeries;
	}

	private void checkArguments(Set<Integer>[] series) {
		if (series == null) {
			throw new IllegalArgumentException("Argument at index '0' must not be null");
		} else if (series.length == 0) {
			throw new IllegalArgumentException("Argument at index '0' must not be empty");
		}

		for (int i = 0; i < series.length; i++) {
			if (series[i] == null) {
				throw new IllegalArgumentException(String.format("Serie at index '%s' must not be null", i));
			} else if (series[i].isEmpty()) {
				throw new IllegalArgumentException(String.format("Serie at index '%s' must not be empty", i));
			}
		}
	}
}