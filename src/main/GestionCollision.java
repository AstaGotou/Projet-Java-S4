package main;

import entite.*;


import java.awt.*;

public class GestionCollision {
    GamePanel gp;

    public GestionCollision(GamePanel gp){
        this.gp = gp;
    }

    public void checkBloc(Entite e1){
        int entiteLeftHitbox = e1.getHitbox().x; // position gauche de la hitbox
        int entiteRightHitbox = e1.getHitbox().x + e1.getHitbox().width; // position droite de la hitbox
        int entiteTopHitbox = e1.getHitbox().y;  // position haut de la hitbox
        int entiteBottomHitbox = e1.getHitbox().y  + e1.getHitbox().height; // position bas de la hitbox

        int entiteMouvLeftCol = (entiteLeftHitbox - e1.getSpeed())/gp.tileSize; // numéro de colonne
        int entiteMouvRightCol = (entiteRightHitbox +e1.getSpeed()) /gp.tileSize;
        int entiteMouvTopRow = (entiteTopHitbox -e1.getSpeed()) /gp.tileSize;
        int entiteMouvBottomRow = (entiteBottomHitbox+e1.getSpeed()) /gp.tileSize;
        int entitePositionLeftCol = (entiteLeftHitbox)/gp.tileSize;
        int entitePositionRightCol = (entiteRightHitbox)/gp.tileSize;
        int entitePositionTopRow = (entiteTopHitbox)/gp.tileSize;
        int entitePositionBottomRow = (entiteBottomHitbox)/gp.tileSize;

        int bloc1, bloc2, bloc3, bloc4, bloc5, bloc6, bloc7, bloc8;

        bloc1 = gp.gestionBloc.mapBlocNum[entitePositionLeftCol][entiteMouvTopRow];
        bloc2 = gp.gestionBloc.mapBlocNum[entitePositionRightCol][entiteMouvTopRow];
        bloc3 = gp.gestionBloc.mapBlocNum[entiteMouvRightCol][entitePositionTopRow];
        bloc4 = gp.gestionBloc.mapBlocNum[entiteMouvRightCol][entitePositionBottomRow];
        bloc5 = gp.gestionBloc.mapBlocNum[entitePositionLeftCol][entiteMouvBottomRow];
        bloc6 = gp.gestionBloc.mapBlocNum[entitePositionRightCol][entiteMouvBottomRow];
        bloc7 = gp.gestionBloc.mapBlocNum[entiteMouvLeftCol][entitePositionTopRow];
        bloc8 = gp.gestionBloc.mapBlocNum[entiteMouvLeftCol][entitePositionBottomRow];


        if (gp.gestionBloc.bloc[bloc1].getCollision() || gp.gestionBloc.bloc[bloc2].getCollision()) {
            e1.setCollisionTopOn(true);
        }
        if (gp.gestionBloc.bloc[bloc3].getCollision() || gp.gestionBloc.bloc[bloc4].getCollision()) {
            e1.setCollisionRightOn(true);
        }
        if (gp.gestionBloc.bloc[bloc5].getCollision() || gp.gestionBloc.bloc[bloc6].getCollision()) {
            e1.setCollisionBottomOn(true);
        }
        if (gp.gestionBloc.bloc[bloc7].getCollision() || gp.gestionBloc.bloc[bloc8].getCollision()) {
            e1.setCollisionLeftOn(true);
        }

    }
    public int checkItem(Entite e){
        Rectangle rd = new Rectangle(e.getHitbox().x + e.getSpeed()+1, e.getHitbox().y, e.getHitbox().width, e.getHitbox().height);
        Rectangle rg = new Rectangle(e.getHitbox().x - e.getSpeed()-1, e.getHitbox().y, e.getHitbox().width, e.getHitbox().height);
        Rectangle rb = new Rectangle(e.getHitbox().x, e.getHitbox().y + e.getSpeed()+1, e.getHitbox().width, e.getHitbox().height);
        Rectangle rh = new Rectangle(e.getHitbox().x, e.getHitbox().y - e.getSpeed()-1, e.getHitbox().width, e.getHitbox().height);

        int index = 999;
        for (int i = 0; i < gp.item.length; i++) {
            if (gp.item[i] != null) {
                   if (gp.item[i].getCollision()) {
                       if (rd.intersects(gp.item[i].getHitBoxItem())) {
                           e.setCollisionRightOn(true);
                           index = i;
                       }
                       if (rg.intersects(gp.item[i].getHitBoxItem())) {
                           e.setCollisionLeftOn(true);
                           index = i;
                       }
                       if (rb.intersects(gp.item[i].getHitBoxItem())) {
                           e.setCollisionBottomOn(true);
                           index = i;
                       }
                       if (rh.intersects(gp.item[i].getHitBoxItem())) {
                           e.setCollisionTopOn(true);
                           index = i;
                       }
                   }
                   else {
                       if (e.getHitbox().intersects(gp.item[i].getHitBoxItem())) {
                           index = i;
                       }
                   }
            }
        }
        return index;
    }

    public int checkMonster(Entite e){
        int index = 999;
        for (int i = 0; i < gp.monstre.length; i++) {
            if (gp.monstre[i] != null) {
                if (gp.monstre[i].getHitbox().intersects(e.getHitbox())) {
                    index = i;
                }
            }
        }
        return index;
    }
    public void checkMonster2(Monstre m){
        Rectangle rd = new Rectangle(m.getHitbox().x + m.getSpeed(), m.getHitbox().y, m.getHitbox().width, m.getHitbox().height);
        Rectangle rg = new Rectangle(m.getHitbox().x - m.getSpeed(), m.getHitbox().y, m.getHitbox().width, m.getHitbox().height);
        Rectangle rb = new Rectangle(m.getHitbox().x, m.getHitbox().y + m.getSpeed(), m.getHitbox().width, m.getHitbox().height);
        Rectangle rh = new Rectangle(m.getHitbox().x, m.getHitbox().y - m.getSpeed(), m.getHitbox().width, m.getHitbox().height);
        for (int i = 0; i < gp.monstre.length; i++) {
            if (gp.monstre[i] != null && gp.monstre[i] != m) {
                if (rd.intersects(gp.monstre[i].getHitbox())) {
                    m.setCollisionRightOn(true);
                }
                if (rg.intersects(gp.monstre[i].getHitbox())) {
                    m.setCollisionLeftOn(true);
                }
                if (rb.intersects(gp.monstre[i].getHitbox())) {
                    m.setCollisionBottomOn(true);
                }
                if (rh.intersects(gp.monstre[i].getHitbox())) {
                    m.setCollisionTopOn(true);
                }
            }
        }
    }
    public int checkMonsterAttack(Joueur j){
        int index = 999;
        for (int i = 0; i < gp.monstre.length; i++) {
            if (gp.monstre[i] != null && j.getIsAttacking()) {
                if (gp.monstre[i].getHitbox().intersects(j.getAttackArea())) {
                    index = i;
                }
            }
        }
        return index;
    }
}
