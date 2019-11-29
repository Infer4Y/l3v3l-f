package inferno.l3v3l_f.client.gui;

import inferno.l3v3l_f.client.rendering.Camera;
import inferno.l3v3l_f.client.rendering.RendererGame;
import inferno.l3v3l_f.client.world.ClientWorld;
import inferno.l3v3l_f.common.utils.math.Vector2f;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private RendererGame game;
    private ClientWorld world;
    private WindowHelper windowHelper;

    public Window(String title){
        super(title);
        setSize(400,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        world = ClientWorld.genWorld();
        game = new RendererGame(world);
        windowHelper = new WindowHelper();
        addKeyListener(windowHelper);
    }

    public void update(){
        game.moveCamera(windowHelper.move());
        Vector2f rot = windowHelper.rotate(game.getCamera().getRotationX(), game.getCamera().getRotationY());
        game.getCamera().setRotationX(rot.getX());
        game.getCamera().setRotationY(rot.getY());
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

    public RendererGame getRenderer(){
        return game;
    }
}
