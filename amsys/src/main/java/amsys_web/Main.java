
package amsys_web;

import java.util.*;

class Student {
    // 属性（フィールド）
    String name;     // 名前
    int studentId;    // 学籍番号
    int grade;        // 学年

    // メソッド（動作）
    void study() {
        System.out.println(name + "さんは勉強中です！");
    }

    void takeExam() {
        System.out.println(name + "さんはテストを受けています！");
    }
}

// メインクラス
public class Main {
    public static void main(String[] args) {
        // 学生オブジェクトの作成
        Student yamada = new Student(); 
        yamada.name = "山田太郎";
        yamada.studentId = 12345;
        yamada.grade = 2;

        // メソッドの呼び出し
        yamada.study();  // 出力：山田太郎さんは勉強中です！
        yamada.takeExam();// 出力：山田太郎さんはテストを受けています！
    }
}
