package com.rpg.entitas;

import com.rpg.arena.Karakter;

public class Pahlawan extends Karakter {

    private int mana;
    private int level;
    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) {
        super(nama, hp, baseDamage);
        this.mana = mana;
        this.level = level;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    @Override
    public int serang() {
        int damage = baseDamage * level;
        System.out.println(nama + " menyerang");
        return damage;
    }
    public int serang(String namaSkill, int manaCost) {
        if (mana >= manaCost) {
            mana -= manaCost;
            int damage = baseDamage * level * 2;
            System.out.println(nama + " menggunakan skill " + namaSkill);
            return damage;
        }
        System.out.println("Mana tidak cukup");
        return 0;
    }
    @Override
    public void bertahan() {
        isDefending = true;
        System.out.println(nama + " bersiaga");
    }
    @Override
    public void gunakanItem() {
        hp += 30;
        System.out.println(nama + " menggunakan potion");
    }
    @Override
    public void tampilkanStatus() {
        System.out.println("===== PAHLAWAN =====");
        System.out.println("Nama : " + nama);
        System.out.println("HP : " + hp);
        System.out.println("Mana : " + mana);
        System.out.println("Level : " + level);
    }
}