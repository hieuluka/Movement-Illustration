/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movement;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hieu
 */
public class GameLoop implements Runnable {
    
    private boolean isRunning;
    private Demo demo;

    public GameLoop() {
    }

    public GameLoop(boolean isRunning, Demo demo) {
        this.isRunning = isRunning;
        this.demo = demo;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public Demo getDemo() {
        return demo;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setDemo(Demo demo) {
        this.demo = demo;
    }
    
    public void Return(Character c)
    {
        if(c.getPosition().getX()>800||c.getPosition().getX()<0)
            c.setPosition(new Vector2D((c.getPosition().getX()+800)%800,c.getPosition().getZ()));
        if(c.getPosition().getZ()>800||c.getPosition().getZ()<0)
            c.setPosition(new Vector2D(c.getPosition().getX(),(c.getPosition().getZ()+800)%800));
    }
            
    @Override
    public void run(){
        
        Character character1=new Character(new Vector2D(0,0),new Vector2D(200,200),0,0);
        Character character2=new Character(new Vector2D(0,0),new Vector2D(400,400),0,0);
        character1.initRender(Color.red, 25);
        character2.initRender(Color.blue, 50);
        Wandering wand1=new Wandering(character1, (float) Math.PI,25);
        Wandering wand2=new Wandering(character2, (float) Math.PI/2,50);
        while(isRunning) {
            demo.getGraphics().clearRect(0, 0, demo.getWidth(), demo.getHeight());
            character1.render(demo.getGraphics());
            character2.render(demo.getGraphics());
            
            character1.update(wand1.generateKinematicSteeringOutput(), 1);
            character2.update(wand2.generateKinematicSteeringOutput(), 1);
            Return(character1);
            Return(character2);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(GameLoop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
