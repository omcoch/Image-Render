package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for geometries.Sphere class
 *
 * @author Ron & Omri
 */
class SphereTest {

    /**
     * Test method for {@link geometries.Sphere#getNormal(Point3D)}.
     */
    @Test
    void getNormal() {
        // ============ Equivalence Partitions Tests ==============
        // Test for correct normal of a sphere
        Sphere s = new Sphere(1, Point3D.ZERO);
        Vector normal = new Vector(1, 0, 0); // P - O = (1,0,0)-(0,0,0)
        assertEquals(s.getNormal(new Point3D(1, 0, 0)), normal, "Error: Bad normal to Sphere");
    }

    /**
     * Test method for {@link geometries.Sphere#Sphere(double, Point3D)}.
     */
    @Test
    void testConstructor() {
        // ============ Equivalence Partitions Tests ==============
        // Test for 0 or less radius size
        try {
            Sphere s = new Sphere(0, Point3D.ZERO);
            fail("Constructed a Sphere with radius 0");
        } catch (IllegalArgumentException e) {
        }

        // =============== Boundary Values Tests ==================
        // Test for epsilon radius size
        try {
            Sphere s = new Sphere(0.0000000000001, Point3D.ZERO);
            fail("Constructed a Sphere with radius 0");
        } catch (IllegalArgumentException e) {
        }
    }

}