package fr.ekinci.algorithms.series;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CurveTest {

	@Test
	public void testCurve() {
		Curve curve = new Curve(33333, -720, 0, (cX) -> Math.pow(1.4, 0.09d * cX));
		double[] coordinates = curve.coordinates();

		// THEN
		Assert.assertEquals(994.276053, curve.getKonstant(), 0.0001);
		Assert.assertEquals(721, coordinates.length);
		Assert.assertEquals(33333, Arrays.stream(coordinates).sum(), 0.0001);
	}
}
