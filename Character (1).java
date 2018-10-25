/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movement;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

/**
 *
 * @author Hieu
 */
public class Character {
    private Vector2D velocity;
    private Vector2D position;
    private float rotation;
    private float orientation;
    private Color color;
    private int r;

    public Vector2D getVelocity() {
        return velocity;
    }

    public Vector2D getPosition() {
        return position;
    }

    public float getRotation() {
        return rotation;
    }

    public float getOrientation() {
        return orientation;
    }

    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public void setOrientation(float orientation) {
        this.orientation = orientation;
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
        final Character other = (Character) obj;
        if (Float.floatToIntBits(this.rotation) != Float.floatToIntBits(other.rotation)) {
            return false;
        }
        if (Float.floatToIntBits(this.orientation) != Float.floatToIntBits(other.orientation)) {
            return false;
        }
        if (!Objects.equals(this.velocity, other.velocity)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        return true;
    }
    

    public Character(Vector2D velocity, Vector2D position, float rotation, float orientation) {
        this.velocity = velocity;
        this.position = position;
        this.rotation = rotation;
        this.orientation = orientation;
    }

    public Character() {
    }
    
    public void update(KinematicOutput kinematicOutput,float time){
        this.velocity=kinematicOutput.getVelocity();
        this.rotation=kinematicOutput.getRotation();
        this.orientation+=this.rotation*time;
        this.position.addVector2D(Vector2D.mulConstant(velocity,time));
    }
    
    public void applyNewOrientation(){
        if(this.velocity.length()>0)
            this.orientation=(float) Math.atan2(-this.velocity.getX(), this.velocity.getZ());
    }

    @Override
    public String toString() {
        return "Character{" + "velocity=" + velocity + ", position=" + position + ", rotation=" + rotation + ", orientation=" + orientation + '}';
    }
    
    public void initRender(Color color,int r)
    {
        this.color=color;
        this.r=r;
    }
    
    public void render(Graphics g){
        float x=(float) (Math.sin(this.getOrientation()));
        float z=(float) (Math.cos(this.getOrientation()));
        g.setColor(color);
        g.drawOval((int) this.position.getX(),(int) this.position.getZ() , this.r*2, this.r*2);
        g.drawLine((int) (this.position.getX()+this.r),(int) (this.position.getZ()+this.r), (int) (this.position.getX()+this.r*(x+1)),(int) (this.position.getZ()+this.r*(z+1)));
    }
}
