/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movement;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Hieu
 */
public class Wandering {
    private Character character;
    private float maxRotation;
    private float maxSpeed;

    public Wandering() {
    }

    public Wandering(Character character, float maxRotation, float maxSpeed) {
        this.character = character;
        this.maxRotation = maxRotation;
        this.maxSpeed = maxSpeed;
    }

    public Character getCharacter() {
        return character;
    }

    public float getMaxRotation() {
        return maxRotation;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setMaxRotation(float maxRotation) {
        this.maxRotation = maxRotation;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Wandering other = (Wandering) obj;
        if (Float.floatToIntBits(this.maxRotation) != Float.floatToIntBits(other.maxRotation)) {
            return false;
        }
        if (Float.floatToIntBits(this.maxSpeed) != Float.floatToIntBits(other.maxSpeed)) {
            return false;
        }
        if (!Objects.equals(this.character, other.character)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Wandering{" + "character=" + character + ", maxRotation=" + maxRotation + ", maxSpeed=" + maxSpeed + '}';
    }
    
    
    
    public static float randomBionomial(){
        Random r = new Random();
        return r.nextFloat()-r.nextFloat();
    }
    
    public KinematicSteeringOutput generateKinematicSteeringOutput(){
        float x=(float) (Math.sin(character.getOrientation()));
        float z=(float) (Math.cos(character.getOrientation()));
        
        Vector2D velocity=new Vector2D(x,z);
        velocity.mulConstant(maxSpeed);
        float rotation=randomBionomial()*maxRotation;
        return new KinematicSteeringOutput(velocity,rotation);
    }
}
