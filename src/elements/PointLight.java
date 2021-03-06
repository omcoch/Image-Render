package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * Defines a point light source object, that has a fixed position and
 * radiates light equally in all directions away from itself.
 */
public class PointLight extends Light implements LightSource {
    protected Point3D _position;
    protected double _kC, _kL, _kQ;
    protected double radius;

    /**
     * constructor for point light
     *
     * @param _intensity the intensity of the light
     * @param _position  the position of the light
     * @param _kC        Constant attenuation
     * @param _kL        Linear attenuation
     * @param _kQ        Quadratic attenuation
     */
    public PointLight(Color _intensity, Point3D _position, double _kC, double _kL, double _kQ) {
        super(_intensity);
        this._position = _position;
        this._kC = _kC;
        this._kL = _kL;
        this._kQ = _kQ;
    }

    /**
     * return the intensity of the light in a given
     *
     * @param p the point
     * @return color of intensity
     */
    @Override
    public Color getIntensity(Point3D p) {
        double d = p.distance(_position);
        double d2 = p.distanceSquared(_position);

        return _intensity.reduce(_kC + _kL * d + _kQ * d2);
    }

    /**
     * return a vector from the light to the point
     *
     * @param p point
     * @return vector from light to point
     */
    @Override
    public Vector getL(Point3D p) {
        if (p.equals(_position)) // in case p is the position of the light
            return null;
        return p.subtract(_position).normalize();
    }

    /**
     * return the distance between the light source to the point
     *
     * @param p the point
     * @return distance between the light source to the point
     */
    @Override
    public double getDistance(Point3D p) {
        return this._position.distance(p);
    }
}
