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
public class KinematicFlee {
    private Character character;
    private Character target;
    private float maxspeed;

    public KinematicFlee(Character character, Character target, float maxspeed) {
        this.character = character;
        this.target = target;
        this.maxspeed = maxspeed;
    }

    public KinematicFlee() {
    }

    public Character getCharacter() {
        return character;
    }

    public Character getTarget() {
        return target;
    }

    public float getMaxspeed() {
        return maxspeed;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setTarget(Character target) {
        this.target = target;
    }

    public void setMaxspeed(float maxspeed) {
        this.maxspeed = maxspeed;
    }
    
    
    public KinematicOutput generateKinematicOutput(){
        Vector2D velocity=new Vector2D();
        velocity=Vector2D.subVector2D(character.getPosition(), target.getPosition());
        velocity.normalize();
        velocity.mulConstant(maxspeed);
        
        return new KinematicOutput(velocity, 0);
    }
}
