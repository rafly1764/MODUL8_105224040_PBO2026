package com.rpg.arena;

public abstract class Karakter implements AksiBertarung {

    protected String nama;
    protected int hp;
    protected int baseDamage;
    protected boolean isDefending;
    public Karakter(String nama, int hp, int baseDamage) {
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.isDefending = false;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
    public boolean getIsDefending() {
        return isDefending;
    }
    public void setIsDefending(boolean isDefending) {
        this.isDefending = isDefending;
    }
    public void terimaDamage(int damage) {
        if (isDefending) {
            damage = damage / 2;
            isDefending = false;
            System.out.println(nama + " berhasil mengurangi damage");
        }
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
        System.out.println(nama + " menerima damage " + damage);
    }
    public abstract void tampilkanStatus();
}