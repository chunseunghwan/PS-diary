package programmers.practice.HashMap;

import java.util.HashMap;
import java.util.Objects;

// 과제 2) 논리적으로 같은 객체를 키로 넣으면 어떻게 되는가
public class Hash {
    // equals/hashCode를 오버라이드하지 않은 클래스 (Medium 글의 첫 번째 예제)
    static class PersonBad {
        String name;
        int id;

        PersonBad(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return name + "(" + id + ")";
        }
    }

    // equals/hashCode를 오버라이드한 클래스 (Medium 글의 두 번째 예제)
    static class PersonGood {
        String name;
        int id;

        PersonGood(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            PersonGood other = (PersonGood) obj;
            return id == other.id && Objects.equals(name, other.name);
        }

        @Override
        public String toString() {
            return name + "(" + id + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("===== [1] equals/hashCode 미오버라이드 =====");
        HashMap<PersonBad, String> bad = new HashMap<>();
        PersonBad b1 = new PersonBad("Alice", 1);
        PersonBad b2 = new PersonBad("Samar", 2);
        PersonBad b3 = new PersonBad("Alice", 1);   // b1과 논리적으로 같은 내용
        PersonBad b4 = new PersonBad("Alice", 1);
        bad.put(b1, "Engineer");
        bad.put(b2, "Tester");
        bad.put(b3, "Manager");
        bad.put(b4, "King");

        System.out.println("b1.hashCode() = " + b1.hashCode());
        System.out.println("b3.hashCode() = " + b3.hashCode());
        System.out.println("b1.equals(b3) = " + b1.equals(b3));
        System.out.println("map.size()    = " + bad.size() + "  (기대값 2)");
        System.out.println("map 내용      = " + bad);
        System.out.println("get(new Samar) = " + bad.get(new PersonBad("Samar", 2)));

        System.out.println();
        System.out.println("===== [2] equals/hashCode 오버라이드 =====");
        HashMap<PersonGood, String> good = new HashMap<>();
        PersonGood g1 = new PersonGood("Alice", 1);
        PersonGood g2 = new PersonGood("Samar", 2);
        PersonGood g3 = new PersonGood("Alice", 1);
        PersonGood g4 = new PersonGood("Alice", 1);
        good.put(g1, "Engineer");
        good.put(g2, "Tester");
        good.put(g3, "Manager");
        good.put(g4, "King");

        System.out.println("g1.hashCode() = " + g1.hashCode());
        System.out.println("g3.hashCode() = " + g3.hashCode());
        System.out.println("g1.equals(g3) = " + g1.equals(g3));
        System.out.println("map.size()    = " + good.size());
        System.out.println("map 내용      = " + good);
        System.out.println("get(new Samar) = " + good.get(new PersonGood("Samar", 2)));
    }
}