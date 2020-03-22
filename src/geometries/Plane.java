package geometries;
import primitives.Point3D;
import primitives.Vector;

import java.util.Objects;

public class Plane implements Geometry {
    Point3D _p;
    primitives.Vector _normal;

    public Plane(Point3D _p, Vector _normal) {
        this._p = new Point3D(_p);
        this._normal = new Vector(_normal);
    }

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        _p=new Point3D(p1.get_x(),p1.get_y(),p1.get_z());
        _normal=new Vector(Point3D.ZERO); //TODO:זה אסור לפי ההוראות
    }

    public Plane(Plane pl) {
        this(pl._p,pl._normal);
    }

    public Point3D get_p() {
        return _p;
    }

    public Vector get_normal() {
        return _normal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return plane._p.equals(_p) &&
                plane._normal.equals(_normal);
    }

    @Override
    public Vector getNormal(Point3D p) {
        return _normal;
    }

    public Vector getNormal() {
        return getNormal(_p);
    }
}