/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movement;

/**
 *
 * @author Hieu
 */
public class Vector2D {
    private float x;
    private float z;

    public Vector2D() {
    }

    public Vector2D(float x, float z) {
        this.x = x;
        this.z = z;
    }

    public float getX() {
        return this.x;
    }

    public float getZ() {
        return this.z;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vector2D other = (Vector2D) obj;
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
            return false;
        }
        if (Float.floatToIntBits(this.z) != Float.floatToIntBits(other.z)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vector2D{" + "x=" + x + ", z=" + z + '}';
    }
    
    public float length(){
        return (float) Math.sqrt(this.x*this.x+this.z*this.z);
    }
    
    public void normalize()
    {
        float length=this.length();
        this.x/=length;
        this.z/=length;
    }
    
    public static Vector2D addVector2D(Vector2D a,Vector2D b){
        return new Vector2D(a.getX()+b.getX(),a.getZ()+b.getZ());
    }
    
    public Vector2D addVector2D(Vector2D v){
        this.x+=v.getX();
        this.z+=v.getZ();
        return this;
    }
    
    public static Vector2D subVector2D(Vector2D a,Vector2D b){
        return new Vector2D(a.getX()-b.getX(),a.getZ()-b.getZ());
    }
    
    public Vector2D subVector2D(Vector2D v){
        this.x-=v.getX();
        this.z-=v.getZ();
        return this;
    }
    
    public static Vector2D mulConstant(Vector2D v,float c){
        return new Vector2D(v.getX()*c,v.getZ()*c);
    }
    
    public Vector2D mulConstant(float c){
        this.x*=c;
        this.z*=c;
        return this;
    }
            
}
