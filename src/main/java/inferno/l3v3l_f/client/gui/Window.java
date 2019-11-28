package inferno.l3v3l_f.client.gui;

import inferno.l3v3l_f.client.rendering.Camera;
import inferno.l3v3l_f.client.rendering.RendererGame;
import inferno.l3v3l_f.client.world.ClientWorld;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private RendererGame game;
    private ClientWorld world;

    public Window(String title){
        super(title);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(3);
        world = ClientWorld.genWorld();
        game = new RendererGame(world);
    }



    public void draw() {
        Graphics2D graphics2D;
        if (this.getBufferStrategy() != null){
            graphics2D = (Graphics2D) getBufferStrategy().getDrawGraphics();
        } else {
            createBufferStrategy(4);
            return;
        }

        game.draw(graphics2D);

        graphics2D.dispose();

        getBufferStrategy().show();
    }
}
