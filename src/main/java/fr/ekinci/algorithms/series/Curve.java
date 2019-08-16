package fr.ekinci.algorithms.series;

import java.util.Objects;
import java.util.function.Function;

/**
 * Generates a curve's coordinates like f(x) = 1.4^(0.09x)
 *
 * Example from X=-720 to X=0:
 *     double[] result = new Curve(33333, -720, 0, (coordinateX) -> Math.pow(1.4, 0.09 * coordinateX)).coordinates();
 *
 *     X=-720 | f(-720) => result[0]   => 3.376060863450751E-7
 *     ...
 *     X=-1   | f(-1)   => result[719] => 964.6182099003505
 *     X=0    | f(0)    => result[720] => 994.2760525279222
 *
 * Interpretation: "At -720 minutes there was 0 events ... at -1 minute there were 965 events, at 0 minute there were 994 events"
 *
 * Try with https://www.desmos.com/calculator and `1.4^{0.09x}`
 */
public class Curve {
	private final int NB_EVENTS;
	private final int NB_POINTS;
	private final int FROM_X;
	private final int TO_X;
	private final Function<Integer, Double> formula;

	public Curve(int nbEvents, int fromX, int toX, Function<Integer, Double> formula) {
		checks(nbEvents, fromX, toX, formula);
		this.NB_EVENTS = nbEvents;
		this.NB_POINTS = getNbPoints(fromX, toX);
		this.FROM_X = fromX;
		this.TO_X = toX;
		this.formula = formula;
	}

	private int getNbPoints(int fromX, int toX) {
		return (fromX > 0) ? toX - fromX + 1 : -fromX + toX + 1;
	}

	/**
	 * k = nbEvents / sum(f(X))
	 */
	private double konstant(int nbEvents, int fromX, int toX) {
		return nbEvents / denominator(fromX, toX);
	}

	/**
	 * "Serie", somme de f(x)
	 */
	private double denominator(int fromX, int toX) {
		double denominator = 0;
		for (int x = fromX; x <= toX; x++) {
			denominator += formula.apply(x);
		}

		return denominator;
	}

	private double calculation(double konstant, int coordinateX) {
		return konstant * formula.apply(coordinateX);
	}

	public double[] coordinates() {
		final double k = konstant(NB_EVENTS, FROM_X, TO_X);
		final double[] coordinates = new double[NB_POINTS];
		for (int x = FROM_X, i = 0; x <= TO_X; x++, i++) {
			coordinates[i] = calculation(k, x);
		}

		return coordinates;
	}

	public double getKonstant() {
		return konstant(NB_EVENTS, FROM_X, TO_X);
	}

	private void checks(int nbEvents, int fromX, int toX, Function<Integer, Double> formula) {
		if (nbEvents < 1) {
			throw new RuntimeException("`nbEvents` must be superior to 0");
		}

		if (fromX > toX) {
			throw new RuntimeException("`toX` must be superior to `fromX`");
		}

		Objects.requireNonNull(formula, "`formula` must not be null");
	}
}
