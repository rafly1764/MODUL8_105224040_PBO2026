package com.rpg.entitas;

import com.rpg.arena.Karakter;

public class Monster extends Karakter {

    private String jenisMonster;

    public Monster(String nama, int hp,
    int baseDamage, String jenisMonster) {

        super(nama, hp, baseDamage);

        this.jenisMonster = jenisMonster;
    }

    @Override
    public int serang() {

        System.out.println(nama + " menyerang");

        return baseDamage;
    }

    @Override
    public void bertahan() {

        hp += 10;

        System.out.println(nama + " memulihkan HP");
    }

    @Override
    public void gunakanItem() {

        System.out.println(nama + " tidak memiliki item");
    }

    @Override
    public void tampilkanStatus() {

        System.out.println("===== MONSTER =====");
        System.out.println("Nama : " + nama);
        System.out.println("Jenis : " + jenisMonster);
        System.out.println("HP : " + hp);
    }
}