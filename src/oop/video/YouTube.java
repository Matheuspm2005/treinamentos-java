package oop.video;

import javax.swing.*;

public class YouTube {
    public static void main(String[] args) {
        Viewer[] v = new Viewer[3];
        Video[] vi = new Video[2];

        v[0] = new Viewer("Mota", 20, 'M', "Mota360");
        v[1] = new Viewer("Maria", 20, 'F', "Maria123");
        v[2] = new Viewer("George", 27, 'M', "Geo1234");

        vi[0] = new Video("The History of Demon Slayer");
        vi[1] = new Video("The History of One Piece");

        Visualization viz1 = new Visualization(v[0], vi[1]);
        Visualization viz2 = new Visualization(v[0], vi[0]);
        Visualization viz3 = new Visualization(v[2], vi[0]);
        Visualization viz4 = new Visualization(v[1], vi[0]);

        viz1.rate(5);
        viz2.rate(3);
        viz3.rate(47.5f);
        viz4.rate(87.6f);

        System.out.println(viz1.toString());
        System.out.println(viz2.toString());
        System.out.println(viz3.toString());
        System.out.println(viz4.toString());
    }
}
