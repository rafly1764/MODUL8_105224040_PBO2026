package com.rpg.main;

import java.util.Scanner;

import com.rpg.entitas.Monster;
import com.rpg.entitas.Pahlawan;

public class GameEngine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama pahlawan : ");
        String nama = input.nextLine();

        Pahlawan hero = new Pahlawan(nama, 150, 20, 100, 2);
        Monster[] monster = {
            new Monster("Goblin", 50, 10, "Monster Hutan"),
            new Monster("Orc", 80, 15, "Monster Gua"),
            new Monster("Dragon", 120, 25, "Boss Dungeon")
        };
        for (int i = 0; i < monster.length; i++) {
            System.out.println("\nMusuh muncul : " + monster[i].getNama());
            while (hero.getHp() > 0 && monster[i].getHp() > 0) {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Serang");
                System.out.println("2. Skill");
                System.out.println("3. Bertahan / Heal");
                System.out.print("Pilihan : ");
                int pilih = input.nextInt();
                int damage;
                switch (pilih) {
                    case 1:
                        damage = hero.serang();
                        monster[i].terimaDamage(damage);
                        break;
                    case 2:
                        damage = hero.serang("Fire Slash", 20);
                        monster[i].terimaDamage(damage);
                        break;
                    case 3:
                        hero.bertahan();
                        hero.gunakanItem();
                        break;
                    default:
                        System.out.println("Pilihan tidak ada");
                }
                if (monster[i].getHp() > 0) {
                    int damageMonster = monster[i].serang();
                    hero.terimaDamage(damageMonster);
                }
                hero.tampilkanStatus();
                monster[i].tampilkanStatus();
            }
            if (hero.getHp() <= 0) {
                break;
            }
            System.out.println(monster[i].getNama() + " berhasil dikalahkan");
        }
        if (hero.getHp() > 0) {
            System.out.println("\nSelamat! Dungeon berhasil ditamatkan");
        } else {
            System.out.println("\nGame Over");
        }
        input.close();
    }
}